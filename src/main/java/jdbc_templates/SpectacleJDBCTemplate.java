package jdbc_templates;


import dao.SpectacleDao;
import mappers.SpectacleMapper;
import model.Spectacle;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Wzorzec dla interfejsu JDBC implementujacy komunikacje z baza danych
 * @author PawełPiędel
 *
 */
public class SpectacleJDBCTemplate implements SpectacleDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private String tableName = "Spektakle";


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
     * Zwraca spektakl
     * @param id id spektaklu
     */
    @Override
    public Spectacle findById(Integer id) {
        String SQL = "SELECT * FROM " + tableName + " WHERE id_spektaklu = ?";
        Spectacle spectacle = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new SpectacleMapper());
        return spectacle;
    }

    /**
     * Zwraca liste spektaklow
     * @return lista spektaklow
     */
    @Override
    public List<Spectacle> listSpectacles() {
        String SQL = "SELECT * FROM "+tableName;
        List <Spectacle> spectacles = jdbcTemplateObject.query(SQL,
                new SpectacleMapper());
        return spectacles;
    }


    /**
     * Usun spektakl znajdac jego id
     * @param id id spektaklu
     */
    @Override
    public void delete(Integer id) {

    }

    /**
     * Aktualizuje spektakl
     * @param id id spektaklu
     * @param title tytul sppektaklu
     */
    @Override
    public void update(Integer id, String title) {

    }
}
