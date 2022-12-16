import java.io.*;

/**
 * @author YXH_XianYu
 * Created On 2022-05-17
 *
 * Record format: name#quantity#.........\n
 * name：记录的名字
 * quantity：记录的数量
 */
public class DBTest {
    private static BufferedReader input; // 终端输入(System.in)
    private static RandomAccessFile database; // 数据库(data.txt)
    private static final int length = 100; // length = 每条记录最大长度+2
    private static int num = -1; // 目前储存的数据条数 (-1: 未知)

    public static void main(String[] args) {

        // 初始化
        if(initialize()) return;

        // 主循环
        while(true) {

            // 显示菜单
            displayMenu();

            // 输入一行
            String[] strings;
            try {
                strings = input.readLine().split(" ");
            } catch (IOException e) {
                System.out.println("Exception: " + e);
                continue;
            }

            // 分析输入数据
            int opt, index = 0, quantity = 0;
            String name = "";
            try {
                opt = Integer.parseInt(strings[0]);
                if(opt == 2) {
                    index = Integer.parseInt(strings[1]);
                    name = strings[2];
                    quantity = Integer.parseInt(strings[3]);
                } else if(opt == 3) {
                    name = strings[1];
                    quantity = Integer.parseInt(strings[2]);
                } else if(opt == 4) {
                    index = Integer.parseInt(strings[1]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Exception: " + e);
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Exception: " + e);
                continue;
            }

            // 执行
            if(opt == 1) {
                displayRecords();
            } else if(opt == 2) {
                updateRecord(index, name, quantity);
            } else if(opt == 3) {
                addRecord(name, quantity);
            } else if(opt == 4) {
                removeRecord(index);
            } else if(opt == 5) {
                break;
            }
        }

        // end
        try {
            input.close();
            database.close();
        } catch (IOException e) {System.out.println("Exception: " + e);}
    }

    /**
     * 初始化
     * @return 如果初始化失败，返回true
     */
    private static boolean initialize() {
        try {
            input = new BufferedReader(new InputStreamReader(System.in));
            database = new RandomAccessFile("data.txt", "rw");
            return false;
        } catch (IOException e) {
            System.out.println("Exception: " + e);
            return true;
        }
    }

    /**
     * 显示菜单
     */
    private static void displayMenu() {
        System.out.println();
        System.out.println(" ----- menu begin ----- ");
        System.out.println(" 1.display all records [1]");
        System.out.println(" 2.update a record [2 Index Name Quantity]");
        System.out.println(" 3.add a new record [3 Name Quantity]");
        System.out.println(" 4.remove a record [4 Index]");
        System.out.println(" 5.quit [5]");
        System.out.println(" ----- menu end ----- ");

    }

    /**
     * 显示所有记录
     */
    private static void displayRecords() {
        try {
            database.seek(0);
            String str;
            System.out.println();
            System.out.println(" ----- records begin -----");
            int i;
            for (i = 1; (str = database.readLine()) != null; i++) {
                String[] strings = str.split("#");
                System.out.println(i + ": " + strings[0] + " - " + Integer.parseInt(strings[1]));
            }
            num = i - 1;
            System.out.println(" ----- records end ----- ");
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * 修改一条记录
     * @param index 要修改的记录编号
     * @param name 修改后的记录名字
     * @param quantity 修改后的记录数量
     */
    private static void updateRecord(int index, String name, int quantity) {
        if(index > num) {
            System.out.println("记录不存在");
            return;
        }
        try {
            database.seek((long) length * (index - 1));
            String str = name + "#" + quantity + "#"
                    + (" ").repeat(length - 3 - name.length() - (String.valueOf(quantity)).length())
                    + "\n";
            database.write(str.getBytes());
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * 新增一条记录
     * @param name 记录名字
     * @param quantity 记录数量
     */
    private static void addRecord(String name, int quantity) {
        if(num == -1) flushNum();
        try {
            database.seek((long) length * num);
            String str = name + "#" + quantity + "#"
                    + (" ").repeat(length - 3 - name.length() - (String.valueOf(quantity)).length())
                    + "\n";
            database.write(str.getBytes());
            num++;
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * 删除一条记录
     * @param index 要删除的记录编号
     */
    private static void removeRecord(int index) {
        if(num == -1) flushNum();
        try {
            String tmp;
            for(int i = index; i < num; i++) {
                database.seek((long) length * i);
                tmp = database.readLine();
                database.seek((long) length * (i - 1));
                database.write(tmp.getBytes());
            }
            num--;
            database.setLength((long) length * num);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * 刷新 num 的值
     */
    private static void flushNum() {
        try {
            database.seek(0);
            for (num = 1; (database.readLine()) != null; num++) ;
            num--;
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
