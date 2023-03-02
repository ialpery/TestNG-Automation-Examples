package tests.ders13_TestNGreports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {

    /*
    data provider bir test methodunun birden fazla deger icin tekrar calistirilmasini saglar

    ornegin : negatif login testini 5 kullanici adi, 5 password icin denemek isterseniz
              her seferinde yeniden method yazmak yerine tek method ve ona data saglayan
              data provider ile tek test 5 kez calistirilabilir.
     */
    @DataProvider
    public static Object[][] kullaniciListesi() {
        String [][] kullanicilar = {{"ali", "123"},{"alper", "246"}, {"mehmet", "234234"}};
        return kullanicilar;
    }


    @Test (dataProvider = "kullaniciListesi")
    public void NegatifLoginTest(String username, String password){

        // qualitydemy anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // cookiesi kabul edin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.cookieAcceptButton.click();

        // gecersiz kullanıcı adı ve geçersiz password yazıp
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.emailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);

        // login butonuna tıklayınca
        qualitydemyPage.loginButonu.click();

        // basarili olarak giriş yapılamadığını test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

        // Sayfayı kapatın
        Driver.closeDriver();


    }

}
