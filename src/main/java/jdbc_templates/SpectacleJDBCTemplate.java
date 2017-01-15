package jdbc_templates;


import dao.SpectacleDao;
import mappers.SpectacleMapper;
import model.Spectacle;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Pawel on 2016-12-24.
 */
public class SpectacleJDBCTemplate implements SpectacleDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private String tableName = "Spektakle";


    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void createFromTitle(String title) {

    }

    @Override
    public Spectacle getSpectacle(Integer id) {
        return null;
    }

    @Override
    public List<Spectacle> listSpectacles() {
        String SQL = "SELECT * FROM "+tableName;
        List <Spectacle> spectacles = jdbcTemplateObject.query(SQL,
                new SpectacleMapper());
        return spectacles;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Integer id, String title) {

    }
}
