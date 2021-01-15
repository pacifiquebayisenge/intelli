package tests.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagina extends AbstractPage {

    public HomePagina(WebDriver driver) {
        super(driver);
    }

    // methoden om te zien of de homepagina geladen is
    public  boolean homePageCheck() {

        // haal pagina titel op
        String homepageTitle = driver.findElement(By.id("pageTitle")).getText();
        boolean result = homepageTitle.contentEquals( "Squad List");
        return  result;

    }


    // methode om na te zien of er al squads bestaan
    public boolean getSquads() {

        // haal aantal bestaande squads op
        int squadCount =  driver.findElements(By.className("card")).toArray().length;

        boolean result = squadCount > 0;
        return result;
    }


}
