/**
 * @author YXH_XianYu
 * Created On 2022-05-25
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

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


        f.setBounds(400, 200, 500, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.launchFrame();
    }
}
