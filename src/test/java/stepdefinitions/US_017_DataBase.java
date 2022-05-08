package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class US_017_DataBase {

    List<Object> itemBilgi;

    @Given("Kullanici DB kullanarak bir baglanti olusturur")
    public void kullanici_db_kullanarak_bir_baglanti_olusturur() {
        DBUtils.createConnection();
    }

    @Given("Kullanici DataBase e sorgulama yapar ve verileri alir")
    public void kullanici_data_base_e_sorgulama_yapar_ve_verileri_alir() {
        itemBilgi = new ArrayList<>();
        itemBilgi = DBUtils.getColumnData("select * from c_test_item", "name");

    }

    @Then("Gelen test item larini dogrular")
    public void gelen_test_item_larini_dogrular() {
        List<String> expectedItems = new ArrayList<>();
        expectedItems.add("Ure");
        expectedItems.add("Hemoglobin");
        expectedItems.add("Sodium");
        Assert.assertTrue(itemBilgi.containsAll(expectedItems));
    }

}
