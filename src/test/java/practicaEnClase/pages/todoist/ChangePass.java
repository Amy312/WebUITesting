package practicaEnClase.pages.todoist;

import org.openqa.selenium.By;
import practicaEnClase.controls.Button;
import practicaEnClase.controls.TextBox;

public class ChangePass {
    public TextBox actualPassTextBox = new TextBox(By.xpath("//span[contains(text(),'actual')]/../../..//input"));
    public TextBox newPassTextBox = new TextBox(By.xpath("//span[contains(text(),'Nueva')]/../../..//input"));
    public TextBox confirmNewPassTextBox = new TextBox(By.xpath("//span[contains(text(),'Confirmar nueva')]/../../..//input"));

    public Button sendPassButton = new Button(By.xpath("//span[contains(text(),'Cambiar')]/../..//button"));

}
