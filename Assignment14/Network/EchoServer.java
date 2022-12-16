import java.io.*;
import java.net.*;

/**
 * @author YXH_XianYu
 * Created On 2022-06-16
 */
public class EchoServer {
    // singleton pattern
    private static EchoServer Instance = null;
    private static EchoServer getInstance() {
        if(Instance == null)
            Instance = new EchoServer();
        return Instance;
    }
    private EchoServer() {
    }

    // attributes
    // - network
    private int port = 4448;
    private ServerSocket serverSocket;
    private Socket client;
    private BufferedReader in;
    private BufferedWriter out;
    private RemoteReaderThread reader;
    // - io
    private BufferedReader fileIn;


    // output
    private void send(String str) {
        try {
            out.write(str + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // input
    private class RemoteReaderThread extends Thread {
        @Override
        public void run() {
            try {
                while(true) {
                    String str = in.readLine();
                    if(str == null || str.equals("")) continue;
                    // if(str.equals("exit")) break;
                    int value = Integer.parseInt(str);
                    send(getLines(value));
                }
            } catch (IOException e) {
                System.out.println(e);
            } catch (NumberFormatException e) {
                // 数字格式错误，无视
            }
        }
    }
    // input from file
    private String getLines(int value) {
        StringBuilder ans = new StringBuilder();
        String input;
        try {
            for(int i = 1; i <= value; i++) {
                input = fileIn.readLine();
                if(input == null) {
                    ans.append("No more lines").append(" ## ");
                    break;
                }
                ans.append(input).append(" ## ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans.toString();
    }

    // launch
    private void launch() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server starts.");
            client = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            fileIn = new BufferedReader(new InputStreamReader(new FileInputStream("multiLines.txt")));

            reader = new RemoteReaderThread();
            reader.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // psvm
    public static void main(String[] args) {
        EchoServer.getInstance().launch();
    }

}
