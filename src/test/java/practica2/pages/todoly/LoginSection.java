package practica2.pages.todoly;

import org.openqa.selenium.By;
import practica2.controls.Button;
import practica2.controls.TextBox;

public class LoginSection {
    public TextBox emailTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"));
    public TextBox pwdTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"));
    public Button loginButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"));

}
