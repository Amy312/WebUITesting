package clases.pages;

import clases.controls.Button;
import org.openqa.selenium.By;

public class MenuSection {
    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));
}
