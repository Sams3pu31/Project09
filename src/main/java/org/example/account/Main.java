package org.example.account;
import org.example.account.exception.WrongLoginException;
import org.example.account.exception.WrongLoginOrPasswordException;
import org.example.account.exception.WrongPasswordException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        account.addUserCredentials("Mariam", "password123");
        account.addUserCredentials("Nikita", "qwerty123");

        try {
            System.out.print("Введите логин: ");
            String inputLogin = scanner.nextLine();
            account.checkLogin(inputLogin);

            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            System.out.print("Подтвердите пароль: ");
            String confirmPassword = scanner.nextLine();

            account.checkPassword(password, confirmPassword);
            String result = account.checkLoginAndPassword(inputLogin, password);
            System.out.println(result);
            if (result.equals("Вы успешно вошли в аккаунт!")) {
                System.out.println("Текущий логин: " + account.getLogin());
                System.out.println("Текущий пароль: " + account.getPassword());
            }
        } catch (WrongLoginException | WrongPasswordException | WrongLoginOrPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

