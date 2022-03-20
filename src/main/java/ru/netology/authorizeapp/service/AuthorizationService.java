package ru.netology.authorizeapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.authorizeapp.authorities.Authorities;
import ru.netology.authorizeapp.exceptions.InvalidCredentials;
import ru.netology.authorizeapp.exceptions.UnauthorizedUser;
import ru.netology.authorizeapp.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorizationService {

    UserRepository userRepository;

    public List<Authorities> getAuthorities(String userName, String password) {
        if (isEmpty(userName) || isEmpty(password)) {
            throw new InvalidCredentials("user or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(userName, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("unknown user" + userName);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private  boolean isEmpty(List<?> str) {
        return  str == null || str.isEmpty();
    }
}
