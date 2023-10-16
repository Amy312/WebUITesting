package practica2.pages.todoist;

import org.openqa.selenium.By;
import practica2.controls.Button;
import practica2.controls.TextBox;

public class LoginPage {
    public TextBox emailTextBox = new TextBox(By.id("element-0"));
    public TextBox pwdTextBox = new TextBox(By.id("element-3"));
    public Button loginButton = new Button(By.xpath("//button[@data-gtm-id=\"start-email-login\"]"));
}
