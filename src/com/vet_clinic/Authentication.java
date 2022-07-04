package com.vet_clinic;

import java.util.Scanner;

/**
 * javadoc
 * Authentication class
 * @autor Kamila LoL
 * @version 1.0
 */

public class Authentication {

    private static final String LOGIN = "kamila"; //Логин
    private static final String PASSWORD = "pass"; //Пароль

    // Метод возвращающий число "0" - успешно или "-1" - не успешно
    public void authenticate(){
        Scanner s = new Scanner(System.in);

        boolean isLoginSuccess = false; // успешно(true) или нет(false)

        for(int maxCount = 3; maxCount>0 && !isLoginSuccess; maxCount--) {
            System.out.print("Login: ");
            var login = s.nextLine();

            System.out.print("Password: ");
            var password = s.nextLine();

            if (validate(login, password)) {
                isLoginSuccess = true;
            } else {
                System.out.println("Password is incorrect. Please try again. ");
            }
        }
        if(!isLoginSuccess){
            throw new RuntimeException("Login failed");
        }

    }
    public boolean validate(String login, String password) {

        return login.equals(LOGIN) && password.equals(PASSWORD);
    }

}
