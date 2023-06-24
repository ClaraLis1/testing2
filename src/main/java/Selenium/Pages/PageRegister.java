package Selenium.Pages;

import Selenium.Base.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;



public class PageRegister extends BasePage {
    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By address = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zipCode = By.id("customer.address.zipCode");
    By phone = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");
    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By passwordConfirm = By.id("repeatedPassword");
    By buttonRegister = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");
    By result = By.xpath("//*[@id=\"rightPanel\"]/p");
    Faker faker = new Faker();
     String userName = faker.name().firstName();

    public void register () throws InterruptedException {

        typeInfo("Clara",firstName);
        typeInfo("Lisle",lastName);
        typeInfo("Av San Martin",address);
        typeInfo("Tandil",city);
        typeInfo("Buenos Aires",state);
        typeInfo("12345",zipCode);
        typeInfo("123456789",phone);
        typeInfo("12345",ssn);
        typeInfo(userName+123456,username);
        typeInfo("123456",password);
        typeInfo("123456",passwordConfirm);
        click(buttonRegister);
        wait(5,result,"You are now logged in");
        getText(result);
        compareData(result,"You are now logged in");
    }

}
