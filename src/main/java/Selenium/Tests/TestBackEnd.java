package Selenium.Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestBackEnd {


   // @Before
    @Test
    public void testRegister() {
        JSONObject request = new JSONObject();
        request.put("customer.firstName", "Clara");
        request.put("customer.lastName", "Lisle");
        request.put("customer.address.street", "san Martin");
        request.put("customer.address.city", "Tandil");
        request.put("customer.address.state", "Buenos Aires");
        request.put("customer.address.zipCode", "7000");
        request.put("customer.phoneNumber", "123456");
        request.put("customer.ssn", " 123");
        request.put("customer.username", "clara123");
        request.put("customer.password", "123");
        request.put("repeatedPassword", "123");

        given().
                log().all().contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                get("https://parabank.parasoft.com/parabank/register.htm").
                then().
                statusCode(200).log().all();
    }

    @Test
    public void testCreateAccount() {
    String URL = "https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=26864&newAccountType=0&fromAccountId=35433";
    Response response = given().auth()
            .basic("clara1", "123")
            .when()
            .post(URL);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

   }

    @Test
    public void testOverview() {
        String URL = "https://parabank.parasoft.com/parabank/services_proxy/bank/customers/26864/accounts";
        Response response = given().auth()
                .basic("clara1", "123")
                .when()
                .get(URL);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

    }

    @Test
    public void transferFunds() {
        given()
                .when()
                .post("https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=35433&toAccountId=55635&amount=1000")
                .then()
                .statusCode(401);
    }

    @Test
    public void MonthlyAcctActivity() {
        given()
                .when()
                .get("https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/55635/transactions/month/All/type/All")
                .then()
                .statusCode(401);

    }


}
