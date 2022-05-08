package stepdefinitions;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class US_019API3 {

    public static RequestSpecification spec;
    HashMap<String, Object> expectedData = new HashMap<>();
    Response response;


    @Given("Kullanıcı staff sorgusu icin get path params ayarını yapar")
    public void kullanıcı_staff_sorgusu_icin_get_path_params_ayarını_yapar() {
        //https://medunna.com
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        // /api/staff/83559
        spec.pathParams("get1", "api", "get2", "staff", "get3", "83559"); 

    }

    @Given("Kullanıcı staff ile alakalı expected dataları olusturur")
    public void kullanıcı_staff_ile_alakalı_expected_dataları_olusturur() {

//{
//    "createdBy": "team92admin",
//    "createdDate": "2022-04-23T13:49:31.243188Z",
//    "id": 83559,
//    "firstName": "Murat",
//    "lastName": "staff",
//    "birthDate": "2022-04-22T22:00:00Z",
//    "phone": "1231546565",
//    "gender": "MALE",
//    "bloodGroup": "Onegative",
//    "adress": "6546",
//    "description": "54654",
//    "user": {
//        "createdBy": "anonymousUser",
//        "createdDate": "2022-03-28T18:49:43.369492Z",
//        "id": 42610,
//        "login": "team92admin",
//        "firstName": "Team92",
//        "lastName": "Admin",
//        "email": "team92@medunna.com",
//        "activated": true,
//        "langKey": "en",
//        "imageUrl": null,
//        "resetDate": null,
//        "ssn": "111-92-9292"
//    },
        expectedData.put("id", 83559);
        expectedData.put("firstName", "Murat");
        expectedData.put("lastName", "staff");
        expectedData.put("phone", "1231546565");
        expectedData.put("adress", "6546");


    }

    @Given("Kullanıcı staff icin request gonderirir ve response alır")
    public void kullanıcı_staff_icin_request_gonderirir_ve_response_alır() {
        String token = generateToken(ConfigReader.getProperty("US_19Staff_Username"), ConfigReader.getProperty("US_019Staff.pass"));

        response = given().
                headers("Authorization", "Bearer " + token).
                spec(spec).
                contentType(ContentType.JSON).
                when().
                get("/{get1}/{get2}/{get3}");
        response.prettyPrint();

    }

    @Given("Kullanıcı  response status sorgusunu yapar")
    public void kullanıcı_response_status_sorgusunu_yapar() {
        response.then().assertThat().statusCode(200);

    }

    @Given("Kullanıcı staff dogrulama islemini yapar")
    public void kullanıcı_staff_dogrulama_islemini_yapar() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        HashMap<String, Object> actualData = obj.readValue(response.asString(), HashMap.class);

        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("firstName"), actualData.get("firstName"));
        assertEquals(expectedData.get("adress"), actualData.get("adress"));
        assertEquals(expectedData.get("phone"), actualData.get("phone"));
        assertEquals(expectedData.get("lastName"), actualData.get("lastName"));


    }

}
