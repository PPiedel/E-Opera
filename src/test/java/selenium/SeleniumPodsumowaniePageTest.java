package selenium;

/**
 * Created by Pawel_Piedel on 2017-01-22.
 */

import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Config(
        browser = Browser.CHROME,
        url     = "http://localhost:8080/podsumowanie")
public class SeleniumPodsumowaniePageTest extends Locomotive {

    @Test
    public void testPayButton(){
        click("#payButton")
                .validatePresent(".payment-buttons");
    }

    @Test
    public void testCancelButton(){
        click("#cancelButton");
        assert isAlertPresent();
    }

    public boolean isAlertPresent(){
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver, 0 /*timeout in seconds*/);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }

}
