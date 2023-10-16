package practica2.testSuites;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import practica2.pages.todoly.DashboardSection;
import practica2.pages.todoly.LoginSection;
import practica2.pages.todoly.MainPage;
import practica2.pages.todoly.MenuSection;
import practica2.session.Session;

public class Test1 {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
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
    public void createProjectCreateItemAndUpdateItem() throws InterruptedException {

        //1st - LOGIN
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("ambarrojasm@gmail.com");
        loginSection.pwdTextBox.setText("Amys4n23");
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no me pude iniciar sesion");

        //2nd - Create Project
        String projectName = "prueba8";
        menuSection.addProjectButton.click();
        menuSection.newProjectTextBox.setText(projectName);
        menuSection.addButton.click();
        Thread.sleep(2000);

        menuSection.setNewProjectButton(projectName);
        Assertions.assertTrue(menuSection.newProjectButton.isControlDisplayed(), "Error, no se creo el proyecto");


        //3rd - Create Item
        String itemName = "Item6";
        menuSection.newProjectButton.click();
        dashboardSection.addItemTextBox.setText(itemName);
        dashboardSection.addItemButton.click();

        dashboardSection.setItemContent(itemName);
        Assertions.assertTrue(dashboardSection.itemContentTextBox.isControlDisplayed(), "Error, no se creo el item");
        Thread.sleep(2000);

        //4th - Update Item
        String newItemName = "Soy nuevo";
        dashboardSection.itemContentButton.click();
        dashboardSection.itemUpdateTextBox.clearSetText(newItemName);
        Thread.sleep(2000);
        //dashboardSection.itemUpdateTextBox.typeEnter();

        dashboardSection.setItemContentUpdated(newItemName);
        Thread.sleep(2000);
        Assertions.assertTrue(dashboardSection.itemContentTextBox.isControlDisplayed(), "Error, no se actualizo el item");




    }
}
