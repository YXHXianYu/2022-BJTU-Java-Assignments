import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;

public class CalculatorGUI {
    // JButtons and a place to put them.
    private JButton key0, key1, key2, key3, key4;
    private JButton key5, key6, key7, key8, key9;
    private JButton keyequal, keyplus, keyminus;
    private JButton keyperiod, keymult, keydiv;
    private JPanel buttonArea;

    // Where answer will be displayed.
    private JLabel answer;

    public CalculatorGUI() {
        answer = new JLabel("0.0",JLabel.RIGHT);

        key0 = new JButton("0");
        key1 = new JButton("1");
        key2 = new JButton("2");
        key3 = new JButton("3");
        key4 = new JButton("4");
        key5 = new JButton("5");
        key6 = new JButton("6");
        key7 = new JButton("7");
        key8 = new JButton("8");
        key9 = new JButton("9");
        keyequal = new JButton("=");
        keyplus = new JButton("+");
        keyminus = new JButton("-");
        keymult = new JButton("*");
        keydiv = new JButton("/");
        keyperiod = new JButton(".");
        buttonArea = new JPanel();
    }

    private void addButton(JPanel panel, GridBagLayout layout, GridBagConstraints constraints, JButton button) {
        layout.setConstraints(button, constraints);
        panel.add(button);
    }

    private void launchFrame() {
        // button area
        // - layout
        GridBagLayout layout = new GridBagLayout();
        buttonArea.setLayout(layout);
        GridBagConstraints constraints;
        // - add buttons
        JButton[] buttons = {
                key7, key8, key9, keyplus,
                key4, key5, key6, keyminus,
                key1, key2, key3, keymult,
                key0, keyperiod, keyequal, keydiv,
        };
        for(int i = 0, cnt = 0; i <= 3; i++) {
            for(int j = 0; j <= 3; j++, cnt++) {
                constraints = new GridBagConstraints();
                constraints.gridx = i;
                constraints.gridy = j;
                constraints.weightx = 1;
                constraints.weighty = 1;
                constraints.insets = new Insets(2, 2, 2, 2);
                constraints.fill = GridBagConstraints.BOTH;
                addButton(buttonArea, layout, constraints, buttons[cnt]);
            }
        }


        // frame
        JFrame f = new JFrame("Calculator");
        f.setBounds(300, 300, 250, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setLayout(new BorderLayout(0, 4));
        f.add(answer, BorderLayout.NORTH);
        f.add(buttonArea, BorderLayout.CENTER);

        f.setVisible (true);
    }

    public static void main(String args[]) {
        CalculatorGUI calcGUI = new CalculatorGUI();
        calcGUI.launchFrame();
    }
}
