package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.bouncycastle.asn1.ocsp.ResponderID;
import org.junit.Assert;
import utilities.ConfigReader;

import java.util.HashMap;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;


public class US_015API {
    Response response;
    HashMap<String, Object> expectedData = new HashMap<>();

    @Given("hastalar icin path param ayarlanir")
    public void hastalar_icin_path_param_ayarlanir() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("medunnaUrl")).build();
        spec.pathParams("1par","api","2par","patients","3par","55902");
    }


    @Given("{string} {string} {string} ile expected datalari olusturur")
    public void ile_expected_datalari_olusturur(String id, String firstName, String lastName) {
        expectedData.put("id",55902);
        expectedData.put("firstName","Eli");
        expectedData.put("lastName","Wuckert");


    }
    @Given("hasta icin response alir")
    public void hasta_icin_response_alir() {
        response= (Response) given().
                contentType(ContentType.JSON).
                header("Authorization","Bearer " + generateToken("Team92Admin","Batch44+"))
                .spec(spec).when().get("/{1par}/{2par}/{3par}");
        response.prettyPrint();
        response.then().statusCode(200);

    }
    @Given("hasta icin api kaydi dogrulanir")
    public void hasta_icin_api_kaydi_dogrulanir() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        HashMap<String, Object> actualData = obj.readValue(response.asString(), HashMap.class);

        Assert.assertEquals(expectedData.get("id"),actualData.get("id"));
        Assert.assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
        Assert.assertEquals(expectedData.get("lastName"),actualData.get("lastName"));


    }
}
