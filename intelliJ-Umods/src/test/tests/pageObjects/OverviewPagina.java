package tests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPagina extends  AbstractPage {

    public OverviewPagina(WebDriver driver) {
        super(driver);
    }

    // methode om te zien of de overview pagina geladen is
    public  boolean overviewPageCheck() {

        // haal pagina titel op
        String homepageTitle = driver.findElement(By.id("pageTitle")).getText();
        boolean result = homepageTitle.contentEquals( "Overview");
        return  result;
    }

    // methode om squad te selecteren
    public void selectSquad() {

        // zoek de selectbar
        driver.findElement(By.id("select")).click();

        // klik op een select option
        driver.findElement(By.className("mat-option-text")).click();
    }

    // methhode om na te zien of visualties worden weergegeven
    public boolean visualisationCheck() {

        // tell aantal visualties met  klasse 'seeMe'
        int visuCount = driver.findElements(By.className("seeMe")).toArray().length;

        boolean result = visuCount > 0;
        return result;
    }

}
