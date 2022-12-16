/**
 * @author YXH_XianYu
 * Created On 2022-06-16
 */

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ChatServer {
    private static ChatServer Instance = null;
    private int port = 2077;
    private ServerSocket serverSocket;
    private ArrayList<Client> clients;

    private ChatServer() {
    }

    public static ChatServer getInstance() {
        if(Instance == null)
            Instance = new ChatServer();
        return Instance;
    }

    private void serverStart() {
        try {
            serverSocket = new ServerSocket(port);
            clients = new ArrayList<>();
            System.out.println("Server started.");
            while(true) {
                Client client = new Client(clients.size() + 1, serverSocket.accept());
                client.start();
                System.out.println("Client#"+client.number + " have been created.");
                clients.add(client);
            }
        } catch (BindException e) {
            System.out.println("端口: " + String.valueOf(port) + " 已被占用");
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    private void sendMessageToClients(String message) {
        System.out.println("Sending \"" + message + "\" to all clients.");
        for(int i = 0; i < clients.size(); i++)
            if(clients.get(i).isAlive())
                clients.get(i).send(message);
    }

    private class Client extends Thread {
        private int number;
        private Socket socket;
        private BufferedReader in;
        private BufferedWriter out;
        public Client(int number, Socket socket) {
            super();
            this.number = number;
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                System.out.println("客户端输入输出流异常");
            }
        }
        // input 接收客户端信息
        @Override
        public void run() {
            String str;
            try {
                while(true) {
                    Thread.sleep(100);

                    str = in.readLine();
                    if(str == null || str.equals("")) continue;
                    if(str.equals("exit")) break;
                    // 向所有客户端发送此条消息（包括本客户端）
                    System.out.println("Client#" + number + " received: \"" + str + "\"");
                    ChatServer.getInstance().sendMessageToClients(str);
                }
                System.out.println("Client#" + number + " is closing.");
                socket.close();
            } catch (InterruptedException | IOException e) {
                System.out.println("Exception: " + e);
            }
        }
        // output 向客户端发送信息
        public void send(String str) {
            if(!this.isAlive()) return;
            try {
                out.write(str + "\n");
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception: " + e);
            }
        }
    }

    public static void main(String[] args) {
        ChatServer.getInstance().serverStart();
    }
}
