package hello;
/**
 * Created by Pawel_Piedel on 2017-01-15.
 */

import jdbc_templates.SpectacleJDBCTemplate;
import model.Performance;
import model.Spectacle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler odpowiaddajcy za przechwytywanie żądań związanych z wyświetlaniem repertuaru i detali spektaklów
 * @author PawełPiędel
 */
@Controller
public class RepertoireController {
    private SpectacleJDBCTemplate spectacleJDBCTemplate;

    /**
     * Metoda przechwytująca ścieżkę "/home'
     *
     * @return strone główną repertuar.html
     */
    @RequestMapping("/repertuar")
    public ModelAndView showSpectacles() {


        spectacleJDBCTemplate = (SpectacleJDBCTemplate) Application.context.getBean("spectacleJDBCTemplate");


        List<Spectacle> spectacles = spectacleJDBCTemplate.listSpectacles();


        ModelAndView model = new ModelAndView("repertuar");
        model.addObject("spectacles", spectacles);

        return model;

    }

}
