/**
 * @author YXH_XianYu
 * Created On 2022-05-25
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClient {
    // about gui
    final private JTextArea textArea;
    final private JTextField textField;
    final private JButton sendButton;
    final private JButton quitButton;
    final private JComboBox<String> comboBox;
    final private JFrame f;
    // about socket
    private Socket connection;
    private BufferedWriter serverOut; // 输出流
    private BufferedReader serverIn; // 输入流
    private String serverIP = "127.0.0.1";
    private int serverPort = 2077;
    private Thread thread;


    public ChatClient() {
        textArea = new JTextArea(10, 50);
        textField = new JTextField(50);
        sendButton = new JButton("发送");
        quitButton = new JButton("退出");
        comboBox = new JComboBox<>(new String[] {
                "Cocoa",
                "Erina",
                "Rumi",
                "Rita",
                "Irisu",
                "Saya",
                "Noah",
                "Miru",
        });
        f = new JFrame("聊天室");
    }

    public void launchFrame() {

        /* 1. make the GUI */

        // layout
        GridBagLayout layout = new GridBagLayout();
        f.setLayout(layout);
        // constraints
        GridBagConstraints c;
        // textArea
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        textAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 5;
        c.gridheight = 5;
        layout.setConstraints(textAreaScroll, c);
        f.add(textAreaScroll);
        // sendButton
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.insets = new Insets(5, 5, 5, 5);
        sendButton.setBackground(Color.getHSBColor(0, 0, 1));
        layout.setConstraints(sendButton, c);
        f.add(sendButton);
        // quitButton
        c.gridy = 1;
        quitButton.setBackground(Color.getHSBColor(0, 0, 1));
        layout.setConstraints(quitButton, c);
        f.add(quitButton);

        // choiceBox
        JPanel choiceBox = new JPanel();
        choiceBox.setLayout(new BoxLayout(choiceBox, BoxLayout.Y_AXIS));
        JLabel choiceBoxTmp = new JLabel("名字: ");
        choiceBoxTmp.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        choiceBox.add(choiceBoxTmp);
        choiceBox.add(comboBox);
        c.gridy = 2;
        layout.setConstraints(choiceBox, c);
        f.add(choiceBox);

        // textField
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 5;
        c.weighty = 0.2;
        c.gridwidth = 6;
        c.insets = new Insets(5, 5, 5, 5);
        layout.setConstraints(textField, c);
        f.add(textField);

        // event
        sendButton.addActionListener(new SendActionListener());
        quitButton.addActionListener(new QuitActionListener());
        f.addWindowListener(new QuitWindowListener());
        textField.addKeyListener(new EnterKeyListener());
        textArea.setEditable(false);

        // menu
        f.setJMenuBar(createMenuBar());

        f.getContentPane().setBackground(Color.getHSBColor(0, 0, 0.95f));
        f.getJMenuBar().setBackground(Color.getHSBColor(0, 0, 0.90f));

        f.setBounds(400, 200, 500, 300);

        /* 2. establish socket connection */
        /* 4. instantiate the streams from the socket connection */

        try {
            connection = new Socket(serverIP, serverPort);
            serverIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            serverOut = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        } catch (IOException e) {
            System.out.println("Exception: " + e);
            exitGUI(-1);
        }

        /* 3. make a thread and start it with an instance of RemoteReader */
        thread = new RemoteReader();
        thread.start();

        /* 5. show the GUI */
        f.setVisible(true);
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.launchFrame();
    }

    /* common methods */
    // 结束程序的方法。
    private void exitGUI(int status) {
        System.out.println("exiting");
        try {
            serverOut.write("exit\n");
            serverOut.flush();
            connection.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        } catch (NullPointerException e) {
            ; // do nothing, because server was not found.
        }
        System.exit(status);
    }

    // 发送信息至服务器的方法。
    private void sendMessage(String str) {
        try {
            System.out.println("send: \"" + str + "\"");
            serverOut.write(str + "\n");
            serverOut.flush();
        } catch (IOException exception) {
            System.out.println("Exception: " + exception);
        }
        textField.setText("");
    }


    /* socket methods */

    private class RemoteReader extends Thread {
        @Override
        public void run() {
            String str;
            while(true) {
                try {
                    str = serverIn.readLine();
                } catch (IOException e) {
                    break;
                }
                if(str == null || str.equals("")) continue;

                System.out.println("receive: \"" + str + "\"");
                textArea.append(str + "\n");
            }
            System.out.println("Client closed.");
        }
    }

    /* GUI methods */

    // 按下Send按钮的监听方法（inner class，新语法）
    class SendActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sendMessage(comboBox.getSelectedItem() + ": " + textField.getText());
        }
    }

    // 按下Quit按钮的监听方法
    class QuitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            exitGUI(0);
        }
    }

    // 窗口监听器
    // 也可以用通过继承抽象类WindowAdapter来实现，避免实现无需的方法
    class QuitWindowListener implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {}
        @Override
        public void windowClosing(WindowEvent e) {
            exitGUI(0);
        }
        @Override
        public void windowClosed(WindowEvent e) {}
        @Override
        public void windowIconified(WindowEvent e) {}
        @Override
        public void windowDeiconified(WindowEvent e) {}
        @Override
        public void windowActivated(WindowEvent e) {}
        @Override
        public void windowDeactivated(WindowEvent e) {}
    }

    // 按键监听器
    class EnterKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                sendMessage(comboBox.getSelectedItem() + ": " + textField.getText());
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {}
    }

    // 创建菜单栏
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createHelpMenu());
        return menuBar;
    }

    // 创建文件菜单
    private JMenu createFileMenu() {
        JMenu menu = new JMenu("文件");
        menu.add(new JMenuItem("打开"));
        menu.add(new JMenuItem("保存"));
        menu.addSeparator();
        JMenuItem item = new JMenuItem("退出");
        item.addActionListener(new QuitActionListener());
        menu.add(item);
        return menu;
    }

    // 创建帮助菜单
    private JMenu createHelpMenu() {
        JMenu menu = new JMenu("帮助");

        JMenuItem item = new JMenuItem("关于");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog();
                JOptionPane.showMessageDialog(f, "Message", "Title", JOptionPane.PLAIN_MESSAGE);
            }
        });
        menu.add(item);

        return menu;
    }
}
