package tests.overview;

import cucumber.api.java.nl.Gegeven;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.pageObjects.HomePagina;
import tests.pageObjects.LoginPagina;
import tests.pageObjects.OverviewPagina;


public class MyStepdefs {




    WebDriver driver = new FirefoxDriver();
    LoginPagina loginPagina;
    HomePagina homePagina;
    OverviewPagina overviewPagina;

    @Gegeven("^de gebruiker is ingelogd$")
    public void de_gebruiker_is_ingelogd() throws Exception {
        // Write code here that turns the phrase above into concrete actions

        loginPagina =  new LoginPagina(driver);

        // surf naar de webapp
        loginPagina.navigateToWebApp();

        // gebruiker logt zich in
        homePagina =  loginPagina.login();



        // check of de homepagina geladen is
        Assert.assertTrue(homePagina.homePageCheck());

    }

    @En("^beschikt over een squad met leden en taken$")
    public void beschiktOverEenSquadMetLedenEnTaken() throws InterruptedException {

        // kijkt na of gebruiker tot squads behoort
       Assert.assertTrue(homePagina.getSquads());

    }

    @En("^bevindt zich op de overview pagina$")
    public void bevindtZichOpDeOverviewPagina() {

        // surf naar overview pagina
        overviewPagina = homePagina.navigateToOverview();

        // check of de overview geladen is
        Assert.assertTrue(overviewPagina.overviewPageCheck());

    }

    @Als("^de gebruiker een squad selecteert$")
    public void deGebruikerEenSquadSelecteert() {

        // selecteer een squad
        overviewPagina.selectSquad();

    }

    @Dan("^zou de gebruiker een visualisatie moeten zien over de vooruitgang van de squad$")
    public void zouDeGebruikerEenVisualisatieMoetenZienOverDeVooruitgangVanDeSquad() {

        // check of visualisaties worden weergeven
        Assert.assertTrue(overviewPagina.visualisationCheck());

    }
}
