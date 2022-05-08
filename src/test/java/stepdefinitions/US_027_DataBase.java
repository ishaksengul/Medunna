package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class US_027_DataBase {

    List<Object> messageBilgisi;


    @Given("user sends the query to DataBase and gets the column data {string} and {string}")
    public void user_sends_the_query_to_data_base_and_gets_the_column_data_and(String string, String string2) {

    }


    @Given("user creates a connection with DataBase using")
    public void userCreatesAConnectionWithDataBaseUsing() {

        DBUtils.createConnection();
    }

    @And("user sends the query to DataBase and gets the column data query and columnName")
    public void userSendsTheQueryToDataBaseAndGetsTheColumnDataQueryAndColumnName() {
          messageBilgisi=new ArrayList<>();
          messageBilgisi=DBUtils.getColumnData("select * from cmessage","name");
        System.out.println(messageBilgisi);
    }

   // @Then("mesajlari dogrular.")
   // public void mesajlariDogrular() {
    //    List<String>expectedMessage=new ArrayList<>();
     //   expectedMessage.add("fadime");
     //   expectedMessage.add("Cabbar");

      //  Assert.assertTrue(messageBilgisi.containsAll(expectedMessage));
   // }

    @Then("validates messages.")
    public void validatesMessages() {
        List<String>expectedMessage=new ArrayList<>();
        expectedMessage.add("fadime");
        expectedMessage.add("Cabbar");

        Assert.assertTrue(messageBilgisi.containsAll(expectedMessage));

    }
}
