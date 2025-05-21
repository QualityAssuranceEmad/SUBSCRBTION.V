package authentication_Scenarios.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Track_Invoices_Page extends Base_Page{
    public Track_Invoices_Page(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@href='/invoices'][contains(.,'View All')]")
    public WebElement viewAllInvoices;
    @FindBy(xpath = "(//th[@class='p-datatable-sortable-column ng-star-inserted'])[4]")
    public WebElement clickOnCodeArrange;
    //pagination count in track invoices
    @FindBy(xpath = "//button[@aria-label='First Page']")
    public WebElement pageArrowClickFirst;
    @FindBy(xpath = "//button[@aria-label='Last Page']")
    public WebElement pageArrowClick;
    @FindBy(xpath = "//button[@aria-label='Next Page']")
    public WebElement pageArrowClickNext;
    @FindBy(xpath = "//tr[@class='ng-star-inserted']/parent::thead")
    public WebElement numberOfRows;
    @FindBy(xpath = "//button[@class='p-ripple p-paginator-page p-paginator-page-selected ng-star-inserted']")
    public WebElement paginationCount;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        actionPerforme(clickOnCodeArrange);
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
    public void verifyPaginationCount() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(pageArrowClick));
        clickOnButton(pageArrowClick);
        String paginationText = paginationCount.getText();
        // Print the pagination text
        System.out.println("Pagination Count: " + paginationText);
        // Extract the number from the text
        String[] parts = paginationText.split(" ");
        int paginationCountValue = Integer.parseInt(parts[0]);
        System.out.println("Extracted Pagination Count: " + paginationCountValue);
        // Click on the first page button
        wait.until(ExpectedConditions.elementToBeClickable(pageArrowClickFirst));
        clickOnButton(pageArrowClickFirst);
        ////////////////////////////////////////
        Thread.sleep(2000);
        boolean hasNextPage = true;
        int pageCount = 1;

        while (hasNextPage) {
            System.out.println("===== Processing Page " + pageCount + " =====");

            // Print table headers
            WebElement table = driver.findElement(By.cssSelector("table.p-datatable-table"));
            List<WebElement> headers = table.findElements(By.cssSelector("thead th"));
            System.out.println("\nTable Headers:");
            for (WebElement header : headers) {
                System.out.print(header.getText() + " | ");
            }
            System.out.println("\n" + "-".repeat(80));

            // Print table rows
            List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
            System.out.println("\nTable Data:");
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.cssSelector("td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + " | ");
                }
                System.out.println();
            }

            // Check for next page
            try {
                WebElement nextButton = driver.findElement(By.cssSelector("button.p-paginator-next"));
                if (nextButton.isEnabled() && !nextButton.getAttribute("class").contains("p-disabled")) {
                    System.out.println("\nMoving to next page...");
                    nextButton.click();
                    // Wait for page to load
                    Thread.sleep(2000);
                    pageCount++;
                } else {
                    hasNextPage = false;
                    System.out.println("\nNo more pages available");
                }
            } catch (Exception e) {
                hasNextPage = false;
                System.out.println("\nPagination not found or last page reached");
            }
        }

        System.out.println("\nFinished processing all pages");



    }

}
