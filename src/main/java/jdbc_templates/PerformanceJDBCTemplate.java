package jdbc_templates;

import dao.PerformanceDao;
import mappers.PerformanceMapper;
import mappers.SpectacleMapper;
import model.Performance;
import model.Spectacle;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Pawel on 2016-12-25.
 */

/**
 * Wzorzec dla interfejsu JDBC implementujacy komunikacje z baza danych
 * @author PawełPiędel
 */
public class PerformanceJDBCTemplate implements PerformanceDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private String przedstawienia = "Przedstawienia";
    private DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/DD");

    /**
     * Ustaw zrodlo danych
     * @param dataSource zrodlo danych
     */
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    /**
     * Znajdz przedstawienie
     * @param id id przedstawienia
     */
    @Override
    public Performance findById(Integer id) {
        return null;
    }


    /**
     * Znajdz wszystkie przedstawienia
     * @return lista wszystkich przedstawien
     */
    @Override
    public List<Performance> listAllPerformances() {
        String SQL = "SELECT * FROM "+ przedstawienia;
        List <Performance> performances = jdbcTemplateObject.query(SQL, new PerformanceMapper());
        return performances;
    }

    @Override
    public List<Performance> listPerformancesFromDate(Date date) {
        String perfDate = dateFormat.format(date);

        String SQL ="SELECT *\n" +
                "FROM Przedstawienia\n" +
                "WHERE TO_CHAR(data,'YYYY/MM/DD') = TO_CHAR('"+perfDate+"')";

        List <Performance> performances = jdbcTemplateObject.query(SQL, new PerformanceMapper());

        return performances;
    }

}
