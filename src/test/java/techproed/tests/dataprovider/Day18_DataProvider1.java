package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day18_DataProvider1 {
/*DATA PROVIDER
* Marks a method as supplying data for a test method.
* The annotated method must return an Object[][] where
* each Object[] can be assigned the parameter list of the test method.
* The @Test method that wants to receive data from this DataProvider
* needs to use a dataProvider name equals to the name of this annotation.*/

    /*
    * Data provider it is a testNG annotation. it is used to get the list of data
    * 1) Create a method
    * 2) use @DataProvider method
    * 3) Add the data
    *
    *
    * We can add alternative name to DataProvider using (name = "alternative name")
    *
    * How to pass from a method to test method with Data Provider?
    * ANS: Add dataProvider = "name" ) near the @test annotation
    * */
    @DataProvider
    public Object [][] dataProviderMethod(){

        Object [][] costumerCredential = {
                {"customer@bluerentalcars.com","12345"},
                {"customer1@bluerentalcars.com","12346"},
                {"customer2@bluerentalcars.com","12347"},
                {"customer3@bluerentalcars.com","12348"}

        };
        return costumerCredential;
    }

    @Test(dataProvider = "dataProviderMethod")
    public void costumerLoginInfo(String username, String password) {
        System.out.println("Username " +username +"| password" +password);



    }
}
