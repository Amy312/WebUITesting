package practica2.pages.todoist;

import org.openqa.selenium.By;
import practica2.controls.Button;

public class MenuSection {
    public Button addTaskButton = new Button(By.xpath("//button[@data-track=\"navigation|quick_add\"]"));
}
