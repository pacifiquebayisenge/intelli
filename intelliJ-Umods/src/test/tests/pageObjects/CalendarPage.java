package tests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarPage extends AbstractPage {

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    // methode om te zien of de kalender pagina geladen is
    public boolean calendarPageCheck() throws InterruptedException {

        Thread.sleep(3000);

        // haal pagina titel op
        String homepageTitle = driver.findElement(By.id("pageTitle")).getText();
        boolean result = homepageTitle.contentEquals( "Calendar");
        return  result;
    }

    public int getCalTasksCount() throws InterruptedException {

        Thread.sleep(3000);

        int count = driver.findElements(By.className("e-appointment")).toArray().length;
        return count;
    }

}
