/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ChatApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nkuna
 */




public class RegistrationLogInTest {

    @Test
    public void testCheckUserNameValid() {
        RegistrationLogIn user = new RegistrationLogIn("usr_1", "Password@123", "+27831234567", "John", "Doe");
        assertTrue(user.checkUserName());
    }

    @Test
    public void testCheckUserNameInvalid() {
        RegistrationLogIn user = new RegistrationLogIn("user123", "Password@123", "+27831234567", "John", "Doe");
        assertFalse(user.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexityValid() {
        RegistrationLogIn user = new RegistrationLogIn("usr_1", "Password@123", "+27831234567", "John", "Doe");
        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexityInvalid() {
        RegistrationLogIn user = new RegistrationLogIn("usr_1", "pass", "+27831234567", "John", "Doe");
        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumberValid() {
        RegistrationLogIn user = new RegistrationLogIn("usr_1", "Password@123", "+27831234567", "John", "Doe");
        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumberInvalid() {
        RegistrationLogIn user = new RegistrationLogIn("usr_1", "Password@123", "0831234567", "John", "Doe");
        assertFalse(user.checkCellPhoneNumber());
    }

    @Test
    public void testRegisterUserSuccess() {
        RegistrationLogIn user = new RegistrationLogIn("usr_1", "Password@123", "+27831234567", "John", "Doe");
        assertEquals("User registered successfully!", user.registerUser());
    }

    @Test
    public void testRegisterUserFailUsername() {
        RegistrationLogIn user = new RegistrationLogIn("user123", "Password@123", "+27831234567", "John", "Doe");
        assertTrue(user.registerUser().contains("Username is not correctly formatted"));
    }

    @Test
    public void testLoginUserSuccess() {
        RegistrationLogIn user = new RegistrationLogIn("usr_1", "Password@123", "+27831234567", "John", "Doe");
        assertTrue(user.loginUser("usr_1", "Password@123"));
    }

    @Test
    public void testLoginUserFail() {
        RegistrationLogIn user = new RegistrationLogIn("usr_1", "Password@123", "+27831234567", "John", "Doe");
        assertFalse(user.loginUser("usr_1", "WrongPass"));
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        RegistrationLogIn user = new RegistrationLogIn("usr_1", "Password@123", "+27831234567", "John", "Doe");
        assertEquals("Welcome John Doe , it is great to see you again.", user.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginStatusFail() {
        RegistrationLogIn user = new RegistrationLogIn("usr_1", "Password@123", "+27831234567", "John", "Doe");
        assertEquals("Username or password incorrect, please try again.", user.returnLoginStatus(false));
    }
}
