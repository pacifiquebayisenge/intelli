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

        driver.navigate().to("http://localhost:4200/");
        return  new LoginPagina(driver);
    }

    // navigeer naar overview page
    public OverviewPagina navigateToOverview() {

        driver.findElement(By.id("overviewLink")).click();
        return new OverviewPagina(driver);
    }

    // navigeer naar overview page
    public SquadPagina navigateToSquadPage() {

        driver.findElement(By.id("overviewLink")).click();
        return new SquadPagina(driver);
    }

    // browser sluiten
    public void closeDriver () throws InterruptedException {

        Thread.sleep(3000);
        driver.close();
    }

}
