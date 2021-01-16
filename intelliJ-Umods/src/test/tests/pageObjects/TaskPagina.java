package tests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskPagina extends AbstractPage {

    public TaskPagina(WebDriver driver) {
        super(driver);
    }

    // methode op task form te opennen
    public void openTaskForm() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.id("btnAddTask")).click();
    }

    // methode om titel in te vullen
    public void setTitleField(String taskTitle) throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(By.id("taskTitle")).clear();
        driver.findElement(By.id("taskTitle")).sendKeys(taskTitle);
    }

    // methode om velden in te vullen
    public  void setSelect() throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(By.id("taskDesc")).sendKeys("Kluisje nr 3 - blauwe map");
        Thread.sleep(1000);
        driver.findElement(By.id("selectRepeat")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("selectOpt_None")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("selectAssign")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("selectOpt_membName")).click();
    }

    // methode om te submitten
    public void submit() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.id("btnSubmit")).click();
    }

    // methoden om de tast titel na te kijken
    public boolean taskCheck(String taskTitle) throws InterruptedException {

        Thread.sleep(3000);

        try {
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("tableTaskTitle_" + taskTitle))));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // methode om task aan te klikken
    public void clickTask(String taskTitle) throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.id("tableTaskTitle_" + taskTitle)).click();
    }

    // methode op edit form te opennen
    public void openEditTaskForm() throws InterruptedException {

        Thread.sleep(5000);
        driver.findElement(By.id("btnEdit")).click();
    }

    // methode om task te verwijren
    public void delTask() throws InterruptedException {

        Thread.sleep(5000);
        driver.findElement(By.id("btnDel")).click();
        Thread.sleep(3000);
    }

    // methode om ongeldige gegevens in te vullen
    public void setInvalidFields() throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(By.id("taskTitle")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("taskDesc")).sendKeys("K0987655432");
        Thread.sleep(1000);
    }

    // methode om na te gan of men kan submitten
    public boolean isClickable() throws InterruptedException {

        Thread.sleep(2000);

        // kijk na of submit knop klikbaar is
        try {
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnSubmit"))));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
