package practicaEnClase.testSuites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practicaEnClase.pages.todoist.ChangePass;
import practicaEnClase.pages.todoist.LoginPage;
import practicaEnClase.pages.todoist.MenuSection;
import practicaEnClase.pages.todoist.SettingsPage;
import practicaEnClase.session.Session;


public class changePasswordTest {
    LoginPage loginPage = new LoginPage();
    MenuSection menuSection = new MenuSection();

    SettingsPage settingsPage = new SettingsPage();
    ChangePass changePass = new ChangePass();

    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://app.todoist.com/");
    }

    @Test
    public void verifyChangePassword() throws InterruptedException {
        // 1st - Login
        String email = "amy@san.com";
        String newPass = "panques1t0"; // change order newPass with pass
        String  pass= "Amys4n23"; // change order pass with newPass
        loginPage.emailTextBox.setText(email);
        loginPage.pwdTextBox.setText(pass);
        loginPage.loginButton.click();

        Assertions.assertTrue(menuSection.addTaskButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");

        // 2nd - Go to settings
        menuSection.informationButton.click();
        menuSection.settingsButton.click();

        // 3rd - Change password

        settingsPage.changePassButton.click();
        Thread.sleep(2000);

        changePass.actualPassTextBox.setText(pass);

        changePass.newPassTextBox.setText(newPass);
        changePass.confirmNewPassTextBox.setText(newPass);

        changePass.sendPassButton.click();
        Thread.sleep(2000);

        // 4th - Close session
        settingsPage.closePage.click();
        menuSection.informationButton.click();
        menuSection.closeSession.click();

        // 5th - Verify Login with the new password
        loginPage.emailTextBox.setText(email);
        loginPage.pwdTextBox.setText(newPass);
        loginPage.loginButton.click();

        Assertions.assertTrue(menuSection.addTaskButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");

    }

}
