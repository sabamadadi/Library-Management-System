import java.util.Scanner;

public class Main {
    /*
     * make a functional library app using oop
     * run the main program in Main.java and code the oop part in other classes
     * don't forget to add at least 1 librarian to the library to make it functionable.
     * *  *** don't limit yourself to our template ***
     */

    static Library library;
    static User curUser;
    static Librarian curLibrarian;
    static boolean isuserlogin;
    static boolean islibrarianlogin;
    public static void main(String[] args) {
        library = new Library();
        isuserlogin = false;
        islibrarianlogin = false;
        while(true) {
            runMenu();
        }
    }

    public static void runMenu(){
        Scanner cs = new Scanner(System.in);
        if((!isuserlogin) && (!islibrarianlogin)) {
            System.out.println("1. Login Librarian");
            System.out.println("2. Login User");
            System.out.println("3. Register User");

            int input = Integer.parseInt(cs.nextLine());
            if(input == 1) {
                curLibrarian = library.loginLibrarian();
                if(!curLibrarian.name.equals("NA")) {
                    islibrarianlogin = true;
                }
            }
            else if(input == 2) {
                curUser = library.loginUser();
                if(!curUser.name.equals("NA")) {
                    isuserlogin = true;
                }
            }
            else if(input == 3) {
                curUser = library.addUser();
                if(!curUser.name.equals("NA")) {
                    isuserlogin = true;
                }
            }
        }
        else if(isuserlogin) {
            System.out.println("1. Rent a book");
            System.out.println("2. Return a book");
            System.out.println("3. Logout");

            int input = Integer.parseInt(cs.nextLine());
            if(input == 1) {
                curUser.rentBook();
            }
            else if(input == 2) {
                curUser.returnBook();
            }
            else if(input == 3) {
                isuserlogin = false;
            }
        }
        else {
            System.out.println("1. Search an user");
            System.out.println("2. Search a librarian");
            System.out.println("3. Search a book");
            System.out.println("4. Add a user");
            System.out.println("5. Remove a user");
            System.out.println("6. Update a user");
            System.out.println("7. Add a librarian");
            System.out.println("8. Remove a librarian");
            System.out.println("9. Update a librarian");
            System.out.println("10. Add a book");
            System.out.println("11. Remove a book");
            System.out.println("12. Update a book");
            System.out.println("13. Logout");

            int input = Integer.parseInt(cs.nextLine());
            if(input == 1) {
                curLibrarian.SearchUser();
            }
            else if(input == 2) {
                curLibrarian.SearchLibrarian();
            }
            else if(input == 3) {
                curLibrarian.SearchBook();
            }
            else if(input == 4) {
                curLibrarian.AddUser();
            }
            else if(input == 5) {
                curLibrarian.RemoveUser();
            }
            else if(input == 6) {
                curLibrarian.UpdateUser();
            }
            else if(input == 7) {
                curLibrarian.AddLibrarian();
            }
            else if(input == 8) {
                curLibrarian.RemoveLibrarian();
            }
            else if(input == 9) {
                curLibrarian.UpdateLibrarian();
            }
            else if(input == 10) {
                curLibrarian.AddBook();
            }
            else if(input == 11) {
                curLibrarian.RemoveBook();
            }
            else if(input == 12) {
                curLibrarian.UpdateBook();
            }
            else if(input == 13) {
                islibrarianlogin = false;
            }
        }
        return;
    }
}
