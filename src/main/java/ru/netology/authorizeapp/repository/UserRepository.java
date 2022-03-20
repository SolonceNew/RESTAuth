package ru.netology.authorizeapp.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizeapp.authorities.Authorities;

import java.util.*;

import static ru.netology.authorizeapp.authorities.Authorities.*;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("admin") && password.equals("1234")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("Vanya") && password.equals("12345")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else { return Collections.EMPTY_LIST;
        }
        return authorities;
    }
}

