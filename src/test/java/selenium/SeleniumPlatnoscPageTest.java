package selenium;

import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

/**
 * Created by Pawel_Piedel on 2017-01-22.
 */

@Config(
        browser = Browser.CHROME,
        url     = "http://localhost:8080/podsumowanie/platnosc")
public class SeleniumPlatnoscPageTest extends Locomotive {

    @Test
    public void testOnlinePaymentButton(){
        click("#onlinePayment")
                .validatePresent("#onlinePaymentButtons");
    }

    @Test
    public void testOnTheSpotPaymentButton(){
        click("#onTheSpotPayment");
        validateAttribute("#onlinePaymentButtons","style","display: none; margin-top: 5px;");

    }

    @Test
    public void testCancelButton(){
        click("#cancel_payment");
        assert isAlertPresent();
    }

    @Test
    public void testNextButton(){
        click("#payment_next")
                .validatePresent("#header")
                .validatePresent("#message");
    }

    private boolean isAlertPresent(){
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
