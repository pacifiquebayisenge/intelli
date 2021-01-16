package tests.task;


import cucumber.api.PendingException;
import cucumber.api.java.nl.Gegeven;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;

public class MyStepdefs {

    @Gegeven("^de gebruiker is ingelogd$")
    public void de_gebruiker_is_ingelogd() throws Exception {
        // Write code here that turns the phrase above into concrete actions

    }


    @En("^bevindt zich op de pagina van de gekozen groep$")
    public void bevindtZichOpDePaginaVanDeGekozenGroep() {
    }

    @Als("^de gebruiker een task aanmaakt met de naam 'huiswerk maken'$")
    public void deGebruikerEenTaskAanmaaktMetDeNaamHuiswerkMaken() {
    }

    @Dan("^zou de gebruiker 'task succesfully created' moeten zien verschijnen$")
    public void zouDeGebruikerTaskSuccesfullyCreatedMoetenZienVerschijnen() {
    }

    @En("^wordt de pagina herladen met de nieuw gemaakte task$")
    public void wordtDePaginaHerladenMetDeNieuwGemaakteTask() {
    }

    @Als("^de gebruiker de naam van een task wijzigt naar 'studeren voor de toets'$")
    public void deGebruikerDeNaamVanEenTaskWijzigtNaarStuderenVoorDeToets() {
    }

    @Dan("^zou de gebruiker 'task succesfully edited' moeten zien verschijnen$")
    public void zouDeGebruikerTaskSuccesfullyEditedMoetenZienVerschijnen() {
    }

    @En("^wordt de pagina herladen met de gewijzigde task$")
    public void wordtDePaginaHerladenMetDeGewijzigdeTask() {
    }

    @Als("^de gebruiker een task verwijdert$")
    public void deGebruikerEenTaskVerwijdert() {
    }

    @Dan("^wordt de pagina herladen en is de verwijderde task niet meer zichtbaar$")
    public void wordtDePaginaHerladenEnIsDeVerwijderdeTaskNietMeerZichtbaar() {
    }

    @Als("^de gebruiker een task aanmaakt met ongeldige gegevens$")
    public void deGebruikerEenTaskAanmaaktMetOngeldigeGegevens() {
    }

    @Dan("^zou de gebruiker de task niet moeten kunnen aanmaken$")
    public void zouDeGebruikerDeTaskNietMoetenKunnenAanmaken() {
    }


}
