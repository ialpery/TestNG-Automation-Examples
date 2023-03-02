package tests.ders12_assertions_POMGelistirmeler;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;

public class C02_SoftAssertion {

    @Test
    public void test01(){

        /*

        Eğer bir test adımında verify veya doğrulayın kelimesi geçiyorsa genellikle soft assertion kullanılır.

        soft assertion kullandığımızda biz assertionları raporla diyene kadar testler failed olsa bile devam eder.
        Biz raporla dediğimizde yaptığı tüm assertionları raporlar ve failed olan assertion varsa çalışmayı durdurup
        exception fırlatır.

        Softassert kullanabilmek için
        1. softassert objesini oluşturun
        2. bu objeyi kullanarak istediğiniz tüm testleri yapın
        3. tüm testler bittiğinde, raporlama yapması için softassert.assertAll() çalıştırın

        Softassert birden fazla assert hatasını toptan raporlar fakat hataların hangi adımda olduğunu
        söylemez.

        Hataların nereden kaynaklandığını kolayca anlayabilmemiz için
        verify kodlarına açıklama eklemeliyiz.
         */


        // 1- Amazon anasayfaya gidip, amazona gittiğinizi doğrulayın(verify)
        Driver.getDriver().get("https://www.amazon.com");
        String expectedIcerik = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
         // 1. verify
        softAssert.assertTrue(actualUrl.contains(expectedIcerik),"1. verify çalışmıyor, url istenen içeriğe sahip değil.");

        // 2- amazon anasayfasında arama kutusunun enable olduğunu doğrulayın(verify)
        AmazonPage amazonPage = new AmazonPage();
        softAssert.assertTrue(amazonPage.aramaKutusuElementi.isEnabled(),"2. verify çalışmıyor, arama kutusu enabled değil.");

        // 3- arama kutusuna Nutella yazıp aratın, sonuçların Nutella içerdiğini doğrulayın (verify)
        amazonPage.aramaKutusuElementi.sendKeys("Nuuuuuuutella" + Keys.ENTER);

        expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.aramaSonucYaziElementi.getText();
        softAssert.assertTrue(actualSonucYazisi.contains(expectedIcerik), "3. verify çalışmıyor, arama sonuçları istenen içeriğe sahip değil.");

        softAssert.assertAll();  // Şu ana kadarki tüm assertion hataları bu adımda raporlanır.

        Driver.closeDriver();
    }

}
