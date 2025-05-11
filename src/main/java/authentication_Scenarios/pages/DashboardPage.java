package authentication_Scenarios.pages;


import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;


public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[contains(.,'Logout')]")
    public WebElement LogoutButton;
    @FindBy(xpath = "//span[@class='text-center']")
    public WebElement planNameElement;
    @FindBy(xpath = "//span[@class='text-sm']")
    public WebElement planTypeElement;
    @FindBy(xpath = "//a[@href='/invoices'][contains(.,'View All')]")
    public WebElement viewAllInvoices;
//locator for last activites
    @FindBy(xpath = "(//div[@class='w-8/12 subject-label'])[1]")
    public WebElement activity1;


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
        // Get all subscribed plan items
        List<WebElement> subscribedPlans = driver.findElements(By.cssSelector("div.subscribed-plans-item"));
/*        assertEquals(String.valueOf(subscribedPlans.size()),expectedPlans.size(),
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

    //verify latest invoices matching with last 4 in voices in invoice page
    public void verifyLatestInvoicesMatching() {
        // Click on the "View All" button to navigate to the invoices page
        viewAllInvoices.click();
        // Locate the table body
        WebElement tableBody = driver.findElement(By.xpath("//table[@role='table']/tbody"));

        // Find all the rows in the table body
        List<WebElement> rows = tableBody.findElements(By.xpath("./tr"));

        // Get the number of rows
        int rowCount = rows.size();

        // Extract the invoice codes from the last four rows
        System.out.println("Last Four Invoice Codes:");
        for (int i = 0; i < Math.min(4, rows.size()); i++) {
            // Locate the 'Code' column cell within the current row
            WebElement codeCell = rows.get(i).findElement(By.xpath("./td[5]")); // Assuming 'Code' is the 5th column

            // Get the text from the 'Code' cell
            String invoiceCode = codeCell.getText();
            System.out.println(invoiceCode);
        }
    }

    public void verifyLatestInvoicesMatchBetweenSections() {
// --- Get the names of the latest invoices ---
        List<WebElement> latestInvoiceNameElements = driver.findElements(By.xpath("//span[@class='name-label']"));
        System.out.println("Found " + latestInvoiceNameElements.size() + " latest invoice items:");
        // Assert.assertEquals(latestInvoiceNameElements.size(), 4, "Number of latest invoices should be 4"); // Keep this if the count is important

        List<String> latestInvoiceNames = new ArrayList<>();
        for (WebElement nameElement : latestInvoiceNameElements) {
            latestInvoiceNames.add(nameElement.getText());
            }
        System.out.println("Latest Invoice Names (List): " + latestInvoiceNames);

        clickOnButton(viewAllInvoices);

        WebElement tableBody = driver.findElement(By.xpath("//table[@role='table']/tbody"));
        List<WebElement> firstFourRows = tableBody.findElements(By.xpath("./tr"));
        List<String> firstFourTableInvoiceNames = new ArrayList<>();
        int count = Math.min(4, firstFourRows.size());
        System.out.println("\nFirst " + count + " Invoice Codes from Table:");
        for (int i = 0; i < count; i++) {
            WebElement codeCell = firstFourRows.get(i).findElement(By.xpath("./td[5]")); // Assuming 'Code' is the 5th column
            String invoiceCode = codeCell.getText();
            firstFourTableInvoiceNames.add(invoiceCode);
            System.out.println(invoiceCode);
        }
        System.out.println("First Four Table Invoice Names (List): " + firstFourTableInvoiceNames);

        // Reverse the list from the table if needed to match the expected order of "latest invoices"
        // Collections.reverse(firstFourTableInvoiceNames); // Uncomment this if a specific reverse order is expected

        // --- Compare the two sets of invoice names (order-insensitive) ---
        Set<String> latestInvoiceNamesSet = new HashSet<>(latestInvoiceNames);
        Set<String> firstFourTableInvoiceNamesSet = new HashSet<>(firstFourTableInvoiceNames);

        Assert.assertEquals("The latest invoice names do not match the first four table invoice names.", latestInvoiceNamesSet,
                firstFourTableInvoiceNamesSet);


    }

}
