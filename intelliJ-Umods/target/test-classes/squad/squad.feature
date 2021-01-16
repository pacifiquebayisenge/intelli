    #language: nl
    Functionaliteit:  een squad beheren
    Als gebruiker wil ik een squad kunnen aanmaken, zodat ik er taken kan aanmaken, beheren of toewijzen voor de groepsleden of mezelf

      Achtergrond:
        Gegeven  de gebruiker is ingelogd
        En  bevindt zich op de homepagina


      Scenario: een squad aanmaken met de naam 'School'
        Als  de gebruiker een squad aanmaakt met de naam "School"
        Dan  zou de gebruiker "Squad succesfully created" moeten zien verschijnen
        En  wordt de pagina herladen met de nieuw gemaakte squad

      Scenario: een squad aanmaken met de naam 'Chiro' en verschillende leden
        Als  de gebruiker een nieuwe squad aanmaakt met de naam "Chiro"
        En  een nieuw lid toevoegd
        Dan  zou de gebruiker "Squad succesfully created" moeten zien verschijnen
        En  wordt de pagina herladen met de nieuw gemaakte squad
        En is het nieuw lid succesvol toegevoegd in de squad "Chiro"

      Scenario: een squad proberen aanmaken met ongeldige gegevens
        Als  de gebruiker een squad aanmaakt met ongeldige gegevens
        Dan  zou de gebruiker de squad niet moeten kunnen aanmaken

      Scenario: een naam van een squad wijzigen naar 'studiegroep'
        Als  de gebruiker de naam van een squad wijzigt naar "Studiegroep"
        Dan  zou de gebruiker "Squad succesfully edited" moeten zien verschijnen
        En  wordt de pagina herladen met de gewijzigde squad

      Scenario: een squad verwijderen
        Als  de gebruiker een squad verwijdert
        Dan  zou de gebruiker "Squad succesfully deleted" moeten zien verschijnen
        En  wordt de pagina herladen en is de verwijderde squad niet meer zichtbaar

      Scenario: een lid toevoegen in een squad
        Als  de gebruiker een 'nieuw lid' toevoegd bij een squad
        Dan  wordt de pagina herladen en en is het aantal leden bij de gewijzigde squad verhoogd met één


      Scenario: een lid verwijderen in een squad
        Als  de gebruiker een 'nieuw lid' verwijdert bij een squad
        Dan  zou de gebruiker "Member succesfully deleted" moeten zien verschijnen
        En  wordt de pagina herladen en en is het aantal leden bij de gewijzigde squad vermindert met één





