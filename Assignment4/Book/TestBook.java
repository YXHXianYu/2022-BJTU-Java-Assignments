/**
 * @author YXH_XianYu
 * @create 2022-03-29
 */
public class TestBook {
    public static void main(String[] args) {

        Author[] authors = {
            new Author("Carol", "jl@as.com", 'g'),
            new Author("Diana", "jr@as.com", 'g'),
        };

        Book book1 = new Book( "C++", authors, 2, 3);
        Book book2 = new Book("A-SOUL", authors, 1);

        System.out.println("Test Construct1 & toString: \n" + book1);
        System.out.println();

        Author[] authors_cpy = book2.getAuthors();
        System.out.println("Test Construct2 & getAuthors: \n" + authors_cpy[0].getName());
        System.out.println();

        System.out.println("Test getAuthorNames: \n" + book2.getAuthorNames());
    }
}
