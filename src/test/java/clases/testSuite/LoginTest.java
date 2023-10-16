package clases.testSuite;

import clases.pages.LoginSection;
import clases.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clases.pages.MainPage;
import clases.pages.MenuSection;

public class LoginTest {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void loginTesting(){
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("selenium@seleniumupb.com");
        loginSection.pwdTextBox.setText("12345");
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");

    }
}
