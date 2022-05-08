package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US_015DB {

    List<Object> patientList ;
    @Given("Admin bilgileri kullanarak Db ile baglanti kurar")
    public void admin_bilgileri_kullanarak_db_ile_baglanti_kurar() {
        ReusableMethods.waitFor(10);
        DBUtils.createConnection();
        ReusableMethods.waitFor(10);
    }
    @Given("admin query ve column data gonderir")
    public void admin_query_ve_column_data_gonderir() {
        patientList = new ArrayList<>();
        ReusableMethods.waitFor(10);
        patientList = DBUtils.getColumnData("select * from patient","first_name");
        System.out.println(patientList);
    }
    @Then("admin patient bilgisini dogrular")
    public void admin_patient_bilgisini_dogrular() {
        List<Object> expectedPatientList = new ArrayList<>();
        expectedPatientList.add("selim");
        expectedPatientList.add("saban");
        expectedPatientList.add("patient46");

       Assert.assertTrue(patientList.containsAll(expectedPatientList));


    }
}
