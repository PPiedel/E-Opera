package jdbc_templates;

import dao.PerformanceDao;
import mappers.PerformanceMapper;
import model.Performance;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Pawel on 2016-12-25.
 */
public class PerformanceJDBCTemplate implements PerformanceDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private String tableName = "Przedstawienia";

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    @Override
    public Performance findById(Integer id) {
        return null;
    }

    @Override
    public List<Performance> listPerformances() {
        String SQL = "SELECT * FROM "+tableName;
        List <Performance> performances = jdbcTemplateObject.query(SQL, new PerformanceMapper());
        return performances;
    }

}
