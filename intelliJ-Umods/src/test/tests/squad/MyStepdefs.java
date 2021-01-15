package tests;

import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;

public class MyStepdefs {
    @Gegeven("^de gebruiker is ingelogd$")
    public void deGebruikerIsIngelogd() {
    }

    @En("^bevindt zich op de homepagina$")
    public void bevindtZichOpDeHomepagina() {
    }

    @Als("^de gebruiker een squad aanmaakt met de naam 'School'$")
    public void deGebruikerEenSquadAanmaaktMetDeNaamSchool() {
    }

    @Dan("^zou de gebruiker 'squad succesfully created' moeten zien verschijnen$")
    public void zouDeGebruikerSquadSuccesfullyCreatedMoetenZienVerschijnen() {
    }

    @En("^wordt de pagina herladen met de nieuw gemaakte squad$")
    public void wordtDePaginaHerladenMetDeNieuwGemaakteSquad() {
    }

    @Als("^de gebruiker een squad aanmaakt met de naam 'Chiro'$")
    public void deGebruikerEenSquadAanmaaktMetDeNaamChiro() {
    }

    @En("^een 'nieuw lid' toevoegd$")
    public void eenNieuwLidToevoegd() {
    }

    @Als("^de gebruiker een squad aanmaakt met ongeldige gegevens$")
    public void deGebruikerEenSquadAanmaaktMetOngeldigeGegevens() {
    }

    @Dan("^zou de gebruiker de squad niet moeten kunnen aanmaken$")
    public void zouDeGebruikerDeSquadNietMoetenKunnenAanmaken() {
    }

    @Als("^de gebruiker de naam van een squad wijzigt naar 'studiegroep'$")
    public void deGebruikerDeNaamVanEenSquadWijzigtNaarStudiegroep() {
    }

    @Dan("^zou de gebruiker 'squad succesfully edited' moeten zien verschijnen$")
    public void zouDeGebruikerSquadSuccesfullyEditedMoetenZienVerschijnen() {
    }

    @En("^wordt de pagina herladen met de gewijzigde squad$")
    public void wordtDePaginaHerladenMetDeGewijzigdeSquad() {
    }

    @Als("^de gebruiker een squad verwijdert$")
    public void deGebruikerEenSquadVerwijdert() {
    }

    @Dan("^wordt de pagina herladen en is de verwijderde squad niet meer zichtbaar$")
    public void wordtDePaginaHerladenEnIsDeVerwijderdeSquadNietMeerZichtbaar() {
    }

    @Als("^de gebruiker een 'nieuw lid' toevoegd bij een squad$")
    public void deGebruikerEenNieuwLidToevoegdBijEenSquad() {
    }

    @Dan("^wordt de pagina herladen en en is het aantal leden bij de gewijzigde squad verhoogd met één$")
    public void wordtDePaginaHerladenEnEnIsHetAantalLedenBijDeGewijzigdeSquadVerhoogdMetÉén() {
    }

    @Als("^de gebruiker een 'nieuw lid' verwijdert bij een squad$")
    public void deGebruikerEenNieuwLidVerwijdertBijEenSquad() {
    }

    @Dan("^wordt de pagina herladen en en is het aantal leden bij de gewijzigde squad vermindert met één$")
    public void wordtDePaginaHerladenEnEnIsHetAantalLedenBijDeGewijzigdeSquadVermindertMetÉén() {
    }
}
