package tests.ders13_TestNGreports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C02_raporluPositiveLoginTest extends TestBaseReport {

    // Bir test methodu oluşturun


    @Test (groups = "smoke") // group ismi vermemizin sebebi, siraliCalistirmaGroups.xml ile çalıştırmak
    public void test01() throws InterruptedException {

        extentTest = extentReports.createTest("Pozitif login testi", "Doğru bilgilerle giriş yapılabilidi test edilir");
        // qualitydemy anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("qualitydemy anasayfaya gidildi");

        // gecerli kullanıcı adı ve geçerli password yazıp
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.cookieAcceptButton.click();
        extentTest.info("cookies kabul edildi");

        qualitydemyPage.ilkLoginLinki.click();
        extentTest.info("İlk login linkine tıklandı");

        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdPassword"));
        extentTest.info("Geçerli kullanıcı adı ve şifre girildi");
        // login butonuna tıklayınca
        qualitydemyPage.loginButonu.click();
        extentTest.info("Login butonuna tıklandı");

        // basarili olarak giriş yapıldığını test edin

        Assert.assertTrue(qualitydemyPage.basariliGirisElementi.isEnabled());
        extentTest.pass("Başarılı bir şekilde giriş yapıldığı test edildi");

        Driver.closeDriver();

    }

}
