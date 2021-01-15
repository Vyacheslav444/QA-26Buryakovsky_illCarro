package com.slaviusProdacshin.qa.tests;

import com.slaviusProdacshin.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{


    @Test
    public void testRegistration() throws InterruptedException {
        app.getUser().openRegForm();
        String email = "my.email"+System.currentTimeMillis()+"@gmail.com";
        app.getUser().fillRegistrationForm(new User()
                .setfName("Slava")
                .setlName("ro")
                .setEmail(email)
                .setPassword("Aa125546"));
        app.getUser().selectCheckBox();
        app.getUser().pause(2000);
        app.getUser().clickYallaButton();
        app.getUser().pause(3000);
        Assert.assertFalse(app.getUser().isRegistrationFormPresent());

    }

    @Test
    public void testRegistrationNegative() throws InterruptedException {
        app.getUser().openRegForm();
        String email = "my.email"+System.currentTimeMillis();
        app.getUser().fillRegistrationForm(new User()
                .setfName("Slava")
                .setlName("ro")
                .setEmail(email)
                .setPassword("85464566"));

        app.getUser().selectCheckBox();
        app.getUser().pause(2000);
        app.getUser().clickYallaButton();
        app.getUser().pause(3000);

        Assert.assertTrue(app.getUser().isRegistrationFormPresent());



    }

}
