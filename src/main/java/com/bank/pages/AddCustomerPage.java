package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")
    WebElement firstName;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]")
    WebElement lastName;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]")
    WebElement postCode;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")
    WebElement addCustomerTabInCustomer;

    @FindBy(xpath = "")
    WebElement verifyMessage;

    public void sendFirstName(String text) {
        CustomListeners.node.log(Status.PASS, "Enter first name field " + text + "' first name field : " + firstName.getText());
        Reporter.log("Enter first name field " + text + firstName.toString() + "<br>");
        sendTextToElement(firstName, text);
    }

    public void sendLastName(String text) {
        CustomListeners.node.log(Status.PASS, "Enter last name field : " + text + "' to last name feild : " + lastName.getText());
        Reporter.log("Enter last name field " + text + lastName.toString() + "<br>");
        sendTextToElement(lastName, text);
    }

    public void clickOnAddCustomerButton() {
        CustomListeners.node.log(Status.PASS, "Click on add customer button" + addCustomerTabInCustomer.getText());
        Reporter.log("Click on add customer button" + addCustomerTabInCustomer.toString() + "<br>");
        clickOnElement(addCustomerTabInCustomer);
    }

    public void sendPinCode(String text) {
        CustomListeners.node.log(Status.PASS, "Enter Post code '" + text + "' to post field : " + postCode.getText());
        Reporter.log("Enter Post code" + text + postCode.getText() + "<br>");
        sendTextToElement(postCode, text);
    }

    public String verifyPopMessageFromAlert() {
        CustomListeners.node.log(Status.PASS, "Verifying pop up message: " + toString());
        Reporter.log("verify the pop message : " + " Customer added successfully " + "<br>");
        return getTextFromAlert();
    }


}
