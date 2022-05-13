package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

   public HomePage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeTab;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin;

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
   WebElement customerLogin;



    public void clickOnBankManagerLoginButton(){
        CustomListeners.node.log(Status.PASS, "Click on bank manager login button : " + bankManagerLogin.getText());
        Reporter.log("Click on bank manager login button " + bankManagerLogin.toString() +"<br>");
        clickOnElement(bankManagerLogin);
    }
    public void clickOnHomeButton(){
        CustomListeners.node.log( Status.PASS, "Click on home tab button " +homeTab.getText());
        Reporter.log("Click on home tab  button" + homeTab.toString() +"<br>");
        clickOnElement(homeTab);
    }
    public void clickOnCustomerLoginButton(){
        CustomListeners.node.log(Status.PASS,"Click on bank login button" + customerLogin.getText());
        Reporter.log("Click on bank manager login button" + customerLogin.toString() +"<br>");
        clickOnElement(customerLogin);
    }

}
