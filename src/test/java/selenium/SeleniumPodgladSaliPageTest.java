package selenium;

import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Pawel_Piedel on 2017-01-21.
 */

@Config(
        browser = Browser.CHROME,
        url     = "http://localhost:8080/repertuar/podglad_sali"
)
public class SeleniumPodgladSaliPageTest extends Locomotive {

    @Test
    public void testPlacesMarking(){
        List<WebElement> places = driver.findElements(By.tagName("td"));
        for (WebElement place: places) {
            place.click();
            validateAttribute(place.getTagName(),"class","active");
        }
    }

    @Test
    public void testBackButtonClic(){
        click("#previousButton")
                .validatePresent("#performances");
    }
}
