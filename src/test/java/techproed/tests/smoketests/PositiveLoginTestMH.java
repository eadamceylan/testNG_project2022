package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HotelHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class PositiveLoginTestMH {

    HotelHomePage hotelHomePage = new HotelHomePage();

    @Test
    public void positiveLoginTest(){




//    Bir test method olustur positiveLoginTest()
//    https://www.hotelmycamp.com/ adresine git
      Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
//    login butonuna bas
      hotelHomePage.hotelHomeLoginButton.click();
//    test data username: manager ,
        hotelHomePage.hotelEmailTextBox.sendKeys(ConfigReader.getProperty("hotelValidUsername"));
//    test data password : Manager1!
        hotelHomePage.hotelPasswordTestBox.sendKeys(ConfigReader.getProperty("hotelValidPassword"));
//    Login butonuna bas
        hotelHomePage.hotelSecondLoginButton.click();
//    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUsername = hotelHomePage.managerElement.getText();
        String expectedUsername = ConfigReader.getProperty("hotelValidUsername");
        Assert.assertEquals(actualUsername,expectedUsername);

        Driver.closeDriver();



}
}
