package com.slaviusProdacshin.qa.application;

import com.slaviusProdacshin.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }
    public void Login() throws InterruptedException {
        //clickOnLoginButton
        clickByCss("[href='/login']");
        //click(By.cssSelector("[href='/login']"));
        fillLoginForm(new User()
                .setEmail("my.email1608662540277@gmail.com")
                .setPassword("Aa125546") );
        pause(2000);
        clickByCss("[type=submit]");
    }



    public boolean isRegistrationFormPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Registration')]"));
    }



    public void selectCheckBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("first_name"), user.getfName());
        type(By.cssSelector("#second_name"), user.getlName());
        System.out.println("email is:" + user.getEmail());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void openRegForm() {
        click(By.cssSelector("[href='/signup']"));
    }



    public void fillLoginForm(User user) {
        typeByCss("[name=email]", user.getEmail());
        typeByCss("[name=password]", user.getPassword());
    }



    public void clickLogOutButtonOnHeader() {
        click(By.xpath("//a[contains(., 'logOut')]"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(.,'logOut')]"));
    }

    public void lickLogInButton() {
        clickByCss("[href='/login']");
    }
}
