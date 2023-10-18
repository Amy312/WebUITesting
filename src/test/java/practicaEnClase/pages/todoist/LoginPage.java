package practicaEnClase.pages.todoist;

import org.openqa.selenium.By;
import practicaEnClase.controls.Button;
import practicaEnClase.controls.TextBox;

public class LoginPage {
    public TextBox emailTextBox = new TextBox(By.id("element-0"));
    public TextBox pwdTextBox = new TextBox(By.id("element-3"));
    public Button loginButton = new Button(By.xpath("//button[@data-gtm-id=\"start-email-login\"]"));
}
