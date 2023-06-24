package Selenium.Pages;

import Selenium.Base.BasePage;
import org.openqa.selenium.By;

public class PageLogin extends BasePage {
    By name = By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input");
    By password = By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input");
    By buttonLogin = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    public void login () throws InterruptedException {
        typeInfo("clara1", name);
        typeInfo("123", password);
        click(buttonLogin);
        Thread.sleep(2000);
    }

}
