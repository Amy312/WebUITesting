package practicaEnClase.pages.todoist;

import org.openqa.selenium.By;
import practicaEnClase.controls.Button;

public class MenuSection {
    public Button addTaskButton = new Button(By.xpath("//button[@data-track=\"navigation|quick_add\"]"));

    public Button informationButton = new Button(By.id(":r0:"));
    public Button settingsButton = new Button(By.id("user_menu_settings_menuitem"));
    public Button closeSession = new Button(By.xpath("//span[contains(text(),'Cerrar')]"));
}
