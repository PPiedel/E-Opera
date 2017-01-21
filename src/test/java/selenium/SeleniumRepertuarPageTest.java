package selenium;

import org.junit.Test;
import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * Created by Pawel_Piedel on 2017-01-21.
 */

@Config(
        browser = Browser.CHROME,
        url     = "localhost:8080/repertuar"
)public class SeleniumRepertuarPageTest extends Locomotive {


    @Test
    public void testRepertuarLinkExist() {
        validatePresent(RepertuarPage.NAV_LNK_REPERTUAR);
    }

    @Test
    public void testAktualnosciLinkExist(){
        validatePresent(RepertuarPage.NAV_LNK_AKTUALNOSCI);
    }

    @Test
    public void testOOperzeLinkExist(){
        validatePresent(RepertuarPage.NAV_LNK_O_OPERZE);
    }

    @Test
    public void testKontaktLinkExist(){
        validatePresent(RepertuarPage.NAV_LNK_KONTAKT);
    }

    @Test
    public void testMondayClicking(){
        click("#pon").validatePresent("#performances");
    }

    @Test
    public void testTuesdayClicking(){
        click("#wt").validatePresent("#performances");
    }

    @Test
    public void testWednesdayClicking(){
        click("#sr").validatePresent("#performances");
    }

    @Test
    public void testThursdayClicking(){
        click("#czw").validatePresent("#performances");
    }

    @Test
    public void testFridayClicking(){
        click("#pt").validatePresent("#performances");
    }

    @Test
    public void testSaturdayClicking(){
        click("#sb").validatePresent("#performances");
    }

    @Test
    public void testSundayClicking(){
        click("#nd").validatePresent("#performances");
    }

    @Test
    public void testRedirectToPodgladSaliByClickingPerformaceHours(){
        List<WebElement> hours = driver.findElements(By.className(".hour"));
        for (WebElement hour : hours){
            hour.click();
            validatePresent("#places");
        }
    }

}
