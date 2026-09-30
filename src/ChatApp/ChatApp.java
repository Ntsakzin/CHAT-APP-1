/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ChatApp;

import java.util.Scanner;

/**
 *
 * @author nkuna 
 */
public class ChatApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the username: ");
        String username = input.nextLine();
        
        System.out.println("Enter Password: ");
        String password = input.nextLine();
        
        System.out.println("Enter cell phone number(with +27): ");
        String cellPhoneNumber =input.nextLine();
        
        System.out.println(" Enter your first name: ");
        String firstName = input.nextLine();
        
        System.out.println("Enter your last name: ");
        String lastName = input.nextLine();
        
        RegistrationLogIn user = new RegistrationLogIn(username, password, cellPhoneNumber, firstName,lastName);
        
        
        System.out.println( "Registration feedback");
        System.out.println(user.registerUser());
        
        System.out.println("Enter username to login: ");
        String loginUsername = input.nextLine(); 
        
        System.out.println("Enter password to log in: ");
        String loginPassword = input.nextLine();
        
        
        boolean loginResult = user.loginUser(loginUsername, loginPassword);
        System.out.println(user.returnLoginStatus(loginResult));
        
        input.close();
    }
    
}

