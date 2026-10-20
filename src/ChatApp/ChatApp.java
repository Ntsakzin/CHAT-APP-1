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
        
        
        if (loginResult){
            
            int option;
            do{
                System.out.println("Welcome to QuickChat");
                System.out.println("1.Send Messages");
                System.out.println("2.Show recently sent messages(Coming Soon)");
                System.out.println("3.Quit");
                
                option = input.nextInt();
                input.nextLine();
                
                if (option ==1){
                    System.out.println("How many messages would you like to send?");
                    
                    int numMessages =input.nextInt();
                    input.nextLine();
                    
                    for (int i = 1; i<= numMessages; i++){
                        System.out.println("\nMessage" + i);
                        System.out.println("Enter recipient number");
                        String recipient = input.nextLine();
                        
                        while(!recipient.matches("^\\+27\\d{9}$")){
                            System.out.println("Cell phone number incorrectly formatted");
                            System.out.println("Enter recipient number again");
                            recipient = input.nextLine();
                        }
                        
                        
                        System.out.println("Enter message");
                        String messageText = input.nextLine();
                        
                        while(messageText.length() >250){
                            
                            System.out.println("Please enter a message of less than 250 characters.");
                            messageText = input.nextLine();
                        }
                        
                        Messaging msg = new Messaging(recipient,messageText,i);
                        
                        System.out.println("\nSelect an option");
                        System.out.println("1.Send Message");
                        System.out.println("2.Discard Message");
                        System.out.println("3.Store Message to send later");
                        
                        int sendOption = input.nextInt();
                        input.nextLine();
                        
                        System.out.println(msg.SentMessage(sendOption));
                        
                        if (sendOption ==1){
                            
                            System.out.println(msg.printMessages());
                        }
                        
                        else if (sendOption ==2){
                            
                            System.out.println("Press 0 to delete the message");
                            
                            int delete = input.nextInt();
                            input.nextLine();
                            
                            if (delete==0){
                                
                                System.out.println("Message discarded");
                            }
                        }
                        
                        else if (sendOption==3){
                            
                            System.out.println("Message successfully stored");
                        }
                        
                        System.out.println("\nTotal Messages sent:" + Messaging.returnTotalMessages());
                        
                        
                        
                        
                        
                    }
                    
                       
                }
                else if (option == 2){
                        System.out.println("Coming soon.");
                        
                        }
                else if (option == 3){
                        System.out.println("Goodbye.");
                            }
                
            }while(option !=3);
        }
        
        
        input.close();
    }
    
}

