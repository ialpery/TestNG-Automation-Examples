package tests.ders11_TestNGFramework;

import org.testng.annotations.Test;

public class C02_dependsOnMethods {

    /*

    Bir methodun çalışmasını başka bir methodun çalışmasından sonraya ayahrlayabiliriz.
    Bu durumda bağlı olan method pass olmadan method çalışmaz

     */


    @Test(priority = 5, dependsOnMethods = "youtubeTest")
    public void amazonTest(){
        System.out.println("amazon");
    }


    @Test (priority = 7)
    public void youtubeTest(){
        System.out.println("youtube");
    }


    @Test
    public void facebookTest(){
        System.out.println("facebook");
    }

}
