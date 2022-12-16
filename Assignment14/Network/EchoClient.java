/**
 * @author YXH_XianYu
 * Created On 2022-06-16
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class EchoClient {
    // 0. Singleton Pattern
    private static EchoClient Instance = null;
    private static EchoClient getInstance() {
        if(Instance == null)
            Instance = new EchoClient();
        return Instance;
    }
    private EchoClient() {
    }

    // 1. Attributes
    // 1.1 GUI
    private JFrame frame;
    private JLabel label;
    private JTextField textFieldInput;
    private JButton button;
    private JTextArea textAreaOutput;
    // 1.2 Network
    private Socket socket;
    private BufferedWriter out;
    private BufferedReader in;
    private String IP = "127.0.0.1";
    private int port = 4448;
    private RemoteReaderThread reader;

    // 2. Methods & Classes
    // 2.1 GUI
    private void GUIInit() {
        // Initialize
        frame = new JFrame("Product System");
        label = new JLabel("Please input the number of string lines to get from server:");
        textFieldInput = new JTextField();
        button = new JButton("send to server");
        textAreaOutput = new JTextArea();
        textAreaOutput.setEditable(false);
        // Position
        frame.setLayout(null);
        label.setBounds(10, 6, 335, 30);
        textFieldInput.setBounds(340, 6 + 5, 100, 20);
        button.setBounds(445, 6 + 2, 120, 26);
        textAreaOutput.setBounds(0, 42, 580, 300);
        frame.setBounds(300, 300, 595, 360);
        // Add components to frame
        frame.add(label);
        frame.add(textFieldInput);
        frame.add(button);
        frame.add(textAreaOutput);
        // event
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                send(textFieldInput.getText());
                textFieldInput.setText("");
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
    private void GUIStart() {
        frame.setVisible(true);
    }

    // 2.2 Network
    private void send(String str) {
        try {
            out.write(str + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void NetworkInit() {
        try {
            socket = new Socket(IP, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            System.out.println(e);
        }

        reader = new RemoteReaderThread();
        reader.start();
    }
    private class RemoteReaderThread extends Thread {
        @Override
        public void run() {
            try {
                while(true) {
                    String str = in.readLine();
                    if(str == null || str.equals("")) continue;
                    // if(str.equals("exit")) break;

                    textAreaOutput.append("get " + str.split(" ## ").length + " lines from server.\n");
                    textAreaOutput.append(str + "\n");

                    if(str.substring(str.length() - 17, str.length() - 4).equals("No more lines")) {
                        textAreaOutput.append("can not take lines anymore\n");
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    // 3. main
    private void launch() {
        GUIInit();
        NetworkInit();
        System.out.println("Client starts.");
        GUIStart();
    }
    public static void main(String[] args) {
        EchoClient.getInstance().launch();
    }

}
