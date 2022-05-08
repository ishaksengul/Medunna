package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Physician;
import utilities.ConfigReader;
import static Hooks.Hooks.spec;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class US_018_Api {


    Response response;
    HashMap<String, Object> expectedData = new HashMap<>();


    @Given("Admin, doktor okuması için path parametrelerini ayarlar")
    public void admin_doktor_okuması_için_path_parametrelerini_ayarlar() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("medunnaUrl")).build();
        spec.pathParams("1", "api", "2", "physicians","3","60635");

    }


    /*
    @And("Admin, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} bilgileri ile expected datayi olusturur")
    public void adminBilgileriIleExpectedDatayiOlusturur(String appointments, String birthDate, String bloodGroup, String examFee, String firstName, String id, String lastName, String phone, String speciality, String ssn, String pattern, String user, String email) {
        appointments=null;
        birthDate="2000-04-13T22:00:00Z";
        bloodGroup="Apositive";
        examFee="200.00";
        firstName="Seyma";
        id="60635";
        lastName="Ozkan";
        phone="0779810611";
        speciality="PATHOLOGY";
        ssn="342-82-0505";
        pattern=null;
        user=null;
        email="drseyma@gmail.com";


        expectedData=new Physician(null, "2000-04-13T22:00:00Z", "Apositive", "200.00", "Seyma", "60635", "Ozkan", "0779810611", "PATHOLOGY", "342-82-0505", null, null, "drseyma@gmail.com");
    }



     */

    @Given("Admin, doktor okuması için request gönderir ve responce alır")
    public void admin_doktor_okuması_için_request_gönderir_ve_responce_alır() {
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + generateToken("Team92Admin","Batch44+"))
                .spec(spec)
                .when()
                .get("/{1}/{2}/{3}");

        response.prettyPrint();
        response.then().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

    }


    @And("Admin, {string}, {string}, {string}, {string} bilgileri ile expected datayi olusturur")
    public void adminBilgileriIleExpectedDatayiOlusturur(String arg0, String arg1, String arg2, String arg3) {
        expectedData.put("id",60635);
        expectedData.put("firstName","Seyma");
        expectedData.put("lastName","Ozkan");
        expectedData.put("birthDate","2000-04-13T22:00:00Z");
    }

    @Then("Admin, doktor okuması için API kayıtlarını doğrular")
    public void admin_doktor_okuması_için_api_kayıtlarını_doğrular() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        HashMap<String, Object> actualData = obj.readValue(response.asString(), HashMap.class);

        Assert.assertEquals(expectedData.get("id"),actualData.get("id"));
        Assert.assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
        Assert.assertEquals(expectedData.get("lastName"),actualData.get("lastName"));
        Assert.assertEquals(expectedData.get("birthDate"),actualData.get("birthDate"));



    }

}
