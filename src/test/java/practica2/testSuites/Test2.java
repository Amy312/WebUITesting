package practica2.testSuites;


import practica2.pages.todoist.MenuSection;
import practica2.session.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practica2.pages.todoist.LoginPage;

public class Test2 {
    LoginPage loginPage = new LoginPage();
    MenuSection menuSection = new MenuSection();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://app.todoist.com/");
    }

    @Test
    public void loginTestingTodoist(){
        loginPage.emailTextBox.setText("amy@san.com");
        loginPage.pwdTextBox.setText("Amys4n23");
        loginPage.loginButton.click();

        Assertions.assertTrue(menuSection.addTaskButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");

    }
}
