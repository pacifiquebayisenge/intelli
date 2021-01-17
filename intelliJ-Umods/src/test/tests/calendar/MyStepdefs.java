package tests.calendar;

import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tests.pageObjects.CalendarPage;
import tests.pageObjects.HomePagina;
import tests.pageObjects.LoginPagina;
import tests.pageObjects.TaskPagina;

public class MyStepdefs {

    WebDriver driver = new FirefoxDriver();

    HomePagina homePagina;
    LoginPagina loginPagina;
    CalendarPage calendarPage;
    TaskPagina taskPagina;

    @Gegeven("^de gebruiker is ingelogd$")
    public void de_gebruiker_is_ingelogd() throws Exception {

        loginPagina = new LoginPagina(driver);

        // surf naar de webapp
        loginPagina.navigateToWebApp();

        // gebruiker logt zich in
        homePagina = loginPagina.login();
    }

    @En("^bevindt zich op de homepagina$")
    public void bevindtZichOpDeHomepagina() throws Throwable {

        // check of de homepagina geladen is
        Assert.assertTrue(homePagina.homePageCheck());
    }

    @Gegeven("^de gebruiker is niet lid van een squad$")
    public void deGebruikerIsNietLidVanEenSquad() throws Throwable {

        homePagina.logout();
        loginPagina.geenSquadLogin();

        // kijk na of huidige gebruiker deel uitmaakt van een squad
        Assert.assertEquals(0, homePagina.getSquadCount());

    }

    @Als("^de gebruiker de kalender wil visualiseren$")
    public void deGebruikerDeKalenderWilVisualiseren() throws Throwable {


       calendarPage =  homePagina.navigateToCalPage();
    }

    @Dan("^wordt de gebruiker terug naar de home pagina herleid$")
    public void wordtDeGebruikerTerugNaarDeHomePaginaHerleid() throws Throwable {

        // kijk na of de home pagina geladen is
        homePagina.homePageCheck();

    }

    @En("^zou de gebruiker \"([^\"]*)\" moeten zien opkomen$")
    public void zouDeGebruikerMoetenZienOpkomen(String notif) throws Throwable {

        // kijk na of notificatie verschijnt
        homePagina.checkNotif(notif);
    }

    @Gegeven("^de gebruiker is lid van een squad$")
    public void deGebruikerIsLidVanEenSquad() throws Throwable {

        homePagina.logout();
        loginPagina.squadZonderTakenLogin();
    }

    @En("^de gebruiker heeft geen toegewezen taken$")
    public void deGebruikerHeeftGeenToegewezenTaken() throws Throwable  {

        // surf naar de squad pagina
        taskPagina = homePagina.navigateToSquadPage();

        Thread.sleep(5000);

        // kijk na of er tasks zijn toegewezen aan de huidige gebruiker
        Assert.assertEquals(0, taskPagina.getTaskCount("Lea appelmans"));


    }

    @Dan("^wordt de gebruiker doorverwezen naar de kalender pagina$")
    public void wordtDeGebruikerDoorverwezenNaarDeKalenderPagina() throws Throwable {

        // surf naar de Kalender pagina
        calendarPage =  homePagina.navigateToCalPage();

        // kijk na of de kalender pagina geladen wordt
        Assert.assertTrue( calendarPage.calendarPageCheck());
    }

    @En("^ziet de gebruiker geen taken op de kalender$")
    public void zietDeGebruikerGeenTakenOpDeKalender() throws Throwable {

        // tell aantal kalender evenementen (=tasks)
        Assert.assertEquals(0 ,calendarPage.getCalTasksCount());
    }

    @Gegeven("^de gebruiker is lid van een squad met taken$")
    public void deGebruikerIsLidVanEenSquadMetTaken() throws Throwable {

        homePagina.logout();
        loginPagina.squadMetTakenLogin();


    }

    @En("^de gebruiker heeft toegewezen taken$")
    public void deGebruikerHeeftToegewezenTaken() throws Throwable {

        // surf naar de squad pagina
        taskPagina = homePagina.navigateToSquadPage();

        Thread.sleep(5000);

        // kijk na of er tasks zijn toegewezen aan de huidige gebruiker
        Assert.assertTrue( taskPagina.getTaskCount("Theodore Kwizera") > 0);
    }


    @En("^ziet de gebruiker taken op de kalender$")
    public void zietDeGebruikerTakenOpDeKalender() throws Throwable {

        // tell aantal kalender evenementen (=tasks)
        Assert.assertTrue(calendarPage.getCalTasksCount() > 0);
    }


}
