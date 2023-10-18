package practicaEnClase.pages.todoist;

import org.openqa.selenium.By;
import practicaEnClase.controls.Button;
import practicaEnClase.controls.TextBox;

public class SettingsPage {
    public Button changePassButton = new Button(By.xpath("//a[@class=\"_8313bd46 _54d56775 _5e45d59f _2a3b75a1 _56a651f6\"][@href=\"/app/settings/account/password\"]"));

    public Button  closePage = new Button(By.xpath("//button[@class=\"dOAUdcnSj9gBY1w5ax6aQxa5xcA8ASxf\"]"));


}
