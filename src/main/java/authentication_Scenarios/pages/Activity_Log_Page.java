package authentication_Scenarios.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Activity_Log_Page extends Base_Page{
    public Activity_Log_Page(WebDriver driver) {
        super(driver);
    }
    //locator for last activites
    @FindBy(xpath = "(//div[@class='w-8/12 subject-label'])[1]")
    public WebElement activity1;
    @FindBy(xpath = "(//div[@class='w-8/12 subject-label'])[2]")
    public WebElement activity2;
    @FindBy(xpath = "(//div[@class='w-8/12 subject-label'])[3]")
    public WebElement activity3;
    @FindBy(xpath = "(//div[@class='w-8/12 subject-label'])[4]")
    public WebElement activity4;
    @FindBy(xpath = "//a[@href='/activities'][contains(.,'View All')]")
    public WebElement viewAllActivities;
    public void verifyLatestActivitiesMatchBetweenSections() {
        // --- Get the latest activities from dashboard ---
        List<WebElement> latestActivityElements = driver.findElements(By.xpath("//div[@class='w-8/12 subject-label']"));
        System.out.println("Found " + latestActivityElements.size() + " latest activity items:");

        List<String> latestActivityTexts = new ArrayList<>();
        for (WebElement activityElement : latestActivityElements) {
            latestActivityTexts.add(activityElement.getText());
        }
        System.out.println("Latest Activity Texts (List): " + latestActivityTexts);

        // --- Navigate to full activities view ---
        clickOnButton(viewAllActivities);

        // --- Get first 4 activities from table ---
        WebElement tableBody = driver.findElement(By.cssSelector("p-table > div > div.p-datatable-table-container > table > tbody"));
        List<WebElement> firstFourRows = tableBody.findElements(By.xpath("./tr"));
        List<String> firstFourTableActivities = new ArrayList<>();

        int count = Math.min(4, firstFourRows.size());
        System.out.println("\nFirst " + count + " Activities from Table:");
        for (int i = 0; i < count; i++) {
            WebElement activityCell = firstFourRows.get(i).findElement(By.xpath("./td[1]")); // Assuming activity is first column
            String activityText = activityCell.getText();
            firstFourTableActivities.add(activityText);
            System.out.println(activityText);
        }
        System.out.println("First Four Table Activities (List): " + firstFourTableActivities);


        Assert.assertEquals(
                "The latest activities do not match the first four table activities",
                latestActivityTexts,
                firstFourTableActivities
        );

    }
    public void verifyLastTicketsMatchBetweenSections() {



    }
}
