package MyDropBookmarks.core;


import java.security.Principal;

public class User implements Principal {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }


    @Override
    public String getName() {
        return name;
    }
}
