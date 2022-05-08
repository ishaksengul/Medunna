package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.Admin;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
import static Hooks.Hooks.spec;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.interactions.Actions;
import pojos.TestItem;
import utilities.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.deleteRequest;
import static utilities.Authentication.generateToken;


public class US_017_API {
    Admin admin = new Admin();
    ReusableMethods reusableMethods;
    TestItem testItem=new TestItem();
    Response response;
    List< Object> allDBItemIds;

    @Given("kullanici gerekli items icin path params ayarlamalarini yapar")
    public void kullaniciGerekliItemsIcinPathParamsAyarlamalariniYapar() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("MedunnaUrl")).build();
        spec.pathParams("first","api","second","c-test-items","third","87346");
    }

    @And("kullanici test items olusturmak icin expected datalari olusturur")
    public void kullaniciTestItemsOlusturmakIcinExpectedDatalariOlusturur() {

        int newPrice = 15;
        testItem.setDefaultValMax(ConfigReader.getProperty("New_Test_Max_Deger"));
        testItem.setDefaultValMin(ConfigReader.getProperty("New_Test_Min_Deger"));
        testItem.setDescription(ConfigReader.getProperty("New_Test_descrp"));
        testItem.setName(ConfigReader.getProperty("New_Test_Name"));
        testItem.setPrice(newPrice);
    }

    @And("kullanici items icin request gonderir ve response alir")
    public void kullaniciItemsIcinRequestGonderirVeResponseAlir() {
        response=given().
                headers("Authorization", "Bearer " + generateToken("Team92Admin", "Batch44+")).
                spec(spec).
                contentType(ContentType.JSON).
                when().
                get("/{first}/{second}/{third}");
        response.prettyPrint();

    }

    @And("kullanici API kayitlarini onaylar")
    public void kullaniciAPIKayitlariniOnaylar() throws IOException {
        response.prettyPrint();
        ObjectMapper obj = new ObjectMapper();
        TestItem actualTestItem= obj.readValue(response.asString(),TestItem.class);

        System.out.println("actualTestItem = " + actualTestItem);

        Assert.assertEquals("Test item isimleri farkli",testItem.getName(),actualTestItem.getName());
        Assert.assertEquals("Test item defMinValue farkli",testItem.getDefaultValMin(),actualTestItem.getDefaultValMin());
        Assert.assertEquals("Test item defMaxValue farkli",testItem.getDefaultValMax(),actualTestItem.getDefaultValMax());
        Assert.assertEquals("Test item description farkli",testItem.getDescription(),actualTestItem.getDescription());
        Assert.assertEquals("Test item price farkli",testItem.getPrice(),actualTestItem.getPrice());
    }

    @Given("Kullanici gerekli POST islemi icin path params ayarlamalarini yapar")
    public void kullaniciGerekliPOSTIslemiIcinPathParamsAyarlamalariniYapar() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("MedunnaUrl")).build();
        spec.pathParams("first","api","second","c-test-items");
    }

    @And("kullanici post islemi icin expected datalari olusturur")
    public void kullaniciPostIslemiIcinExpectedDatalariOlusturur() {
        int newPrice = 15;
        testItem.setDefaultValMax(ConfigReader.getProperty("New_Test_Max_Deger"));
        testItem.setDefaultValMin(ConfigReader.getProperty("New_Test_Min_Deger"));
        testItem.setDescription(ConfigReader.getProperty("New_Test_descrp"));
        testItem.setName(ConfigReader.getProperty("New_Test_Name"));
        testItem.setPrice(newPrice);
    }

    @And("Kullanici POST islemi gonderir ve yanit alir")
    public void kullaniciPOSTIslemiGonderirVeYanitAlir() {
        response = given().headers(
                        "Authorization",
                        "Bearer " + generateToken("Team83Admin","Batch44+"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body(testItem)
                .post("https://www.medunna.com/api/c-test-items")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        response.prettyPrint();

    }

    @Then("Kullanici Post islemi icin api verilerini dogrular")
    public void kullaniciPostIslemiIcinApiVerileriniDogrular() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        TestItem actualTestItem= obj.readValue(response.asString(),TestItem.class);
        Assert.assertEquals("Test item isimleri farkli",testItem.getName(),actualTestItem.getName());
        Assert.assertEquals("Test item defMinValue farkli",testItem.getDefaultValMin(),actualTestItem.getDefaultValMin());
        Assert.assertEquals("Test item defMaxValue farkli",testItem.getDefaultValMax(),actualTestItem.getDefaultValMax());
        Assert.assertEquals("Test item description farkli",testItem.getDescription(),actualTestItem.getDescription());
        Assert.assertEquals("Test item price farkli",testItem.getPrice(),actualTestItem.getPrice());

    }
}
