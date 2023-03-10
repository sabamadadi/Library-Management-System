import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    /*
    * The library should have a list of books.
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */
    static ArrayList<Book> books = new ArrayList<Book>();
    static ArrayList<User> users = new ArrayList<User>();
    static ArrayList<Librarian> librarians = new ArrayList<Librarian>();

    static Authenticator authenticator;

    public Library() {
        authenticator = new Authenticator();
        Librarian admin = new Librarian("admin", this);
        librarians.add(admin);
    }

    public void addBook(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the book:");
        String name = cs.nextLine();
        System.out.println("Enter author of the book:");
        String author = cs.nextLine();
        System.out.println("Enter year of publish of the book:");
        int yop = Integer.parseInt(cs.nextLine());
        System.out.println("Enter ISBN of the book:");
        int cnt = Integer.parseInt(cs.nextLine());

        Book newbook = new Book(name, author, yop, cnt);

        books.add(newbook);
        return;
    }

    public void removeBook(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the book:");
        String name = cs.nextLine();
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).name.equals(name)) {
                books.remove(i);
                return;
            }
        }
        return;
    }

    public void searchBook(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the book:");
        String name = cs.nextLine();
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).name.equals(name)) {
                System.out.println(books.get(i).name);
                System.out.println(books.get(i).author);
                System.out.println(books.get(i).yop);
                System.out.println(books.get(i).cnt);
            }
        }
        System.out.println("Book doesn't exist");
        return;
    }

    public void updateBook(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the book:");
        String name = cs.nextLine();
        System.out.println("Enter new numbers of the book:");
        int cnt = Integer.parseInt(cs.nextLine());
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).name.equals(name)) {
                books.get(i).cnt = cnt;
                return;
            }
        }
        return;
    }

    public boolean doesBookExist(String name){
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void increaseBook(String name){
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).name.equals(name)) {
                books.get(i).cnt += 1;
            }
        }
        return;
    }

    public void decreaseBook(String name){
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).name.equals(name)) {
                books.get(i).cnt -= 1;
            }
        }
        return;
    }

    //user related functions

    public User loginUser() {
        String username = authenticator.Userlogin();
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).name.equals(username)) {
                return users.get(i);
            }
        }
        User user = new User("NA", this);
        return user;
    }

    public User addUser(){
        String username = authenticator.UserRegister();
        if(username == "NA") {
            User user = new User("NA", this);
            return user;
        }
        User NEW = new User(username, this);
        users.add(NEW);
        return NEW;
    }

    public void removeUser(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the user:");
        String name = cs.nextLine();
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).name.equals(name)) {
                users.remove(i);
                authenticator.UserRemove(name);
                return;
            }
        }
        return;
    }

    public void searchUser(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the user:");
        String name = cs.nextLine();
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).name.equals(name)) {
                System.out.println(users.get(i).name);
                return;
            }
        }
        System.out.println("User doesn't exist");
        return;
    }

    public void updateUser(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the user:");
        String name = cs.nextLine();
        System.out.println("Enter new password of the user:");
        String newpass = cs.nextLine();
        authenticator.UserUpdate(name, newpass);
        return;
    }

    public boolean doesUserExist(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the user:");
        String name = cs.nextLine();
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    //librarian related functions
    public Librarian loginLibrarian() {
        String username = authenticator.Librarianlogin();
        for(int i = 0; i < librarians.size(); i++) {
            if(librarians.get(i).name.equals(username)) {
                return librarians.get(i);
            }
        }
        Librarian tmp = new Librarian("NA", this);
        return tmp;
    }

    public void addLibrarian(){
        String username = authenticator.LibrarianRegister();
        if(username == "NA") {
            return;
        }
        Librarian NEW = new Librarian(username, this);
        librarians.add(NEW);
        return;
    }

    public void removeLibrarian(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the librarian:");
        String name = cs.nextLine();
        for(int i = 0; i < librarians.size(); i++) {
            if(librarians.get(i).name.equals(name)) {
                librarians.remove(i);
                authenticator.LibrarianRemove(name);
                return;
            }
        }
        return;
    }

    public void searchLibrarian(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the librarian:");
        String name = cs.nextLine();
        for(int i = 0; i < librarians.size(); i++) {
            if(librarians.get(i).name.equals(name)) {
                System.out.println(librarians.get(i).name);
                return;
            }
        }
        System.out.println("Librarian doesn't exist");
        return;
    }

    public void updateLibrarian(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the librarian:");
        String name = cs.nextLine();
        System.out.println("Enter new password of the librarian:");
        String newpass = cs.nextLine();
        authenticator.LibrarianUpdate(name, newpass);
        return;
    }

    public boolean doesLibrarianExist(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter name of the librarian:");
        String name = cs.nextLine();
        for(int i = 0; i < librarians.size(); i++) {
            if(librarians.get(i).name.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
