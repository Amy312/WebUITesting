package basicWeb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TodolyTest {
    ChromeDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("http://todo.ly/");
    }
    @Test
    public void verifyLoginTest() throws InterruptedException {
        // login
        String project = "p90";
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("ambarrojasm@gmail.com");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("Amys4n23");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        // add Project
        chrome.findElement(By.xpath("//div[@class=\"AddProjectLiDiv\"]")).click();
        chrome.findElement(By.id("NewProjNameInput")).sendKeys(project);
        chrome.findElement(By.id("NewProjNameButton")).click();

        // verify is created
        chrome.findElement(By.xpath("//div[@class=\"AddProjectLiDiv\"]")).click();
        Thread.sleep(2000);

        Assertions.assertTrue((chrome.findElements(By.xpath("//td[@class='ProjItemContent'][text()='"+project+"']")).size()==1), "Error");
        String itemIdValue = chrome.findElement(By.cssSelector("td.ProjItemContent")).getAttribute("itemId");
        //update the project
        chrome.findElement(By.xpath("//td[@class='ProjItemContent'][text()='"+project+"']")).click();
        Thread.sleep(2000);
        chrome.findElement(By.xpath("//td[@@class='ItemIndicator']")).click();

        chrome.findElement(By.xpath("//li[@class='edit']")).click();

        // verificar si existe el control del logout

        Assertions.assertTrue((chrome.findElements(By.xpath("//a[text()='Logout']")).size() == 1),
                "ERROR no se pudo ingresar a la sesion");

        Thread.sleep(5000);
    }

    @AfterEach
    public void close(){
        chrome.quit();
    }
}
