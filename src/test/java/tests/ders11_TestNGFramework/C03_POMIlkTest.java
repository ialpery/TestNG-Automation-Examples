package tests.ders11_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C03_POMIlkTest {

    /*
    Page object model, javadaki OOP konsepte dayanır.
    1. Driver classında webdriver oluşturup kullanmak için static yöntem kullanılır.
    2. Locateleri page sayfalarında yapıp, onlara obje oluşturarak ulaşabiliriz.
     */

    @Test
    public void test01(){

        // Qualitydemy sayfasına gidin
        Driver.getDriver().get("https://www.qualitydemy.com");

        // Login linkine tıklayın
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        // Doğru kullanıcı adı ve şifre ile giriş yapın
        qualitydemyPage.emailKutusu.sendKeys("anevzatcelik@login.com");
        qualitydemyPage.passwordKutusu.sendKeys("Nevzat152032");
        qualitydemyPage.cookieAcceptButton.click();
        qualitydemyPage.loginButonu.click();


        // giriş yapıldığını test edin
        Assert.assertTrue(qualitydemyPage.basariliGirisElementi.isDisplayed());


        Driver.closeDriver();

    }


}
