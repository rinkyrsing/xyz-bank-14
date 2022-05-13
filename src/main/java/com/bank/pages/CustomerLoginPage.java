package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.IDynamicGraph;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    public CustomerLoginPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userSelect")
    WebElement clickOnCustomer;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement verifyLogoutButton;

    @FindBy(xpath = "//option[contains(text(),'---Your Name---')]")
    WebElement verifyYourName;

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logOutButton;


    public void selectCustomerNameFormDopeDown(String text) {
        Reporter.log("Select customer from drop down" + text + clickOnCustomer.toString() + "<br>");
        CustomListeners.node.log(Status.PASS, "Select customer from drop down" + text + "'");
        selectByVisibleTextFromDropDown(clickOnCustomer, text);
    }

    public void clickOnLoginButton() {
        CustomListeners.node.log(Status.PASS, "Click on login button : '" + loginButton.getText());
        Reporter.log("Click on login button : '" + loginButton.toString() + "<br>");
        clickOnElement(loginButton);
    }

    public void clickOnLogOutButton() {
        CustomListeners.node.log(Status.PASS, "Click on login out button : '" + verifyLogoutButton.getText());
        Reporter.log("click on login out button" + verifyLogoutButton.toString() + "<br>");
        clickOnElement(verifyLogoutButton);
    }
    public String getYourNameText() {
        CustomListeners.node.log(Status.PASS, "Verify 'your Name' " + verifyYourName.getText());
        Reporter.log("Verify on 'Your Name' " + verifyYourName.toString() + "<br>");
        return getTextFromElement(verifyYourName);
    }

    public void verifyLogOutButtonIsDisplayed() {
        CustomListeners.node.log(Status.PASS, "Verify 'Logout' tab '" + logOutButton.getText());
        Reporter.log("Verify 'Logout' tab " + logOutButton.toString());
        verifyThatElementIsDisplayed(logOutButton);
    }

}
