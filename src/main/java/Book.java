public class Book {
    //Book should contain name,author,year of publish and ISBN
    static String name;
    static String author;
    static int yop;
    static int cnt;

    public Book(String input_name, String input_author, int input_yop, int input_cnt) {
        name = input_name;
        author = input_author;
        yop = input_yop;
        cnt = input_cnt;
    }
}
