package tests.ders12_assertions_POMGelistirmeler;

import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_positiveLoginTest {

    // Bir test methodu oluşturun


    @Test (groups = "smoke") // group ismi vermemizin sebebi, siraliCalistirmaGroups.xml ile çalıştırmak
    public void test01() throws InterruptedException {

        // qualitydemy anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // gecerli kullanıcı adı ve geçerli password yazıp
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.cookieAcceptButton.click();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdPassword"));

        // login butonuna tıklayınca
        qualitydemyPage.loginButonu.click();

        // basarili olarak giriş yapıldığını test edin




        Thread.sleep(3000);
        Driver.closeDriver();

    }

}
