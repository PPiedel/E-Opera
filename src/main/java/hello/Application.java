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
    }

}
