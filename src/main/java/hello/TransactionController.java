package hello;

import jdbc_templates.PerformanceJDBCTemplate;
import jdbc_templates.SpectacleJDBCTemplate;
import model.Performance;
import model.Spectacle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Pawel_Piedel on 2017-01-18.
 */
@Controller
public class TransactionController {
    private PerformanceJDBCTemplate performanceJDBCTemplate = (PerformanceJDBCTemplate) Application.context.getBean("performanceJDBCTemplate");
    private SpectacleJDBCTemplate spectacleJDBCTemplate = (SpectacleJDBCTemplate) Application.context.getBean("spectacleJDBCTemplate");

    @RequestMapping("/podsumowanie")
    public String preview(@RequestParam(value = "performance_id", required = false,defaultValue = "1")Integer performanceId,
                          @RequestParam(value = "places",required = false,defaultValue = "1") Integer places ,
                          Model model){
        Performance performance = performanceJDBCTemplate.findById(performanceId);

        Spectacle spectacle = spectacleJDBCTemplate.findById(performance.getSpectacleId());

        model.addAttribute("performance",performance);
        model.addAttribute("spectacle",spectacle);
        model.addAttribute("places",places);

        return "summary";
    }
}
