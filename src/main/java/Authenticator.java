import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Authenticator {
    static ArrayList<String> users_usernames = new ArrayList<String>(List.of("admin"));
    static ArrayList<Integer> users_passwords = new ArrayList<Integer>(List.of(0));


    static ArrayList<String> librarians_usernames = new ArrayList<String>(List.of("admin"));
    static ArrayList<Integer> librarians_passwords = new ArrayList<Integer>(List.of(0));

    public static int Hash(String password) {
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
            if(librarians_usernames.get(i) == name && librarians_passwords.get(i) == hash_password){
                return ("L" + name);
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
            if(users_usernames.get(i) == name && users_passwords.get(i) == hash_password){
                return ("U" + name);
            }
        }
        return ("NA");
    }

    public static String UserRegister() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Username");
        String name = cs.nextLine();
        for(int i = 0; i < users_usernames.size(); i++) {
            if(users_usernames.get(i) == name){
                System.out.println("username already exists !");
                return ("NA");
            }
        }
        System.out.println("Enter Password");
        String password = cs.nextLine();
        int hash_password = Hash(password);
        users_usernames.add(name);
        users_passwords.add(hash_password);
        return("U" + name);
    }

    public static String LibrarianRegister() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Username");
        String name = cs.nextLine();
        for(int i = 0; i < librarians_usernames.size(); i++) {
            if(librarians_usernames.get(i) == name){
                System.out.println("username already exists !");
                return ("NA");
            }
        }
        System.out.println("Enter Password");
        String password = cs.nextLine();
        int hash_password = Hash(password);
        users_usernames.add(name);
        users_passwords.add(hash_password);
        return("L" + name);
    }

    public static void LibrarianRemove(String name) {
        for(int i = 0; i < librarians_usernames.size(); i++) {
            if(librarians_usernames.get(i) == name) {
                librarians_usernames.remove(i);
                librarians_passwords.remove(i);
                return;
            }
        }
        return;
    }

    public static void UserRemove(String name) {
        for(int i = 0; i < users_usernames.size(); i++) {
            if(users_usernames.get(i) == name) {
                users_usernames.remove(i);
                users_passwords.remove(i);
                return;
            }
        }
        return;
    }

    public static void LibrarianUpdate(String name, String password) {
        int hash_password = Hash(password);
        for(int i = 0; i < librarians_usernames.size(); i++) {
            if(librarians_usernames.get(i) == name) {
                librarians_passwords.set(i, hash_password);
                return;
            }
        }
        return;
    }

    public static void UserUpdate(String name, String password) {
        int hash_password = Hash(password);
        for(int i = 0; i < users_usernames.size(); i++) {
            if(users_usernames.get(i) == name) {
                users_passwords.set(i, hash_password);
                return;
            }
        }
        return;
    }
}
