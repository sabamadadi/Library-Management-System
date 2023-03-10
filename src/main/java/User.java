import java.util.ArrayList;
import java.util.Scanner;

public class User {
    static String name;
    static ArrayList<String> books = new ArrayList<String>();
    static Library library;

    public User(String username, Library input_library) {
        name = username;
        library = input_library;
    }

    public void rentBook(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the book:");
        String name = cs.nextLine();
        if(library.doesBookExist(name)) {
            library.decreaseBook(name);
            books.add(name);
        }
        return;
    }

    public void returnBook(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the book:");
        String name = cs.nextLine();
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).equals(name)) {
                books.remove(i);
                library.increaseBook(name);
                return;
            }
        }
        return;
    }
}
