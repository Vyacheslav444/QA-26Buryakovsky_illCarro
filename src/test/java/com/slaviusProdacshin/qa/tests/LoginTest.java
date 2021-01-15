package com.slaviusProdacshin.qa.tests;

import com.slaviusProdacshin.qa.model.User;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase{

    @DataProvider
    public Iterator<Object[]> validLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"my.email1608662540277@gmail.com", "Aa125546"});
        //list.add(new Object[]{"my.email1608815240039@gmail.com", "iL12345678"});
        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> validLoginFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/validLoginCsv.csv")));
        String line = reader.readLine();
        while (line!= null){
            String[]split=line.split(";");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
           // list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }




        return list.iterator();

    }
    @Test(dataProvider ="validLoginFromCsv")
    public void testLoginDataProviderCsv(User user) throws InterruptedException {
        logger.info("\n user name is " + user.getEmail() + " \n user password is" + user.getPassword());
        //clickOnLoginButton
        app.getUser().lickLogInButton();
        //click(By.cssSelector("[href='/login']"));
        app.getUser().fillLoginForm(user);
        app.getUser().pause(2000);
        app.getUser().clickYallaButton();

        Assert.assertTrue(app.getUser().isUserLoggedIn());
        logger.info("Test passed");
        String screenshot = "src/test/screenshots/screenshot-" + System.currentTimeMillis() + ".png";
        app.getUser().takeScreenshot(screenshot);

        logger.info("Created screenshot" + screenshot);
    }
    @Test(dataProvider ="validLogin")
    public void testLoginDataProvider(String email,String password) throws InterruptedException {
        logger.info("\n user name is" + email + "\n user password is " + password);
        //clickOnLoginButton
        app.getUser().lickLogInButton();
        //click(By.cssSelector("[href='/login']"));
        app.getUser().fillLoginForm(new User()
                .setEmail(email)
                .setPassword(password));
        app.getUser().pause(2000);
        app.getUser().clickYallaButton();

        Assert.assertTrue(app.getUser().isUserLoggedIn());
        logger.info("Test passed");
        String screenshot = "src/test/screenshots/screenshot-"+System.currentTimeMillis()+".png";
        app.getUser().takeScreenshot(screenshot);

        logger.info("Created screenshot" + screenshot);


    }

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
