    # language: nl
    Functionaliteit:  een overview visualiseren
    Als gebruiker wil ik in de kalender mijn taken kunnen bekijken, zodat ik al mijn taken op een gestructureerde manier kan bezichtigen en deze planning eenvoudig kan opvolgen.

      Achtergrond:
        Gegeven  de gebruiker is ingelogd
        En  bevindt zich op de homepagina

      Scenario: Geen kalender kunnen bekijken
        Gegeven de gebruiker is niet lid van een squad
        Als de gebruiker de kalender wil visualiseren
        Dan  wordt de gebruiker terug naar de home pagina herleid
        En zou de gebruiker "Cannot open calendar while not being in a squad" moeten zien opkomen

      Scenario: Kalender zonder taken kunnen bekijken
        Gegeven de gebruiker is lid van een squad
        En de gebruiker heeft geen toegewezen taken
        Als  de gebruiker de kalender wil visualiseren
        Dan wordt de gebruiker doorverwezen naar de kalender pagina
        En ziet de gebruiker geen taken op de kalender


      Scenario: Kalender met taken kunnen bekijken
        Gegeven de gebruiker is lid van een squad met taken
        En de gebruiker heeft toegewezen taken
        Als de gebruiker de kalender wil visualiseren
        Dan wordt de gebruiker doorverwezen naar de kalender pagina
        En ziet de gebruiker taken op de kalender
