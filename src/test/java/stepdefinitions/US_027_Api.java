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
import pojos.Message;
import utilities.ConfigReader;

import java.io.IOException;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
//import static stepdefinitions.Hooks.spec;
import static utilities.Authentication.generateToken;


public class US_027_Api {
Message expectedData;
Response response;
Message expectedDataPost;
    @Given("Kullanici gerekli path parametrelerini ayarlar")
    public void kullanici_gerekli_path_parametrelerini_ayarlar() {
      //  spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("parametre1","api","parametre2","c-messages","parametre3","71934");
    }
    @Given("Kullanici {string}, {string}, {string}, {string} {string} bilgileri ile expected datayi olusturur")
    public void kullanici_bilgileri_ile_expected_datayi_olusturur(String id, String name, String email, String subject, String message) {

              // id="71912";
             //  name="fadime";
             // email="gg@medunna.com";
            //  subject="temizlik";
            //  message="temizlik sifir";

        id="71934" ;
                name= "fadime";
                email= "gg@medunna.com";
                subject= "temizlik";
                message= "temizlik sifir";

       //id= "43798";
       ////      name= "madri";
       ///       email= "gazi1@gmail.com";
       //     subject= "carabanchel";
       //      message= "fenerbahce";

              expectedData=new Message(id,name,email,subject,message);
    }
    @Given("Kullanici GET islemi gonderir ve yanit alir")
    public void kullanici_get_islemi_gonderir_ve_yanit_alir() {

        response = given()
                .header("Authorization", "Bearer " + generateToken("Team83Admin","Batch44+"))
                .contentType(ContentType.JSON)
                .spec(spec)
                .when()
                .get("/{parametre1}/{parametre2}/{parametre3}");
        response.prettyPrint();



    }
    @Then("Kullanici api verilerini dogrular")
    public void kullanici_api_verilerini_dogrular() throws JsonProcessingException {
        ObjectMapper obj=new ObjectMapper();
        Message actualData=obj.readValue(response.asString(),Message.class);
        Assert.assertEquals(expectedData.getId(),actualData.getId());
        Assert.assertEquals(expectedData.getName(),actualData.getName());
        Assert.assertEquals(expectedData.getEmail(),actualData.getEmail());
        Assert.assertEquals(expectedData.getSubject(),actualData.getSubject());
        Assert.assertEquals(expectedData.getMessage(),actualData.getMessage());

    }


    @Given("Kullanici gerekli POST islemi icin path parametrelerini ayarlar")
    public void kullanici_gerekli_post_islemi_icin_path_parametrelerini_ayarlar() {
        spec.pathParams("parametre1","api","parametre2","c-messages");

    }
    @Given("Kullanici {string}, {string}, {string} {string} bilgileri ile POST islemi icin expected datayi olusturur")
    public void kullanici_bilgileri_ile_post_islemi_icin_expected_datayi_olusturur(String name, String email, String subject, String message) {

        name= "fadime";
        email= "gg@medunna.com";
        subject= "temizlik";
        message= "temizlik sifir";
        expectedDataPost=new Message(name,email,subject,message);

    }
    @Given("Kullanici POST islemi gonderir ve yanit alir")
    public void kullanici_post_islemi_gonderir_ve_yanit_alir() {
        response = given().headers(
                        "Authorization",
                        "Bearer " + generateToken("Team83Admin","Batch44+"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body(expectedDataPost)
                .post("https://www.medunna.com/api/c-messages")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        response.prettyPrint();


    }
    @Then("Kullanici Post islemi icin api verilerini dogrular")
    public void kullanici_post_islemi_icin_api_verilerini_dogrular() throws JsonProcessingException {

        ObjectMapper obj=new ObjectMapper();
        Message actualData=obj.readValue(response.asString(),Message.class);

        Assert.assertEquals(expectedDataPost.getName(),actualData.getName());
        Assert.assertEquals(expectedDataPost.getEmail(),actualData.getEmail());
        Assert.assertEquals(expectedDataPost.getSubject(),actualData.getSubject());
        Assert.assertEquals(expectedDataPost.getMessage(),actualData.getMessage());

    }

}
