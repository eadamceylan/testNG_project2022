package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day15_FirstDriverClass {

    @Test
    public void firstDriverClass(){
//        driver   -------->>>>>>>>>>   Driver.getDriver()
        Driver.getDriver().get("https://www.techproeducation.com");

//        Closing the driver
        Driver.closeDriver();
    }
}
