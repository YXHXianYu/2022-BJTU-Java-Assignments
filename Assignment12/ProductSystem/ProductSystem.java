import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class ProductSystem extends JFrame {
    // 1. Components
    final private JLabel inputTip;

    final private JLabel nameLabel;
    final private JTextField nameText;
    final private JLabel priceLabel;
    final private JTextField priceText;
    final private JLabel numberLabel;
    final private JTextField numberText;

    final private JButton addButton;
    final private JButton saveButton;
    final private JButton displayButton;

    final private JTextArea textArea;

    // 2. constants
    static private int WINDOW_WIDTH = 500;
    static private int WINDOW_HEIGHT = 300;

    // 3. data
    private ArrayList<Product> products;

    public ProductSystem() {
        super("Product System by.YXH_XianYu");

        // 1. Components
        inputTip = new JLabel("Please Input Product Information:");

        nameLabel = new JLabel("Name");
        nameText = new JTextField();
        priceLabel = new JLabel("Price");
        priceText = new JTextField();
        numberLabel = new JLabel("Number");
        numberText = new JTextField();

        addButton = new JButton("Add");
        saveButton = new JButton("Save to File");
        displayButton = new JButton("Display");

        textArea = new JTextArea();
        textArea.setEditable(false);

        // 3. Data
        products = new ArrayList<>();
    }

    public static void main(String[] args) {
        ProductSystem productSystem = new ProductSystem();
        productSystem.initializeGUI();
        productSystem.initializeListeners();
    }



    private void initializeListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameText.getText().equals("") || priceText.getText().equals("") || numberText.getText().equals("")) {
                    textArea.setText("Please enter data.");
                    return;
                }

                Product product;
                try {
                    product = new Product(nameText.getText(), Double.parseDouble(priceText.getText()), Integer.parseInt(numberText.getText()));
                } catch (NumberFormatException exception) {
                    textArea.setText("Please correct data.");
                    return;
                }

                products.add(product);
                textArea.setText("Add Product " + product.getName() + " success!\n");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter writer = new FileWriter(new File("product.txt"));
                    writer.write(getProductsString());
                    writer.flush();
                    writer.close();
                } catch (IOException exception) {
                    textArea.setText("file write fail.");
                    return;
                }
                textArea.setText("file write success.");
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(getProductsString());
            }
        });
    }

    private String getProductsString() {
        StringBuilder str = new StringBuilder();
        for(Product i: products)
            str.append(i.getName() + "\t" + i.getPrice() + "\t" + i.getNumber() + "\n");
        return str.toString();
    }

    /**
     * 创建GUI
     *
     * 写了一个下午，没写出来，被布局管理器折磨了。
     * 最后其他同学跟我说了个奇技淫巧，就是不用布局管理器，直接设置绝对坐标。
     * 恍然大悟了。
     *
     * 所以本程序GUI不用布局管理器。
     */
    private void initializeGUI() {
        setLayout(null); // 圣经

        setResizable(false); // 不准拉伸屏幕√

        addComponent(inputTip, 150, 0, 200, 20);
        int stx = 15;
        int sty = 26;
        addComponent(nameLabel, stx, sty, 40, 20);
        addComponent(nameText, stx + 40,sty, 100, 20);
        addComponent(priceLabel, stx + 145,sty, 37, 20);
        addComponent(priceText, stx + 145 + 37, sty, 100, 20);
        addComponent(numberLabel, stx + 290, sty, 50, 20);
        addComponent(numberText, stx + 290 + 50, sty, 100, 20);
        stx = 115;
        sty = 55;
        addComponent(addButton, stx, sty, 60, 25);
        addComponent(saveButton, stx + 60 + 5, sty, 100, 25);
        addComponent(displayButton, stx + 160 + 10, sty, 75, 25);

        addComponent(textArea, 5, 90, WINDOW_WIDTH - 27, WINDOW_HEIGHT - 135);

        // 显示GUI
        setBounds(200, 200, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addComponent(Component c, int x, int y, int w, int h) {
        c.setBounds(x, y, w, h);
        add(c);
    }


    /*
    弃用代码。
    private JPanel createRow2Panel() {
        JPanel tmp2 = new JPanel(); // 第二层的中间容器
        GridBagLayout layout2 = new GridBagLayout();
        tmp2.setLayout(layout2);
        GridBagConstraints c2 = new GridBagConstraints(); // 第二层layout的约束类

        final double weight1 = 0.1;
        final double weight2 = 1.0;

        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.insets = new Insets(2, 2, 2, 2);
        c2.gridwidth = 1;
        c2.gridy = 0; // 行

        c2.weightx = weight1;
        c2.gridx = 0; // 列
        tmp2.add(nameLabel, c2);

        c2.weightx = weight2;
        c2.gridx = 1;
        tmp2.add(nameText, c2);

        c2.weightx = weight1;
        c2.gridx = 2;
        tmp2.add(priceLabel, c2);

        c2.weightx = weight2;
        c2.gridx = 3;
        tmp2.add(priceText, c2);

        c2.weightx = weight1;
        c2.gridx = 4;
        tmp2.add(numberLabel, c2);

        c2.weightx = weight2;
        c2.gridx = 5;
        tmp2.add(numberText, c2);

        return tmp2;
    }

    private JPanel createRow3Panel() {
        JPanel tmp3 = new JPanel();
        tmp3.setLayout(new BoxLayout(tmp3, BoxLayout.X_AXIS));
        tmp3.add(addButton);
        tmp3.add(Box.createRigidArea(new Dimension(6, 0)));
        tmp3.add(saveButton);
        tmp3.add(Box.createRigidArea(new Dimension(6, 0)));
        tmp3.add(displayButton);
        return tmp3;
    }
    */

}
