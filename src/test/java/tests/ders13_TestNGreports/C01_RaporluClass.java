package tests.ders13_TestNGreports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C01_RaporluClass extends TestBaseReport {

    @Test
    public void Test01(){

        extentTest = extentReports.createTest("Nutella Testi","Kullanıcı, aradığı kelimeye ait sonuçlar görmeli");
        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon anasayfaya gidildi");

        // Nutella için arama yapın
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusuElementi.sendKeys(ConfigReader.getProperty("amazonArananUrun") + Keys.ENTER);
        extentTest.info("Nutella için arama yapıldı");

        // Arama sonuçlarının Nutella içerdiğini kontrol edin
        String actualAramaSonucYazisi = amazonPage.aramaSonucYaziElementi.getText();
        String expectedIcerik = ConfigReader.getProperty("amazonArananUrun");
        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));
        extentTest.pass("Sonuçların Nutella içerdiği test edildi");

        Driver.closeDriver();

    }

}
