package tests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagina extends AbstractPage {

    public LoginPagina(WebDriver driver) {
        super(driver);
    }

    // methode om zich in te loggen
    public HomePagina login() {

        // velden invullen
        driver.findElement(By.id("emailInput")).sendKeys("hpacifique@live.be");
        driver.findElement(By.id("pwdInput")).sendKeys("odisee1");

        // submit knop klik
        driver.findElement(By.id("loginSub")).click();

        return new HomePagina(driver);

    }

}
