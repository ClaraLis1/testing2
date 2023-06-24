package Selenium.Pages;

import Selenium.Base.BasePage;
import org.openqa.selenium.By;

public class PageAccountOverview extends BasePage {

        By buttonAccountOverview = By.xpath(" //*[@id=\"leftPanel\"]/ul/li[2]");
        By confirmation = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");


        public void viewAccount () throws InterruptedException {
            click(buttonAccountOverview);
            Thread.sleep(2000);
            wait(5,confirmation, "Balance includes deposits that may be subject to holds");
            getText(confirmation);
            compareData(confirmation,"Balance includes deposits that may be subject to holds");
        }
    }


