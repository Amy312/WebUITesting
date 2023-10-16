package practica2.pages.todoly;

import org.openqa.selenium.By;
import practica2.controls.Button;
import practica2.controls.TextBox;

public class SettingsPage {
    public TextBox fullNameTextBox = new TextBox(By.id("FullNameInput"));
    public Button okButton = new Button(By.xpath("//span[@class=\"ui-button-text\"][text()=\"Ok\"]"));
}
