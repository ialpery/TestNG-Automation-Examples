package tests.ders12_assertions_POMGelistirmeler;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginTest {

    @Test
    public void NegatifLoginTest(){

        // qualitydemy anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // cookiesi kabul edin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.cookieAcceptButton.click();

        // gecersiz kullanıcı adı ve geçersiz password yazıp
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        // login butonuna tıklayınca
        qualitydemyPage.loginButonu.click();

        // basarili olarak giriş yapılamadığını test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

        // Sayfayı kapatın
        Driver.closeDriver();


    }


}
