package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import javafx.scene.control.Tab;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */

public class BankTest extends TestBase {

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        accountPage = new AccountPage();

    }

    @Test(priority = 0, groups = {"sanit", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {

        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();
        //	click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomer();
        // Send value to enter FirstName
        addCustomerPage.sendFirstName("Amy");
        //Send value to enter LastName
        addCustomerPage.sendLastName("Smith");
        // Send value to enter PostCode
        addCustomerPage.sendPinCode("AW12 23");
        // click On "Add Customer" Button
        addCustomerPage.clickOnAddCustomerButton();
        // Verify message "Customer added successfully" and click on "ok" button on popup.
        String actual = addCustomerPage.verifyPopMessageFromAlert();
        Assert.assertTrue(actual.contains("Customer added successfully"));
        addCustomerPage.acceptAlert();

    }

    @Test(priority = 1, groups = {"sanity", "smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnHomeButton();
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();
        //click On "Open Account" Tab
        bankManagerLoginPage.clickOnOpenAccount();
        // Search customer that created in first test
        openAccountPage.selectCustomerNameFormDopeDown("Amy Smith");
        // Select currency "Pound"
        openAccountPage.selectCurrencyFormDopeDown("Pound");
        // click on "process" button
        openAccountPage.clickOnProcessButton();
        //verify message "Account created successfully"
        String actual = addCustomerPage.verifyPopMessageFromAlert();
        Assert.assertTrue(actual.contains("Account created successfully"));
        addCustomerPage.acceptAlert();

    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void customerShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnHomeButton();
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //Search customer that you created.
        customerLoginPage.selectCustomerNameFormDopeDown("Albus Dumbledore");
        //  click on "Login" Button
        customerLoginPage.clickOnLoginButton();
        // verify "Logout" Tab displayed.
        customerLoginPage.verifyLogOutButtonIsDisplayed();
        customerLoginPage.clickOnLogOutButton();
        //Verify "Your Name" text displayed.
        String expectedText = "---Your Name---";
        String actualText = customerLoginPage.getYourNameText();
        Assert.assertEquals(actualText, expectedText, "Error");

    }

    @Test(priority = 3, groups = {"smoke", "regression"})
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnHomeButton();
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //Search customer that you created.
        customerLoginPage.selectCustomerNameFormDopeDown("Albus Dumbledore");
        //  click on "Login" Button
        customerLoginPage.clickOnLoginButton();
        //click on "Deposit" Tab
        accountPage.clickOnDepositTab();
        //Enter amount 100
        accountPage.enterAmountInDepositTab("100");
        //click on "Deposit" Button
        accountPage.clickDepositButton();
        //verify message "Deposit Successful"
        String expectedText = "Deposit Successful";
        String actualText = accountPage.getDepositSuccessfulText();
        Assert.assertEquals(actualText, expectedText, "Error");
    }

    @Test(priority = 4, groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {

        homePage.clickOnHomeButton();
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //Search customer that you created.
        customerLoginPage.selectCustomerNameFormDopeDown("Albus Dumbledore");
        //  click on "Login" Button
        customerLoginPage.clickOnLoginButton();
        //click on "Withdrawl" Tab
        Thread.sleep(2000);
        accountPage.clickOnWithdrawlTab();
        //Enter amount 50
        accountPage.enterAmountInDepositTab("50");
        //click on "Withdraw" Button
        accountPage.clickWithdrawlButton();
        //verify message "Transaction Successful"
        String expectedText = "Transaction successful";
        String actualText = accountPage.getWithDrawlSuccessfulText();
        Assert.assertEquals(actualText, expectedText, "Error");

    }

}

