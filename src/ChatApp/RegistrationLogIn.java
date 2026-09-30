/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChatApp;

import java.util.regex.Pattern;

/**
 *
 * @author nkuna
 */
public class RegistrationLogIn {
    
    public String username;
    public String password;
    public String cellPhoneNumber;
    public String firstName;
    public String lastName;
    
    
  public RegistrationLogIn(String username,String password, String cellPhoneNumber,String firstName, String lastName ){
         this.username = username;
         this.password = password ;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        
    }
  public boolean checkUserName(){
      if(username.contains("_") && username.length()<=5){
          
          return true;
      }
      else{ 
    
      return false ;
  }
      
  }

    public boolean checkPasswordComplexity(){
       
        boolean length = password.length()>= 8;
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.chars().anyMatch(c->!Character.isLetterOrDigit(c));
        
        return length && hasUpper && hasDigit && hasSpecial;
    }
    public boolean checkCellPhoneNumber(){
        
        return Pattern.matches("^\\+27\\d{9}$", cellPhoneNumber);
    }
    
    public String registerUser(){ 
        StringBuilder result = new StringBuilder();
        if(checkUserName()){
            result.append("Username successfully captured.\n");
        } else {
            result.append("Username incorrect ,please ensure username is no more than five characters in length and contains an underscore.\n");
        }
        if(checkPasswordComplexity()){
            result.append("Password succesfully captured.\n");
        } else{
            result.append("Password incorrectly formatted,please ensure password contains eight characters, a capital letter,number, and specialcharcter\n");
        }
        if(checkCellPhoneNumber()){
            result.append("cell phone number succesfully added.\n");
           
        } else{
            result.append("cell phone number incorrectly formatted\n");
        }
        return result.toString();
    }
    public boolean loginUser(String enteredUsername, String enteredPassword){
        
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }
    public String returnLoginStatus(boolean loginSuccessful){
        if (loginSuccessful){
            return "Welcome " + firstName + " " + lastName + " it is wonderful to see you again.";
        }
        else{
            return "Username or Password incorrect, please try again.";
        }
      
        
    }
}
