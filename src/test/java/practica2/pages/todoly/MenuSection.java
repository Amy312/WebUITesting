package practica2.pages.todoly;

import org.openqa.selenium.By;
import practica2.controls.Button;
import practica2.controls.Control;
import practica2.controls.TextBox;

public class MenuSection {
    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));
    public Button settingsButton = new Button(By.xpath("//a[text()='Settings']"));

    public Button addButton = new Button(By.id("NewProjNameButton"));
    public Button newProjectButton;
    public Button addProjectButton = new Button(By.xpath("//div[@class=\"AddProjectLiDiv\"]"));
    public TextBox newProjectTextBox = new TextBox(By.id("NewProjNameInput"));

    public void setNewProjectButton(String projectName) {
        this.newProjectButton = new Button(By.xpath("//td[@class='ProjItemContent'][text()='"+projectName+"']"));
    }
}
