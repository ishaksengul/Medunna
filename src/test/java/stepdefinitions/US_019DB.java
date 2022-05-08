package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class US_019DB {
    List<Object> staffInfo;
    @Given("Kullanici DB kullanarak baglanti olusturur")
    public void kullaniciDBKullanarakBaglantiOlusturur() {

        DBUtils.createConnection();
    }

    @And("Kullanici query degeri gonderir ve column degerlerini alir")
    public void kullaniciQueryDegeriGonderirVeColumnDegerleriniAlir() {
        staffInfo=new ArrayList<>();
        staffInfo= DBUtils.getColumnData("select * from staff","first_name");
        System.out.println("staffInfo = " + staffInfo);

    }
    @Then("Kullanici olusturulan staffi dogrular")
    public void kullaniciOlusturulanStaffiDogrular() {
        List<String> expectedStaffName = new ArrayList<>();
        expectedStaffName.add("Murat");
        expectedStaffName.add("staff");
        Assert.assertTrue("bulundu",staffInfo.containsAll(expectedStaffName));
    }


}
