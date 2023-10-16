package practica2.testSuites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practica2.pages.todoly.*;
import practica2.session.Session;

public class Test3 {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    SettingsPage settingsPage = new SettingsPage();
    DashboardSection dashboardSection = new DashboardSection();
    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
    }

    @Test
    public void updateFullName() throws InterruptedException {

        //1st - LOGIN
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("ambarrojasm@gmail.com");
        loginSection.pwdTextBox.setText("Amys4n23");
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");

        //2nd - Go to settings
        menuSection.settingsButton.click();

        // 3rd - Change Full Name
        String name = "Ambar Rojas Morales 23";
        settingsPage.fullNameTextBox.clearSetText(name);
        settingsPage.okButton.click();
        Thread.sleep(3000);

        // 4th - verify change
        menuSection.settingsButton.click();
        Thread.sleep(3000);
        Assertions.assertEquals(name, settingsPage.fullNameTextBox.getValue(), "Error, no se creo el proyecto");

    }
}
