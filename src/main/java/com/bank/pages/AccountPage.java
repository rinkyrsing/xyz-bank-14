package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import javax.rmi.CORBA.Util;

public class AccountPage extends Utility {

    public AccountPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[2]")
    WebElement depositTab;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement amountDepositedTab;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement depositButton;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement verifyDepSuccessful;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[3]")
    WebElement withdrawlTab;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement withDrawlButton;

    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement verifyTransactionText;


    public void clickOnDepositTab() {
        CustomListeners.node.log(Status.PASS, "Click on deposit tab : '" + depositTab.getText());
        Reporter.log("Click on 'Deposit Tab'" + depositTab.toString() + "<br>");
        clickOnElement(depositTab);
    }

    public void enterAmountInDepositTab(String amount) {
        CustomListeners.node.log(Status.PASS, "Enter 100 amount in 'Deposit' account : '" + amountDepositedTab.getText());
        Reporter.log("Enter 100 amount in 'Deposit'" + amountDepositedTab.toString() + "<br>");
        sendTextToElement(amountDepositedTab, amount);
    }

    public void clickDepositButton() {
        CustomListeners.node.log(Status.PASS, "Click on deposit button : '" + depositButton.getText());
        Reporter.log("Click on 'Deposit Button'" + depositButton.toString() + "<br>");
        clickOnElement(depositButton);
    }

    public String getDepositSuccessfulText() {
        CustomListeners.node.log(Status.PASS, "Verify the message : '" + verifyDepSuccessful.getText());
        Reporter.log("Verify that amount successfully deposited" + verifyDepSuccessful.toString() + "<br>");
        return getTextFromElement(verifyDepSuccessful);
    }

    public void clickOnWithdrawlTab() {
        CustomListeners.node.log(Status.PASS, "Click on with drawl tab : '" + withdrawlTab.getText());
        Reporter.log("Click on 'Withdrawl Tab'" + withdrawlTab.toString() + "<br>");
        clickOnElement(withdrawlTab);
    }

    public void withdrawalAmountTab(String amount) {
        CustomListeners.node.log(Status.PASS, "With draw 50 from the account '" + amountDepositedTab.getText());
        Reporter.log(" With drawl 50 amount in 'Withdrawl'" + amountDepositedTab.toString() + "<br>");
        sendTextToElement(amountDepositedTab, amount);
    }

    public String getWithDrawlSuccessfulText() {
        CustomListeners.node.log(Status.PASS, "Verify that amount successfully deposited : '" + verifyTransactionText.getText());
        Reporter.log("Verify that amount successfully deposited" + verifyTransactionText.toString() + "<br>");
        return getTextFromElement(verifyTransactionText);
    }

    public void clickWithdrawlButton() {
        CustomListeners.node.log(Status.PASS, "Click on 'Deposit Button'" + withDrawlButton.getText());
        Reporter.log("Click on 'Deposit Button'" + withDrawlButton.toString() + "<br>");
        clickOnElement(withDrawlButton);
    }


}
