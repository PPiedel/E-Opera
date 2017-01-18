package hello;
/**
 * Created by Pawel_Piedel on 2017-01-15.
 */

import jdbc_templates.PerformanceJDBCTemplate;
import jdbc_templates.SpectacleJDBCTemplate;
import model.Performance;
import model.Spectacle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Główna klasa aplikacji
 * @author PawełPiędel
 */

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {
    static ApplicationContext context ;
    private static DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/DD");

    /**
     * @param args argumenty
     */
    public static void main(String[] args) throws ParseException {
        context = new ClassPathXmlApplicationContext("beans.xml");
        SpringApplication.run(Application.class, args);

        //Date date = new Date("2017/01/15");
        //String date1 = dateFormat.format(date);
        //System.out.println(date1);
        //List<Performance> performances = performanceJDBCTemplate.listPerformancesFromDate(date);

        //SpectacleJDBCTemplate spectacleJDBCTemplate = (SpectacleJDBCTemplate) context.getBean("spectacleJDBCTemplate");
        //List<Spectacle> spectacles = spectacleJDBCTemplate.listSpectacles();
        //for (Spectacle spectacle : spectacles){
        //    System.out.println(spectacle.toString());
        //}*/
        /*Date date = new Date("2017/01/15");
        System.out.println(date);

        PerformanceJDBCTemplate performanceJDBCTemplate  = (PerformanceJDBCTemplate) Application.context.getBean("performanceJDBCTemplate");
        List<Performance> performancesFromDate = performanceJDBCTemplate.listPerformancesFromDate(date);

        SpectacleJDBCTemplate spectacleJDBCTemplate = (SpectacleJDBCTemplate) Application.context.getBean("spectacleJDBCTemplate");
        List<Spectacle> spectacles = spectacleJDBCTemplate.listSpectacles();

        for (Spectacle spectacle : spectacles){
            spectacle.setDates(findDatesOfSpectacle(spectacle,performancesFromDate));
        }

        for (Performance p : performancesFromDate){
            System.out.println(p.toString());
        }

        for (Spectacle spectacle: spectacles){
            System.out.println(spectacle.toString());
        }*/

       /* SpectacleJDBCTemplate spectacleJDBCTemplate = (SpectacleJDBCTemplate) Application.context.getBean("spectacleJDBCTemplate");
        Spectacle spectacle = spectacleJDBCTemplate.findById(1);
        System.out.println(spectacle.toString());

        PerformanceJDBCTemplate performanceJDBCTemplate = (PerformanceJDBCTemplate) Application.context.getBean("performanceJDBCTemplate");
        Performance performance = performanceJDBCTemplate.findById(1);
        System.out.println(performance.toString());*/


    }

    private static List<Timestamp> findDatesOfSpectacle(Spectacle spectacle, List<Performance> performancesFromDate){
        List<Timestamp> dates = new ArrayList<>(10);

        for (Performance performance: performancesFromDate){
            if (performance.getSpectacleId().equals(spectacle.getSpectacleId())){
                dates.add(performance.getDate());
            }
        }
        return dates;
    }

}
