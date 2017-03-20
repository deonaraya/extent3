package com.fw.extent.tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by chandrad on 3/18/17.
 */
public class TestCassOne extends BaseTest {



    @Test
    public void testA(){
        driver.get("http://amazon.in");
        test.get().log(Status.INFO,"opening the url for amazon");

        String title = driver.getTitle();
        test.get().log(Status.INFO,"capturing the title for amazon");

        Assert.assertTrue(title.contains("Shop"));
        test.get().log(Status.INFO,"Asserting the browser title against expected reuslt");

    }

    @Test
    public void testB(){
        driver.get("http://flipkart.com");
        test.get().log(Status.INFO,"opening the url for flipkart");

        String title = driver.getTitle();
        test.get().log(Status.INFO,"capturing the title for flipkart");

        Assert.assertTrue(title.contains("Shop"));
        test.get().log(Status.INFO,"Asserting the browser title against expected reuslt");


    }

    @Test
    public void testC(){

        driver.get("http://snapdeal.com");
        test.get().log(Status.INFO,"opening the url for snapdeal");

        String title = driver.getTitle();
        test.get().log(Status.INFO,"capturing the title for snapdeal");

        Assert.assertTrue(title.contains("store"));
        test.get().log(Status.INFO,"Asserting the browser title against expected reuslt");
    }


}
