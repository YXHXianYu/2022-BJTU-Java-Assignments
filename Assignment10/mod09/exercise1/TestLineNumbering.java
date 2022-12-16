/**
 * @author YXH_XianYu
 * Created On 2022-05-17
 */

import java.io.*;

public class TestLineNumbering {
    public static void main(String[] args) {
        try {
            // input
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            // output
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[0])));
            // work
            int i = 0;
            String str;
            while((str = input.readLine()) != null) {
                i++;
                output.write(i + ": " + str + "\n");
            }
            output.flush();
            // end
            input.close();
            output.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
