package tests.task;


import cucumber.api.java.nl.Gegeven;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tests.pageObjects.HomePagina;
import tests.pageObjects.LoginPagina;
import tests.pageObjects.TaskPagina;

public class MyStepdefs {

    WebDriver driver = new FirefoxDriver();
    LoginPagina loginPagina;
    HomePagina homePagina;
    TaskPagina taskPagina;

    String huidigTaskTitle;
    String nieuwTaskTitle;

    @Gegeven("^de gebruiker is ingelogd$")
    public void de_gebruiker_is_ingelogd() throws Exception {

        loginPagina = new LoginPagina(driver);

        // surf naar de webapp
        loginPagina.navigateToWebApp();

        // gebruiker logt zich in
        homePagina = loginPagina.login();

        Thread.sleep(5000);
    }


    @En("^bevindt zich op de pagina van de gekozen groep$")
    public void bevindtZichOpDePaginaVanDeGekozenGroep() throws InterruptedException {

        // surf naar de squad pagina
        taskPagina = homePagina.navigateToSquadPage();
        Thread.sleep(5000);
    }

    @Als("^de gebruiker een task aanmaakt met de naam \"([^\"]*)\"$")
    public void deGebruikerEenTaskAanmaaktMetDeNaam(String taskTitle) throws Throwable {

        huidigTaskTitle = taskTitle;

        taskPagina.openTaskForm();
        taskPagina.setTitleField(taskTitle);
        taskPagina.setSelect();
        taskPagina.submit();
    }

    @Dan("^zou de gebruiker \"([^\"]*)\" moeten zien verschijnen$")
    public void zouDeGebruikerMoetenZienVerschijnen(String notif) throws Throwable {

        // haal notificatie op
        Assert.assertTrue(taskPagina.checkNotif(notif));
    }

    @En("^wordt de pagina herladen met de nieuw gemaakte task$")
    public void wordtDePaginaHerladenMetDeNieuwGemaakteTask() throws Throwable {

        Assert.assertTrue(taskPagina.taskCheck(huidigTaskTitle));
    }

    @Als("^de gebruiker de naam van een task wijzigt naar \"([^\"]*)\"$")
    public void deGebruikerDeNaamVanEenTaskWijzigtNaar(String taskTitle) throws Throwable {

        huidigTaskTitle = "huiswerk maken";
        nieuwTaskTitle = taskTitle;
        taskPagina.clickTask(huidigTaskTitle);
        taskPagina.openEditTaskForm();
        taskPagina.setTitleField(nieuwTaskTitle);
        taskPagina.submit();

    }



    @En("^wordt de pagina herladen met de gewijzigde task$")
    public void wordtDePaginaHerladenMetDeGewijzigdeTask() throws Throwable {

       Assert.assertTrue( taskPagina.taskCheck(nieuwTaskTitle));
    }

    @Als("^de gebruiker een task verwijdert$")
    public void deGebruikerEenTaskVerwijdert() throws Throwable {
        huidigTaskTitle = "studeren voor de toets";
        taskPagina.clickTask(huidigTaskTitle);
        taskPagina.delTask();


    }

    @Dan("^wordt de pagina herladen en is de verwijderde task niet meer zichtbaar$")
    public void wordtDePaginaHerladenEnIsDeVerwijderdeTaskNietMeerZichtbaar() throws Throwable {

        Assert.assertFalse(taskPagina.taskCheck(huidigTaskTitle));
    }

    @Als("^de gebruiker een task aanmaakt met ongeldige gegevens$")
    public void deGebruikerEenTaskAanmaaktMetOngeldigeGegevens()  throws Throwable{

        taskPagina.openTaskForm();
        taskPagina.setInvalidFields();
        taskPagina.setInvalidFields();



    }

    @Dan("^zou de gebruiker de task niet moeten kunnen aanmaken$")
    public void zouDeGebruikerDeTaskNietMoetenKunnenAanmaken() throws Throwable {

        Assert.assertFalse(taskPagina.isClickable());
    }



}
