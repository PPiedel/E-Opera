package jdbc_templates;

import dao.PerformanceDao;
import mappers.PerformanceMapper;

import model.Performance;
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
    private String tableName = "Przedstawienia";
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
     * @param id przedstawienia
     */
    @Override
    public Performance findById(Integer id) {
        String SQL = "SELECT * FROM " + tableName + " WHERE id_przedstawienia = "+id;
        List <Performance> performances = jdbcTemplateObject.query(SQL,new PerformanceMapper());
        return performances.get(0);
    }


    /**
     * Znajdz wszystkie tableName
     * @return lista wszystkich przedstawien
     */
    @Override
    public List<Performance> listAllPerformances() {
        String SQL = "SELECT * FROM "+ tableName;
        List <Performance> performances = jdbcTemplateObject.query(SQL, new PerformanceMapper());
        return performances;
    }

    /**
     * Znajdz wszystkie przedstawienia z konkretnej dany
     * @return lista wszystkich przedstawien z daty
     */
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
