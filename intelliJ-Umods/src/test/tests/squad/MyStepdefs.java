package tests.squad;

import cucumber.api.PendingException;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.pageObjects.HomePagina;
import tests.pageObjects.LoginPagina;
import tests.pageObjects.OverviewPagina;


public class MyStepdefs {

    WebDriver driver = new FirefoxDriver();
    LoginPagina loginPagina;
    HomePagina homePagina;
    OverviewPagina overviewPagina;

    int huidigSqCount;
    int nieuwSqCount;

    String huidigMembCount;
    String nieuwMembCount;

    String huidigSqName;
    String nieuwSqName;


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

        // haal huidige squad aantal op
        huidigSqCount = homePagina.getSquadCount();
    }

    @Als("^de gebruiker een squad aanmaakt met de naam \"([^\"]*)\"$")
    public void deGebruikerEenSquadAanmaaktMetDeNaam(String squadName) throws Throwable {

        // open form om nieuwe squad te maken
        homePagina.openNewSquadForm();

        // vul naam in
        homePagina.setSqNameField(squadName);

        // kies icon
        homePagina.setSqIconField();

        // submit
        homePagina.submitSqForm();
    }

    @Dan("^zou de gebruiker \"([^\"]*)\" moeten zien verschijnen$")
    public void zouDeGebruikerMoetenZienVerschijnen(String notif) throws Throwable {

        // haal notificatie op
        Assert.assertTrue(homePagina.checkNotif(notif));
    }


    @En("^wordt de pagina herladen met de nieuw gemaakte squad$")
    public void wordtDePaginaHerladenMetDeNieuwGemaakteSquad() {

        // haal nieuw aantal squads op
        nieuwSqCount = homePagina.getSquadCount();

        Assert.assertTrue(nieuwSqCount > huidigSqCount);
    }

    @Als("^de gebruiker een nieuwe squad aanmaakt met de naam \"([^\"]*)\"$")
    public void deGebruikerEenNieuweSquadAanmaaktMetDeNaam(String squadName) throws Throwable {

        // open form om nieuwe squad te maken
        homePagina.openNewSquadForm();

        // vul naam in
        homePagina.setSqNameField(squadName);

        // kies icon
        homePagina.setSqIconField();
    }

    @En("^een nieuw lid toevoegd$")
    public void eenNieuwLidToevoegd() throws Throwable {

        // voeg nieuw lid toe
        homePagina.addMember();

        // submit
        homePagina.submitSqForm();
    }

    @En("^is het nieuw lid succesvol toegevoegd in de squad \"([^\"]*)\"$")
    public void isHetNieuwLidSuccesvolToegevoegdInDeSquad(String squadName) throws Throwable {

        // kijk na of aantal members verhoogd is
        nieuwMembCount = homePagina.getMemCount(squadName);
        Assert.assertTrue(nieuwMembCount.compareTo("1") > 0);
    }

    @Als("^de gebruiker een squad aanmaakt met ongeldige gegevens$")
    public void deGebruikerEenSquadAanmaaktMetOngeldigeGegevens() throws Throwable {

        // open new squad form
        homePagina.openNewSquadForm();

        // vul ongedilge gegevens in
        homePagina.setInvalidfFields();
    }

    @Dan("^zou de gebruiker de squad niet moeten kunnen aanmaken$")
    public void zouDeGebruikerDeSquadNietMoetenKunnenAanmaken() throws Throwable {

        // kijk na of de squad gesubmit kan worden
        Assert.assertFalse(homePagina.isClickable());
    }


    @Als("^de gebruiker de naam van een squad wijzigt naar \"([^\"]*)\"$")
    public void deGebruikerDeNaamVanEenSquadWijzigtNaar(String squadName) throws Throwable {

        // haal huidige squad naam op
        huidigSqName = homePagina.getSquadName("School");
        nieuwSqName = squadName;

        // wijzig squad naam
        homePagina.openEditSquadForm();
        homePagina.selectSquad(huidigSqName);
        homePagina.clearField();
        homePagina.setSqNameField(squadName);

        homePagina.submitSqForm();
    }

    @En("^wordt de pagina herladen met de gewijzigde squad$")
    public void wordtDePaginaHerladenMetDeGewijzigdeSquad() {

        // kijk na of squad naam gewijzigd is
        Assert.assertFalse(huidigSqName.equals(homePagina.getSquadName(nieuwSqName)));
    }

    @Als("^de gebruiker een squad verwijdert$")
    public void deGebruikerEenSquadVerwijdert() throws Throwable {

        // haal huidig aantal squad op
        huidigSqCount = homePagina.getSquadCount();

        homePagina.openDelSquadForm();
        homePagina.selectSquad("Chiro");
        homePagina.deleteSq();
    }

    @En("^wordt de pagina herladen en is de verwijderde squad niet meer zichtbaar$")
    public void wordtDePaginaHerladenEnIsDeVerwijderdeSquadNietMeerZichtbaar() {

        // kijk na of aantal sqaud verminderd is
        nieuwSqCount = homePagina.getSquadCount();
        Assert.assertTrue(nieuwSqCount < huidigSqCount);
    }

    @Als("^de gebruiker een 'nieuw lid' toevoegd bij een squad$")
    public void deGebruikerEenNieuwLidToevoegdBijEenSquad() throws Throwable {

        // haal huidig aantal members op
        huidigMembCount = homePagina.getMemCount("Studiegroep");

        // voeg nieuw lid toe
        homePagina.openEditSquadForm();
        homePagina.selectSquad("Studiegroep");
        homePagina.addMember();

        // submit
        homePagina.submitSqForm();
    }

    @Dan("^wordt de pagina herladen en en is het aantal leden bij de gewijzigde squad verhoogd met één$")
    public void wordtDePaginaHerladenEnEnIsHetAantalLedenBijDeGewijzigdeSquadVerhoogdMetÉén() throws Throwable {

        // vergelijk aantal members
        nieuwMembCount = homePagina.getMemCount("Studiegroep");
        Assert.assertTrue(nieuwMembCount.compareTo(huidigMembCount) > 0);
    }

    @Als("^de gebruiker een 'nieuw lid' verwijdert bij een squad$")
    public void deGebruikerEenNieuwLidVerwijdertBijEenSquad() throws Throwable {

        // haal huidig aantal members op
        huidigMembCount = homePagina.getMemCount("Studiegroep");

        // verwijder lid
        homePagina.openEditSquadForm();
        homePagina.selectSquad("Studiegroep");
        homePagina.deleteMem("steven");
        homePagina.closeSqForm();
    }

    @Dan("^wordt de pagina herladen en en is het aantal leden bij de gewijzigde squad vermindert met één$")
    public void wordtDePaginaHerladenEnEnIsHetAantalLedenBijDeGewijzigdeSquadVermindertMetÉén() throws Throwable {


        // vergelijk aantal members
        nieuwMembCount = homePagina.getMemCount("Studiegroep");
        Assert.assertTrue(nieuwMembCount.compareTo(huidigMembCount) < 0);
    }


}
