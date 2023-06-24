package Selenium.Pages;

import Selenium.Base.BasePage;
import org.openqa.selenium.By;

public class PageAccountActivity extends BasePage {

    By buttonAccountOverview = By.xpath(" //*[@id=\"leftPanel\"]/ul/li[2]");
    By confirmation = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");
    By account = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    By periodo = By.xpath("//*[@id=\"month\"]/option[1]");
    By type = By.xpath("//*[@id=\"transactionType\"]/option[1]");
    By buttonGo = By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input");

    public void accountMovements () throws InterruptedException {
        click(buttonAccountOverview);
        Thread.sleep(2000);
        wait(5,confirmation, "Balance includes deposits that may be subject to holds");
        getText(confirmation);
        compareData(confirmation,"Balance includes deposits that may be subject to holds");
        click(account);
        Thread.sleep(2000);
        click(periodo);
        click(type);
        click(buttonGo);
    }
}
