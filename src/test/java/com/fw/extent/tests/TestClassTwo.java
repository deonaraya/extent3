package com.fw.extent.tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by chandrad on 3/18/17.
 */
public class TestClassTwo extends BaseTest {


    @Test
    public void testD(){
        driver.get("http:/myntra.com");
        test.get().log(Status.INFO,"opening the url for myntra");

        String title = driver.getTitle();
        test.get().log(Status.INFO,"capturing the title for myntra");

        Assert.assertTrue(title.contains("Shop"));
        test.get().log(Status.INFO,"Asserting the browser title against expected reuslt");

    }

    @Test
    public void testE(){
        driver.get("http://jabong.com");
        test.get().log(Status.INFO,"opening the url for jabong");

        String title = driver.getTitle();
        test.get().log(Status.INFO,"capturing the title for jabong");

        Assert.assertTrue(title.contains("jab"));
        test.get().log(Status.INFO,"Asserting the browser title against expected reuslt");


    }
}
