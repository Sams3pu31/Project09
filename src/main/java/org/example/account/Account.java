package org.example.account;
import org.example.account.exception.WrongLoginException;
import org.example.account.exception.WrongLoginOrPasswordException;
import org.example.account.exception.WrongPasswordException;
import java.util.HashMap;
import java.util.Map;
public class Account {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        if (password != null) {
            return "*".repeat(password.length());
        } else {
            return null;
        }
    }

    private final Map<String, String> loginAndPasswordMap;

    public Account() {
        loginAndPasswordMap = new HashMap<>();
    }

    public void addUserCredentials(String login, String password) {
        loginAndPasswordMap.put(login, password);
    }

    public void checkLogin(String userInput) throws WrongLoginException {
        if ( userInput == null ||  userInput.trim().isEmpty()){
            throw new WrongLoginException("Логин не может быть пустым, заполните логин");
        } else if ( userInput.length() <= 5 || userInput.length() >= 20) {
            throw new WrongLoginException("Логин должен содержать от 6 до 19 символов");
        } else {
            this.login = userInput;
            System.out.println("Логин введен корректно: " + this.login);
        }
    }

    public void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password == null || password.trim().isEmpty()) {
            throw new WrongPasswordException("Пароль не может быть пустым, заполните пароль");
        }else if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
        }else if ( password.length() <= 8 || password.length() >= 20 ) {
            throw new WrongPasswordException("Пароль должен содержать от 9 до 19 символов");
        } else {
            this.password = password;
            System.out.println("Пароли совпадают");
        }
    }
    public String checkLoginAndPassword(String inputLogin, String inputPassword) throws WrongLoginOrPasswordException {
        if (loginAndPasswordMap.containsKey(inputLogin)) {
            String storedPassword = loginAndPasswordMap.get(inputLogin);
            if (storedPassword.equals(inputPassword)) {
                return "Вы успешно вошли в аккаунт!";
            } else {
                throw new WrongLoginOrPasswordException("Вы ввели неверный пароль от этой учетной записи");
            }
        } else {
            throw new WrongLoginOrPasswordException("Пользователь " + this.login + " не зарегистрирован");
        }
    }}
