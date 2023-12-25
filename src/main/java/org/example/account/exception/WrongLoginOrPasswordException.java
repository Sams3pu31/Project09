package org.example.account.exception;
public class WrongLoginOrPasswordException extends Exception {
    public WrongLoginOrPasswordException(String message) {
        super(message);
    }
}
