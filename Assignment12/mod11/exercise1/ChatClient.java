/**
 * @author YXH_XianYu
 * Created On 2022-05-25
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ChatClient {
    private JTextArea textArea;
    private JTextField textField;
    private JButton sendButton;
    private JButton quitButton;

    public ChatClient() {
        textArea = new JTextArea(10, 50);
        textField = new JTextField(50);
        sendButton = new JButton("Send");
        quitButton = new JButton("Quit");
    }

    public void launchFrame() {
        JFrame f = new JFrame("Chat Room");

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
        layout.setConstraints(sendButton, c);
        f.add(sendButton);
        // quitButton
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridy = 1;
        layout.setConstraints(quitButton, c);
        f.add(quitButton);
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

        f.setBounds(400, 200, 500, 300);
        f.setVisible(true);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.launchFrame();
    }

    // ??????Send????????????????????????inner class???????????????
    class SendActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // ??????????????????????????????????????????????????????
            textArea.append("Client: " + textField.getText() + "\n");
            textField.setText("");
        }
    }

    // ??????Quit?????????????????????
    class QuitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    // ???????????????
    // ?????????????????????????????????WindowAdapter???????????????????????????????????????
    class QuitWindowListener implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {}
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
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

    // ???????????????
    class EnterKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                // ??????????????????????????????????????????????????????
                textArea.append("Client: " + textField.getText() + "\n");
                textField.setText("");
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {}
    }
}
