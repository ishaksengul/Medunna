package stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pages.Admin;
import pojos.Room;
import pojos.RoomPost;
import utilities.ConfigReader;

import java.io.BufferedReader;
import java.io.FileReader;

import static Hooks.Hooks.spec;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.*;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.saveRoomData;

public class US_016API {

    Admin admin=new Admin();
    Faker faker=new Faker();
    Room room;
    Response response;
    RoomPost roomPost;
    static String roomNumber="";
    static int price=0;
    static String createdDate="";
    String query="";
    @Given(" BS set the necessary path params")
    public void setTheNecessaryPathParams() {
        spec.pathParams("1","api","2","rooms");
    }
    @And("BS set the expected data {string}, {int}, {string} and {string}")
    public void bsSetTheExpectedDataPriceAnd(String description, int price, String roomType, String status) {
        Faker faker=new Faker();
        int number=faker.number().numberBetween(300,1000);
        boolean status2=Boolean.parseBoolean(status);
        roomPost= new RoomPost(description,price,number,roomType,status2);
    }
    @Given("BS set the expected data {string}, {int}, {int}, {string} and {string}")
    public void bsSetTheExpectedDataAnd(String description, int price, int roomNumber, String roomType, String status) {
        boolean status2 = Boolean.parseBoolean(status);
        room = new Room(description, price, roomNumber, roomType, status2);
    }
    @Given("BS set the expected data {string}, {int}, {int}, {string} and {string} for {int}")
    public void bsSetTheExpectedDataAndFor(String description, int price, int roomNumber, String roomType, String status, int roomId) {
        boolean status2=Boolean.parseBoolean(status);
        room=new Room(description,price,roomNumber,roomType,status2);
        room.setId(roomId);
    }

    @When("BS user sends the {string} request")
    public void bsUserSendsTheRequest(String arg0) throws Exception {
//        ObjectMapper obj=new ObjectMapper();
//        System.out.println(obj.writeValueAsString(room));
        switch (arg0){
            case "POST":
                response=postRequestRoom(generateToken(ConfigReader.getProperty("admin_username"),ConfigReader.getProperty("admin_password")),
                        ConfigReader.getProperty("base_url")+"/api/rooms",roomPost);
                break;
            case "GET":
                response=getRequest(generateToken(ConfigReader.getProperty("admin_username"),ConfigReader.getProperty("admin_password")),
                        ConfigReader.getProperty("base_url")+"/api/rooms");
                break;
            case "PUT":
                response=putRequestRoom(generateToken(ConfigReader.getProperty("admin_username"),ConfigReader.getProperty("admin_password")),
                        ConfigReader.getProperty("base_url")+"/api/rooms",room);
                break;
            default:
                break;
        }
    }

    @Then("BS status code should be {int} for rooms")
    public void bsStatusCodeShouldBeForRooms(int arg0) {
        response.then().statusCode(arg0);
    }

    @Then("BS verify that the response body should be as an expected data")
    public void bsVerifyThatTheResponseBodyShouldBeAsAnExpectedData() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        RoomPost actualRoom=objectMapper.readValue(response.asString(),RoomPost.class);

        assertEquals(roomPost.getDescription(),actualRoom.getDescription());
        assertEquals(roomPost.getPrice(),actualRoom.getPrice());
        assertEquals(roomPost.getRoomNumber(),actualRoom.getRoomNumber());
        assertEquals(roomPost.getRoomType(),actualRoom.getRoomType());
        assertEquals(roomPost.isStatus(),actualRoom.isStatus());
        JsonPath jsonPath=response.jsonPath();
        saveRoomData(String.valueOf(jsonPath.getInt("id")), jsonPath.getInt("price"), jsonPath.getString("createdDate") );
    }

    @Then("BS verify that the response body contains all expected data")
    public void bsVerifyThatTheResponseBodyContainsAllExpectedData() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Room[] rooms = objectMapper.readValue(response.asString(), Room[].class);

        for (Room eachRoom : rooms
        ) {
            if (eachRoom.getRoomNumber() == room.getRoomNumber()) {
                assertEquals(room.getDescription(), eachRoom.getDescription());
                assertEquals(room.getPrice(), eachRoom.getPrice());
                assertEquals(room.getRoomType(), eachRoom.getRoomType());
                assertEquals(room.isStatus(), eachRoom.isStatus());
            }
        }

    }



    @Then("BS verify that the response body should be as an expected")
    public void bsVerifyThatTheResponseBodyShouldBeAsAnExpected() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        Room actualRoom=objectMapper.readValue(response.asString(),Room.class);

        assertEquals(room.getDescription(),actualRoom.getDescription());
        assertEquals(room.getPrice(),actualRoom.getPrice());
        assertEquals(room.getRoomNumber(),actualRoom.getRoomNumber());
        assertEquals(room.getRoomType(),actualRoom.getRoomType());
        assertEquals(room.isStatus(),actualRoom.isStatus());
    }

    @Given("BS user sends the delete request")
    public void bsUserSendsTheDeleteRequest() {
        int id=0;
        try{

            //identify file location
            FileReader fileReader = new FileReader("./src/test/resources/testdata/RoomData.txt");

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine().substring(5,10);
            System.out.println(line);
            id = Integer.parseInt(line);
            System.out.println(id);

        }catch (Exception e){

            e.printStackTrace();

        }

        response=deleteRequest(generateToken(ConfigReader.getProperty("Admin_username"),ConfigReader.getProperty("Admin_pass")),
                ConfigReader.getProperty("base_url")+"/api/rooms/"+id);
    }


}
