package com.slaviusProdacshin.qa.tests;

import com.slaviusProdacshin.qa.model.User;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{



    @BeforeMethod
    public void ensurePreconditions(){
        if(app.getUser().isUserLoggedIn()){
         app.getUser().clickLogOutButtonOnHeader();
        }

    }

    @Test
    public void testLogin() throws InterruptedException {
        logger.info("\n user name is my.email1608662540277@gmail.com \n user password is Aa125546");
        //clickOnLoginButton
        app.getUser().lickLogInButton();
        //click(By.cssSelector("[href='/login']"));
        app.getUser().fillLoginForm(new User()
                .setEmail("my.email1608662540277@gmail.com")
                .setPassword("Aa125546"));
        app.getUser().pause(2000);
        app.getUser().clickYallaButton();

        Assert.assertTrue(app.getUser().isUserLoggedIn());
        logger.info("Test passed");
        String screenshot = "src/test/screenshots/screenshot-"+System.currentTimeMillis()+".png";
        app.getUser().takeScreenshot(screenshot);

        logger.info("Created screenshot" + screenshot);


    }


}
