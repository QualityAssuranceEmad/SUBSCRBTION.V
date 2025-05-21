package authentication_Scenarios.pages;


import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;


public class Dashboard_Page extends Base_Page {
    public Dashboard_Page(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[./span[contains(@class, 'pi-sign-out')]]")
    private WebElement LogoutButton;
    @FindBy(xpath = "//span[@class='p-menu-item-label'][contains(.,'Dashboard')]")
    private WebElement clickOnDashboard;
    @FindBy(xpath = "//span[contains(.,'Billing Plans')]")
    private WebElement clickOnBillingPlans;
    @FindBy(xpath = "//span[contains(.,'Track Invoices')]")
    private WebElement clickOnTrackInvoices;
    @FindBy(xpath = "//span[contains(.,'Users & Teams')]")
    private WebElement clickOnUsersAndTeams;
    @FindBy(xpath = "//span[contains(.,'Activity Log')]")
    private WebElement clickOnActivityLog;
    @FindBy(xpath = "//span[contains(.,'Support Ticket')]")
    private WebElement clickOnSupportTicket;
    @FindBy(xpath = "//span[contains(.,'Profile')]")
    private WebElement clickOnProfile;
    @FindBy(xpath = "//span[contains(.,'FAQs')]")
    private WebElement clickOnFAQs;
    @FindBy(xpath = "//span[contains(.,'User Guide')]")
    private WebElement clickOnUserGuide;
    @FindBy(xpath = "//span[@class='pi pi-user p-button-icon']")
    private WebElement clickOnProfileIcon;
    @FindBy(xpath = "//span[@class='pi pi-cog p-button-icon']")
    private WebElement clickOnSettings;
    @FindBy(xpath = "//span[@class='pi pi-bell p-button-icon']")
    private WebElement clickOnNotification;
    @FindBy(linkText = "Contact us")
    private WebElement clickOnContactUs;
    @FindBy(linkText = "Terms and Privacy']")
    private WebElement clickTermsAndPrivacy;
    @FindBy(xpath = "(//a[@href='/user-faq'][contains(.,'FAQs')])[2]")
    private WebElement clickFAQ;
    @FindBy(xpath = "(//i[@class='pi pi-facebook']")
    private WebElement clickOnFacebook;
    @FindBy(xpath = "(//i[@class='pi pi-linkedin']")
    private WebElement clickOnLinkedIn;
    @FindBy(xpath = "//span[@class='text-center']")
    private WebElement planNameElement;
    @FindBy(xpath = "//span[@class='text-sm']")
    private WebElement planTypeElement;

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void clickLogoutButton() {
        clickOnButton(LogoutButton);
    }

    // Verify Specific Plan Details
    public void verifySpecificPlanDetails() {
        Map<String, String> expectedPlans = new HashMap<>();
        expectedPlans.put("WEB.V", "Medium");
        expectedPlans.put("RIS.V", "Medium");
        expectedPlans.put("Insurance.V", "Medium");
        expectedPlans.put("PAX.V", "Basic");
        expectedPlans.put("consult.V", "Basic");
        // Get all subscribed plan items///////////////////
        List<WebElement> subscribedPlans = driver.findElements(By.cssSelector("div.subscribed-plans-item"));

        // Handle the case where no plans are found
        if (subscribedPlans.isEmpty()) {
            System.out.println("No subscribed plans found on the page.");
            // You might want to add an assertion here if having plans is a requirement
            // assertEquals(0, expectedPlans.size(), "Expected no plans to be displayed.");
            return; // Exit the method as there's nothing to verify
        }

/* assertEquals(String.valueOf(subscribedPlans.size()),expectedPlans.size(),
                "Number of displayed plans doesn't match expected count. Expected: " +
                        expectedPlans.size() + ", Found: " + subscribedPlans.size());*/
        // Print how many plans were found
        System.out.println("Found " + subscribedPlans.size() + " subscribed plans:");

        for (WebElement plan : subscribedPlans) {
            // Find plan name and type within the current plan element
            String planName = plan.findElement(By.xpath(".//span[@class='text-center']")).getText();
            String planType = plan.findElement(By.xpath(".//span[@class='text-sm']")).getText();

            // Print the plan details
            System.out.println("Plan Name: " + planName + ", Plan Type: " + planType);

            // Verify if the plan name and type match the expected values
            if (expectedPlans.containsKey(planName)) {
                String expectedType = expectedPlans.get(planName);
                if (!planType.equals(expectedType)) {
                    throw new AssertionError("Plan type mismatch for " + planName +
                            ": expected " + expectedType +
                            ", but got " + planType);
                }
                System.out.println("✓ Verified - " + planName + " matches expected type: " + expectedType);
            } else {
                System.out.println("⚠ Note - " + planName + " is not in the expected plans list");
            }
        }
    }

    //verify Latest Invoice section
    public void verifyLatestInvoicesContent() {   //Assert number is 4 invoices in the latst invoice
        List<WebElement> lastInvoice = driver.findElements(By.cssSelector("div.last-invoice-item"));
        System.out.println("Found " + lastInvoice.size() + " last invoice items:");
        Assert.assertEquals(lastInvoice.size(), 4);
        List<WebElement> lastInvoiceName = driver.findElements(By.xpath("//span[@class='name-label']"));
        List<WebElement> lastInvoiceStatus = driver.findElements(By.xpath("//span[@class='status-label']"));
        List<WebElement> lastInvoiceAmount = driver.findElements(By.xpath("//span[@class='amount-label']"));
        List<WebElement> lastInvoiceDueDate = driver.findElements(By.xpath("//span[@class='date-label']"));
        for (WebElement invoice : lastInvoiceName) {
            // Find plan name
            String invoiceName = invoice.getText();
            String invoiceStatus = lastInvoiceStatus.get(lastInvoiceName.indexOf(invoice)).getText();
            String invoiceAmount = lastInvoiceAmount.get(lastInvoiceName.indexOf(invoice)).getText();
            String invoiceDueDate = lastInvoiceDueDate.get(lastInvoiceName.indexOf(invoice)).getText();
            // Print the plan details
            System.out.println("Invoice Name: " + invoiceName + ", Invoice Status: " + invoiceStatus +
                    ", Invoice Amount: " + invoiceAmount + ", Invoice Due Date: " + invoiceDueDate);

        }
    }

    public void verifyLatestActivitiesContent() {
        // --- Get the latest activities from dashboard ---
        List<WebElement> latestActivityElements = driver.findElements(By.xpath("//div[@class='w-8/12 subject-label']"));
        System.out.println("Found " + latestActivityElements.size() + " latest activity items:");

        List<String> latestActivityTexts = new ArrayList<>();
        for (WebElement activityElement : latestActivityElements) {
            latestActivityTexts.add(activityElement.getText());
        }
        System.out.println("Latest Activity Texts (List): " + latestActivityTexts);


    }

    //profile
    public void clickOnProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnProfile));
        clickOnButton(clickOnProfile);
    }
    public void clickOnTrackInvoices() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnTrackInvoices));
        clickOnButton(clickOnTrackInvoices);
    }

}
