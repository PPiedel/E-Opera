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
import java.util.HashMap;
import java.util.List;

/**
 * Kontroler odpowiaddajcy za przechwytywanie żądań związanych z wyświetlaniem repertuaru i detali spektaklów
 * @author PawełPiędel
 */
@Controller
public class RepertoireController {
    private PerformanceJDBCTemplate performanceJDBCTemplate = (PerformanceJDBCTemplate) Application.context.getBean("performanceJDBCTemplate");
    private SpectacleJDBCTemplate spectacleJDBCTemplate = (SpectacleJDBCTemplate) Application.context.getBean("spectacleJDBCTemplate");
    private List<Performance> performancesFromDate;
    private List<Spectacle> spectacles;


    /**
     * Metoda przechwytująca ścieżkę "/repertuar'
     *
     * @return strone z repertuarem repertuar.html
     */

    @RequestMapping("/repertuar")
    public String repertoire(@RequestParam(value="date", required=false, defaultValue="2017/01/15") String dateString, Model model) {
        Date date = new Date(dateString);

        performancesFromDate = performanceJDBCTemplate.listPerformancesFromDate(date);

        spectacles = spectacleJDBCTemplate.listSpectacles();

        for (Spectacle spectacle : spectacles){
            spectacle.setDates(findDatesOfSpectacle(spectacle));
        }

        model.addAttribute("spectacles", spectacles);
        model.addAttribute("performances", performancesFromDate);

        return "repertuar";
    }

    @RequestMapping("/repertuar/podglad_sali")
    public String preview(@RequestParam(value = "performance_id", required = false,defaultValue = "1") Integer id, Model model){

        Performance performance = performanceJDBCTemplate.findById(id);
        model.addAttribute("performance",performance);
        return "podglad_sali";
    }


    private HashMap<Integer,Timestamp> findDatesOfSpectacle(Spectacle spectacle){
        HashMap<Integer,Timestamp> dates = new HashMap<>(5);

        for (Performance performance: performancesFromDate){
            if (performance.getSpectacleId().equals(spectacle.getSpectacleId())){
                dates.put(performance.getPerformanceId(),performance.getDate());
            }
        }
        return dates;
    }

}
