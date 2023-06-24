package Selenium.Pages;

import Selenium.Base.BasePage;
import org.openqa.selenium.By;

public class PageTransferFunds extends BasePage {

    By buttonTransferFunds = By.xpath(" //*[@id=\"leftPanel\"]/ul/li[3]");
    By amount = By.id("amount");
    By fromAccount = By.xpath("//*[@id=\"fromAccountId\"]/option[1]");
    By toAccount = By.xpath("//*[@id=\"toAccountId\"]/option[2]");

    By buttonTransferSubmit = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input");
    By confirmation = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");


    public void transferFunds () throws InterruptedException {
        click(buttonTransferFunds);
        Thread.sleep(2000);
        typeInfo("1000", amount);
        click(fromAccount);
        click(toAccount);
        click(buttonTransferSubmit);
        wait(5,confirmation, "Transfer Complete!");
        getText(confirmation);
        compareData(confirmation,"Transfer Complete!");
    }
}
