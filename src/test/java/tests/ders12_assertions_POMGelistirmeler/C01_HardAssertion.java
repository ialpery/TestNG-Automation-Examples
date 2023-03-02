package tests.ders12_assertions_POMGelistirmeler;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C01_HardAssertion {

    /*
        JUnitte de kullandığımız Assert class'ı ilk assertion failed olduğunda çalışmayı durdurur ve exception fırlatır
        Bunun pozitif tarafı hemen tek bir hataya odaklanabilmemizdir.

        Bunun negatif tarafı ise birden fazla hata olan classlardaki hataları görebilmemiz için
        classı tekrar tekrar çalıştırmak zorunda kalmamızdır.

        TestNG bu negatifliği ortadan kaldırabilmemiz için SoftAssertion alternatifi geliştirmiştir.
     */

    @Test
    public void test01(){

        // amazon anasayfaya gidip, amazona gittiğini test et
        Driver.getDriver().get("https://www.amazon.com");

        String expectedIcerik = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        // arama kutusunun enable olduğunu test edin

        AmazonPage amazonPage = new AmazonPage();

        Assert.assertTrue(amazonPage.aramaKutusuElementi.isEnabled());

        // Nutella aratalım, arama sonuç yazısının Nutella içerdiğini test edin

        amazonPage.aramaKutusuElementi.sendKeys("Nutella" + Keys.ENTER);

        expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.aramaSonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));


    }

}
