package hello;
/**
 * Created by Pawel_Piedel on 2017-01-15.
 */

import jdbc_templates.PerformanceJDBCTemplate;
import jdbc_templates.SpectacleJDBCTemplate;
import model.Performance;
import model.Spectacle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Kontroler odpowiaddajcy za przechwytywanie żądań związanych z wyświetlaniem repertuaru i detali spektaklów
 * @author PawełPiędel
 */
@Controller
public class RepertoireController {
    private PerformanceJDBCTemplate performanceJDBCTemplate;
    private SpectacleJDBCTemplate spectacleJDBCTemplate;
    private List<Performance> performancesFromDate;
    private List<Spectacle> spectacles;


    /**
     * Metoda przechwytująca ścieżkę "/repertuar'
     *
     * @return strone z repertuarem repertuar.html
     */

    @RequestMapping("/repertuar")
    public String greeting(@RequestParam(value="date", required=false, defaultValue="2017/01/15") String dateString, Model model) {
        Date date = new Date(dateString);
        performanceJDBCTemplate = (PerformanceJDBCTemplate) Application.context.getBean("performanceJDBCTemplate");
        performancesFromDate = performanceJDBCTemplate.listPerformancesFromDate(date);

        spectacleJDBCTemplate = (SpectacleJDBCTemplate) Application.context.getBean("spectacleJDBCTemplate");
        spectacles = spectacleJDBCTemplate.listSpectacles();

        for (Spectacle spectacle : spectacles){
            spectacle.setDates(findDatesOfSpectacle(spectacle));
        }

        model.addAttribute("spectacles", spectacles);

        return "repertuar";
    }

    private List<Timestamp> findDatesOfSpectacle(Spectacle spectacle){
        List<Timestamp> dates = new ArrayList<>(10);

        for (Performance performance: performancesFromDate){
            if (performance.getSpectacleId().equals(spectacle.getSpectacleId())){
                dates.add(performance.getDate());
            }
        }
        return dates;
    }

}
