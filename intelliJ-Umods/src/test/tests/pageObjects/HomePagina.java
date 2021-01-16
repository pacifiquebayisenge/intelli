package tests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagina extends AbstractPage {

    public HomePagina(WebDriver driver) {
        super(driver);
    }

    // methoden om te zien of de homepagina geladen is
    public boolean homePageCheck() throws InterruptedException {

        Thread.sleep(2000);
        // haal pagina titel op
        String homepageTitle = driver.findElement(By.id("pageTitle")).getText();
        boolean result = homepageTitle.contentEquals("Squad List");
        return result;
    }

    // methode om na te zien of er al squads bestaan
    public boolean getSquads() {

        // haal aantal bestaande squads op
        int squadCount = driver.findElements(By.className("card")).toArray().length;
        boolean result = squadCount > 0;
        return result;
    }

    // methode om aantal sqauds op te halen
    public int getSquadCount() {

        int squadCount = driver.findElements(By.className("card")).toArray().length;
        return squadCount;
    }

    // methode om nieuwe squad form te opennen
    public void openNewSquadForm() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.id("crudMenu")).click();
        driver.findElement(By.id("btnNewSq")).click();
    }

    // methode om edit squad form te opennen
    public void openEditSquadForm() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.id("crudMenu")).click();
        driver.findElement(By.id("btnEditSq")).click();
    }

    // methode om delete squad form te opennen
    public void openDelSquadForm() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.id("crudMenu")).click();
        driver.findElement(By.id("btnDelSq")).click();
    }

    // methode om squad naam in te vullen
    public void setSqNameField(String name) {

        driver.findElement(By.id("squadTitle")).sendKeys(name);
    }

    // methode om icon te kiezen
    public void setSqIconField() {

        // zoek de selectbar
        driver.findElement(By.id("select")).click();

        // klik op een select option
        driver.findElement(By.id("icon_school")).click();
    }

    // methode om nieuw lid toe te voegen
    public void addMember() throws InterruptedException {

        driver.findElement(By.id("btnaddMem")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("membInput")).sendKeys("sb@hotmail.com");
    }

    // methode om form te submitten
    public void submitSqForm() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.id("sqSubmit")).click();
    }

    // methode om het aantal membet op te halen
    public String getMemCount(String squadName) throws InterruptedException {

        Thread.sleep(2000);
        String membCount = driver.findElement(By.id(squadName + "_membCount")).getText();
        return membCount;
    }

    // methode om ongeldige gegevens in te voeren
    public void setInvalidfFields() throws InterruptedException {

        driver.findElement(By.id("btnaddMem")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("membInput")).sendKeys("sb@.com");
        driver.findElement(By.id("btnaddMem")).click();
    }

    // methode om na te gan of men kan submitten
    public boolean isClickable() throws InterruptedException {
        Thread.sleep(2000);
        // kijk na of submit knop klikbaar is
        try {
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("sqSubmit"))));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // methode om squad name op te halen
    public String getSquadName(String squadName) {

        return driver.findElement(By.id("cardTitle_" + squadName)).getText();
    }

    // methode om een squad te selecteren
    public void selectSquad(String squadName) throws InterruptedException {

        // zoek de selectbar
        driver.findElement(By.id("select")).click();

        Thread.sleep(1000);

        // klik op een select option
        driver.findElement(By.id("selectOpt_" + squadName)).click();
    }

    // methode om veld leeg te maken
    public void clearField() {

        driver.findElement(By.id("squadTitle")).clear();
    }

    // methode om form te submitten
    public void deleteSq() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.id("btnDelete")).click();
    }

    public void deleteMem(String memName) throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.id("btnDel_" + memName)).click();
    }

    // methode om squad form te sluiten
    public void closeSqForm() throws InterruptedException {

        Thread.sleep(500);
        driver.findElement(By.id("btnCancel")).click();
    }


}
