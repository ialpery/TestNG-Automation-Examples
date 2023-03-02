package tests.ders12_assertions_POMGelistirmeler;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SingletonPattern {

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        /*

        Biz POM frameworklerde webdriverın Driver classındaki getDriver() ından kullanılmasını istiyoruz

        Eğer bu kullanım yöntemi dışında obje oluşturularak bu method kullanılmaya çalışılmasın istiyorsanız
        Driver classından obje üretilmesine engel olmalısınız.

        Bunu parametresiz bir constructor oluşturup access modifierını private yaparak sağlayabilirsiniz (Bu örneğimizde Driver classında)

        Bu yöntemle bir classtan obje üretilmesini engellemeye SINGLETON PATTERN denir.

         */

    }

}
