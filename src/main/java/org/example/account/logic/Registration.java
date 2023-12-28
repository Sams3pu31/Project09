package org.example.account.logic;

import org.example.account.exception.WrongLoginException;
import org.example.account.exception.WrongPasswordException;

public class Registration {

    private final Account account;

    public Registration(Account account) {
        this.account = account;
    }

    public void registerNewUser(String login, String password, String confirmPassword) {
        try {
            if (account.checkIfUserExists(login)) {
                System.out.println("Пользователь с таким логином уже зарегистрирован.");
            } else {
                account.checkLogin(login);
                account.checkPassword(password, confirmPassword);
                account.addUserCredentials(login, password);
                System.out.println("Пользователь успешно зарегистрирован!");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка при регистрации: " + e.getMessage());
        }
    }
}
