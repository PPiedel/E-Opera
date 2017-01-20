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

    @RequestMapping(value = {"/repertuar","/",""})
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

    /**
     * Metoda przechwytująca ścieżkę "/repertuar'
     *
     * @return strone z podgladem sali
     */
    @RequestMapping("/repertuar/podglad_sali")
    public String preview(@RequestParam(value = "performance_id", required = false,defaultValue = "1") Integer id, Model model){
        model.addAttribute("id",id);
        return "podglad_sali";
    }

    /*
     * Metoda przechwytująca ścieżkę "/spektakl'
     * @param spectacle_id id spektaklu
     * @return strone z detalami spektklu
     */
    @RequestMapping("/spektakl")
    public String spectacle(@RequestParam(value = "spectacle_id",required = false,defaultValue = "1") Integer id, Model model){
        Spectacle spectacle = spectacleJDBCTemplate.findById(id);

        model.addAttribute("spectacle",spectacle);
        return "spektakl";
    }


    /**
     * Metoda zwracajaca zbiór dat i id_przedstawien dla danego spektkalu
     * @param spectacle spektakl
     * @return zbiór par postaci {id_przedstawienia,data} dla konkretnego spektaklu
     */
    private HashMap<Integer,Timestamp> findDatesOfSpectacle(Spectacle spectacle){
        HashMap<Integer,Timestamp> dates = new HashMap<>(5);

        for (Performance performance: performancesFromDate){
            if (performance.getSpectacleId().equals(spectacle.getSpectacleId())){
                dates.put(performance.getPerformanceId(),performance.getDate());
            }
        }
        return dates;
    }

    private Spectacle findSPectacleWithId(Integer id){
        Spectacle spectacle = new Spectacle();
        for (Spectacle s: spectacles){
            if (s.getSpectacleId().equals(id)){
                return s;
            }
        }
        return spectacle;
    }



}
