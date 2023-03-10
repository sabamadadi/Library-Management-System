import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Authenticator {
    static ArrayList<String> users_usernames = new ArrayList<String>();
    static ArrayList<Integer> users_passwords = new ArrayList<Integer>();


    static ArrayList<String> librarians_usernames = new ArrayList<String>();
    static ArrayList<Integer> librarians_passwords = new ArrayList<Integer>();

    public Authenticator() {
        librarians_usernames.add("admin");
        librarians_passwords.add(Hash("admin"));
    }

    private static int Hash(String password) {
        int MOD = 1000847, Base = 256;
        int ans = 0;
        for(int i = 0; i < password.length(); i++) {
            ans = (ans * Base) + (int)password.charAt(i);
            ans %= MOD;
        }
        return ans;
    }

    public static String Librarianlogin() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Username");
        String name = cs.nextLine();
        System.out.println("Enter Password");
        String password = cs.nextLine();
        int hash_password = Hash(password);

        for(int i = 0; i < librarians_usernames.size(); i++) {
            if((librarians_usernames.get(i).equals(name)) && (librarians_passwords.get(i) == hash_password)){
                return (name);
            }
        }
        return ("NA");
    }

    public static String Userlogin() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Username");
        String name = cs.nextLine();
        System.out.println("Enter Password");
        String password = cs.nextLine();
        int hash_password = Hash(password);

        for(int i = 0; i < users_usernames.size(); i++) {
            if(users_usernames.get(i).equals(name) && users_passwords.get(i) == hash_password){
                return (name);
            }
        }
        return ("NA");
    }

    public static String UserRegister() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Username");
        String name = cs.nextLine();
        for(int i = 0; i < users_usernames.size(); i++) {
            if(users_usernames.get(i).equals(name)){
                System.out.println("username already exists !");
                return ("NA");
            }
        }
        System.out.println("Enter Password");
        String password = cs.nextLine();
        int hash_password = Hash(password);
        users_usernames.add(name);
        users_passwords.add(hash_password);
        return(name);
    }

    public static String LibrarianRegister() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Username");
        String name = cs.nextLine();
        for(int i = 0; i < librarians_usernames.size(); i++) {
            if(librarians_usernames.get(i).equals(name)){
                System.out.println("username already exists !");
                return ("NA");
            }
        }
        System.out.println("Enter Password");
        String password = cs.nextLine();
        int hash_password = Hash(password);
        librarians_usernames.add(name);
        librarians_passwords.add(hash_password);
        return(name);
    }

    public static void LibrarianRemove(String name) {
        for(int i = 0; i < librarians_usernames.size(); i++) {
            if(librarians_usernames.get(i).equals(name)) {
                librarians_usernames.remove(i);
                librarians_passwords.remove(i);
                return;
            }
        }
        System.out.println("Librarian doesn't exist");
        return;
    }

    public static void UserRemove(String name) {
        for(int i = 0; i < users_usernames.size(); i++) {
            if(users_usernames.get(i).equals(name)) {
                users_usernames.remove(i);
                users_passwords.remove(i);
                return;
            }
        }
        System.out.println("User doesn't exist");
        return;
    }

    public static void LibrarianUpdate(String name, String password) {
        int hash_password = Hash(password);
        for(int i = 0; i < librarians_usernames.size(); i++) {
            if(librarians_usernames.get(i).equals(name)) {
                librarians_passwords.set(i, hash_password);
                System.out.println(password);
                return;
            }
        }
        System.out.println("Librarian doesn't exist");
        return;
    }

    public static void UserUpdate(String name, String password) {
        int hash_password = Hash(password);
        for(int i = 0; i < users_usernames.size(); i++) {
            if(users_usernames.get(i).equals(name)) {
                users_passwords.set(i, hash_password);
                return;
            }
        }
        System.out.println("User doesn't exist");
        return;
    }
}
