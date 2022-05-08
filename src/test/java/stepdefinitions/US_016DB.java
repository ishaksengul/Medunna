package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class US_016DB {
    private String query;

    @Given("BS user connects to the Database")
    public void bsUserConnectsToTheDatabase() {
    }

    @When("BS user selects {string} from the {string} table for {string}")
    public void bsUserSelectsFromTheTableFor(String arg0, String arg1, String arg2) {
        query="Select "+arg0+" from "+arg1+" where "+ arg2;
    }

    @And("BS verify that the data includes {int}, {int}, {string}, {string}, {string}, {string} information")
    public void bsVerifyThatTheDataIncludesIdRoomNumberInformation(int id, int roomNumber, String price, String roomType, String status, String description) throws Exception {
        List<Map<String,Object>> actualRoomData= DBUtils.getQueryResultMap(query);
//        System.out.println(actualRoomData);
        System.out.println(price);
        Map<String,Object> expectedData=new HashMap<>();

        expectedData.put("price",price);
        expectedData.put("room_number",roomNumber);
        expectedData.put("description",description);
        expectedData.put("id",Long.valueOf(id));
        expectedData.put("room_type",roomType);
        expectedData.put("status",Boolean.parseBoolean(status));
//        List<String> columnNames=DBUtils.getColumnNames(query);
//        System.out.println(columnNames);
//        executeQuery(query);

//    Room room=new Room(description,Integer.valueOf(price.substring(0,3)),roomNumber,roomType,Boolean.parseBoolean(status));
//    room.setId(id);
//        System.out.println(room);


        for (Map<String,Object> eachRoom:actualRoomData
        ) {

            if(eachRoom.get("room_number").equals(expectedData.get("room_number"))){
                System.out.println(eachRoom);
                assertEquals(eachRoom.get("id"),expectedData.get("id"));
                assertEquals(eachRoom.get("room_type"),expectedData.get("room_type"));
                assertEquals(eachRoom.get("status"),expectedData.get("status"));
                assertEquals( eachRoom.get("price").toString(), expectedData.get("price"));
                assertEquals(eachRoom.get("description"),expectedData.get("description"));

                break;

            }

        }
    }

    @Then("BS user close the database connection")
    public void bsUserCloseTheDatabaseConnection() {
    }


}
