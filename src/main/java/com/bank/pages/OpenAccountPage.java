package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.Optional;

public class OpenAccountPage extends Utility {


    public OpenAccountPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userSelect")
    WebElement clickOnCustomer;

    @FindBy(id = "currency")
    WebElement currencyTab;

    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;



    public void selectCustomerNameFormDopeDown(String text){
        CustomListeners.node.log(Status.PASS, "Enter customer name : '" + text + "' customer name" + clickOnCustomer.getText());
        Reporter.log("Select customer from drop down" + text + clickOnCustomer.toString() + "<br>");
        selectByVisibleTextFromDropDown(clickOnCustomer, text);
    }
    public void selectCurrencyFormDopeDown(String text){
        CustomListeners.node.log(Status.PASS, "Select currency : '" + text + currencyTab.getText());
        Reporter.log("Select currency" + text + currencyTab.toString() + "<br>");
        selectByVisibleTextFromDropDown(currencyTab, text);
    }
    public void clickOnProcessButton(){
        CustomListeners.node.log(Status.PASS, "Click on process Button : '" + processButton.getText());
        Reporter.log("Click on process button : '" + processButton.toString() + "<br>");
        clickOnElement(processButton);
    }
    public String verifyPopMessageFromAlert()
    {
        CustomListeners.node.log(Status.PASS, "Verify the pop up message : '" );
        Reporter.log("Verify the pop message : "+"Customer added sucessfully" + "<br>");
        return getTextFromAlert();
    }




}
