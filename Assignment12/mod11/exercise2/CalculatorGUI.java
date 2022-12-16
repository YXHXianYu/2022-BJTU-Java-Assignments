import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class CalculatorGUI {
    // JButtons and a place to put them.
    private JButton key0, key1, key2, key3, key4;
    private JButton key5, key6, key7, key8, key9;
    private JButton keyequal, keyplus, keyminus;
    private JButton keyperiod, keymult, keydiv;
    private JPanel buttonArea;

    // Where answer will be displayed.
    private JLabel answer;
    private boolean isDefault; // 检测是否需要重置answer

    public CalculatorGUI() {
        answer = new JLabel("0",JLabel.RIGHT);
        isDefault = true;

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
                constraints.gridx = j;
                constraints.gridy = i;
                constraints.weightx = 1;
                constraints.weighty = 1;
                constraints.insets = new Insets(2, 2, 2, 2);
                constraints.fill = GridBagConstraints.BOTH;
                addButton(buttonArea, layout, constraints, buttons[cnt]);
                buttons[cnt].addActionListener(new CalcListener());
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

    class CalcListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = ((JButton)e.getSource()).getText();
            checkDefault();
            switch (button) {
                case "0" -> answer.setText(answer.getText() + "0");
                case "1" -> answer.setText(answer.getText() + "1");
                case "2" -> answer.setText(answer.getText() + "2");
                case "3" -> answer.setText(answer.getText() + "3");
                case "4" -> answer.setText(answer.getText() + "4");
                case "5" -> answer.setText(answer.getText() + "5");
                case "6" -> answer.setText(answer.getText() + "6");
                case "7" -> answer.setText(answer.getText() + "7");
                case "8" -> answer.setText(answer.getText() + "8");
                case "9" -> answer.setText(answer.getText() + "9");
                case "+" -> answer.setText(answer.getText() + '+');
                case "-" -> answer.setText(answer.getText() + '-');
                case "*" -> answer.setText(answer.getText() + '*');
                case "/" -> answer.setText(answer.getText() + '/');
                case "." -> answer.setText(answer.getText() + '.');
                case "=" -> answer.setText(calculate(answer.getText()));
            }
        }
        // 此函数保证表达式不为
        private void checkDefault() {
            if(isDefault)  {
                answer.setText("");
                isDefault = false;
            }
        }
        /*
        找不到Calculator类在哪里，而且看起来并不能自动实现运算符优先级处理，因此自己写了一个。
        说不定以后也用得上233
        利用栈计算表达式，加减不处理，乘除小数点直接处理
         */
        private String calculate(String str) {
            // 下次输入其他键，直接重置值。
            isDefault = true;

            // 数组从1开始使用
            double[] num = new double[101]; // 数值
            int[] opt = new int[101]; // 类型(0数字, 1+, 2-, 3*, 4/)
            int n = 0; // 栈中元素个数

            // 第三个参数true，表示保留分隔符，不然无法计算
            StringTokenizer st = new StringTokenizer(str, "+-*/", true);

            // Test
            // while(st.hasMoreTokens()) System.out.println(st.nextToken());

            while(st.hasMoreTokens()) {
                String curStr = st.nextToken();
                switch (curStr) {
                    case "+" -> {num[++n] = 0; opt[n] = 1;}
                    case "-" -> {num[++n] = 0; opt[n] = 2;}
                    case "*" -> {num[++n] = 0; opt[n] = 3;}
                    case "/" -> {num[++n] = 0; opt[n] = 4;}
                    // case "." -> {num[++n] = 0; opt[n] = 5;}
                    default -> {
                        double curNum;
                        try {
                            curNum = Double.parseDouble(curStr);
                        } catch (NumberFormatException e) {
                            return "Error(5)"; // 输入错误
                        }
                        if(n >= 2 && (3 <= opt[n] && opt[n] <= 5)) {
                            switch (opt[n]) {
                                case 3 -> {num[n - 1] *= curNum; n--;}
                                case 4 -> {num[n - 1] /= curNum; n--;}
                            }
                        } else {
                            num[++n] = curNum;
                            opt[n] = 0;
                        }
                    }
                }
                // 表达式末尾是运算符，输入错误
                if(n == 1 && opt[n] != 0) return "Error(1)";

                // 连续运算符，只保留最后一个
                while(n >= 2 && opt[n] != 0 && opt[n - 1] != 0) {
                    opt[n - 1] = opt[n];
                    n--;
                    // return "Error";
                }
            }

            // 表达式末尾是运算符，输入错误
            if(opt[n] != 0) return "Error(2)";
            // 这里n应该是奇数，不然就是有bug
            if((n & 1) == 0) return "Error(3)"; // 我觉得error3不能被触发

            double sum = num[1];
            for(int i = 2; i <= n; i += 2) {
                if(opt[i] == 1) sum += num[i + 1];
                else if(opt[i] == 2) sum -= num[i + 1];
                else return "Error(4)"; // 我觉得error4不能被触发
            }

            return Double.toString(sum);
        }
    }
}
