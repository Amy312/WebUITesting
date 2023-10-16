package clases.basicWeb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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
        String project = "pancito de 33miel";
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

        //update the project
        String updatedProject = "pan234 23paw";

        chrome.findElement(By.xpath("//td[@class='ProjItemContent'][text()='"+project+"']")).click();
        Thread.sleep(2000);
        List<WebElement> findProject = chrome.findElements(
                By.xpath(String.format("//tr[td[@class='ProjItemContent' and text()='"+project+"']]")));
        WebElement lastProjectCreated = findProject.get(0);
        lastProjectCreated.click();
        lastProjectCreated.findElement(By.xpath(".//div[@class='ProjItemMenu']/img")).click();

        chrome.findElement(By.xpath("//ul[@id=\"projectContextMenu\"]/li[@class='edit']")).click();
        chrome.findElement(By.id("ItemEditTextbox")).clear();
        chrome.findElement(By.id("ItemEditTextbox")).sendKeys(updatedProject);
        chrome.findElement(By.id("ItemEditSubmit")).click();

        Thread.sleep(2000);
        Assertions.assertTrue((chrome.findElements(By.xpath("//td[@class='ProjItemContent'][text()='"+updatedProject+"']")).size()==1), "Error");


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
