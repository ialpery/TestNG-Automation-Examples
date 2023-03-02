package tests.ders11_TestNGFramework;

import org.testng.annotations.Test;

public class C01_Priority {

    @Test (priority = 5)
    public void amazonTest(){
        System.out.println("amazon");
    }


    @Test (priority = 7, groups = "smoke") // group ismi vermemizin sebebi, siraliCalistirmaGroups.xml ile çalıştırmak
    public void youtubeTest(){
        System.out.println("youtube");
    }


    @Test
    public void facebookTest(){
        System.out.println("facebook");
    }



}
