package tests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public  class AbstractPage {

    protected WebDriver driver;

    public AbstractPage (WebDriver driver) {
        this.driver = driver;
    }

    // navigeer naar webApp
    public LoginPagina navigateToWebApp() {

        driver.navigate().to("https://uw-vent-onder-de-sloef.web.app/");
        return  new LoginPagina(driver);
    }

    // navigeer naar overview page
    public OverviewPagina navigateToOverview() {

        driver.findElement(By.id("overviewLink")).click();
        return new OverviewPagina(driver);
    }

    // navigeer naar overview page
    public TaskPagina navigateToSquadPage() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.className("card")).click();
        return new TaskPagina(driver);
    }

    // mehode om notifcatie op te halen en te verglijken
    public boolean checkNotif(String notif) throws InterruptedException {

        Thread.sleep(2000);
        String getNotif = driver.findElement(By.tagName("snack-bar-container")).getText();
        System.out.println(getNotif);
        boolean result = notif.contentEquals(getNotif);
        return result;
    }

    // browser sluiten
    public void closeDriver () throws InterruptedException {

        Thread.sleep(3000);
        driver.close();
    }

}
