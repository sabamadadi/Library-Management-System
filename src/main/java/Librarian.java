public class Librarian {
    /*
     The librarian should have a username and a password
     The librarian should be able to search users, librarians and books
     The librarian should be able to add\\remove\\update user add\\remove\\update
     librarian and add\\remove\\update book
    */
    static String name;
    static Library library;

    public Librarian(String username, Library input_library) {
        name = username;
        library = input_library;
    }

    public void SearchBook(){
        library.searchBook();
        return;
    }
    public void AddBook(){
        library.addBook();
        return;
    }
    public void RemoveBook(){
        library.removeBook();
        return;
    }
    public void UpdateBook(){
        library.updateBook();
        return;
    }

    public void SearchUser(){
        library.searchUser();
        return;
    }
    public void AddUser(){
        library.addUser();
        return;
    }
    public void RemoveUser(){
        library.removeUser();
        return;
    }
    public void UpdateUser(){
        library.updateUser();
        return;
    }

    public void SearchLibrarian(){
        library.searchLibrarian();
        return;
    }
    public void AddLibrarian(){
        library.addLibrarian();
        return;
    }
    public void RemoveLibrarian(){
        library.removeLibrarian();
        return;
    }
    public void UpdateLibrarian(){
        library.updateLibrarian();
        return;
    }
}
