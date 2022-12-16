public class TestExceptions {
    public static void main(String[] args) {
        try {
            for ( int i = 0; true; i++ ) {
                System.out.println("args[" + i + "] is '" + args[i] + "'");
            }
        } catch(java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        }
        System.out.println("Quiting...");
    }
}
