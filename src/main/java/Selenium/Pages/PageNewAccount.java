package Selenium.Pages;

import org.openqa.selenium.By;
import Selenium.Base.BasePage;
import static Selenium.Base.BasePage.click;


public class PageNewAccount extends BasePage {

    By buttonNewAccount = By.xpath(" //*[@id=\"leftPanel\"]/ul/li[1]/a");
    By buttonOpenNewAccount = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input");
    By confirmation = By.id("rightPanel");


    public void createAccount () throws InterruptedException {

        click(buttonNewAccount);
        Thread.sleep(2000);
        click(buttonOpenNewAccount);
        wait(5,confirmation, "Congratulations, your account is now open.");
        getText(confirmation);
        compareData(confirmation,"Congratulations, your account is now open");
    }
}
