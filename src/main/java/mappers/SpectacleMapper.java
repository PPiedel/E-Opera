package mappers;

/**
 * Created by Pawel_Piedel on 2017-01-15.
 */

import model.Spectacle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Klasa implementujaca logike zwiazana z baza danych, pokazujaca jak mapowac wiersze BD na obiekty.
 * @author PawełPiędel
 */
public class SpectacleMapper implements RowMapper<Spectacle> {

    /**
     * Metoda mapujaca wiersz z BD na klase Spectacle
     * @param resultSet zbior wynikow
     * @param rownNum numer wiersza w BD
     * @return obiekt klasy Spectacle
     */

    @Override
    public Spectacle mapRow(ResultSet resultSet, int rownNum) throws SQLException {
        Spectacle spectacle = new Spectacle();
        spectacle.setSpectacleId(resultSet.getInt("id_spektaklu"));
        spectacle.setTitle(resultSet.getString("nazwa"));
        spectacle.setDescription(resultSet.getString("opis"));
        spectacle.setDurationTime(resultSet.getInt("czas_trwania"));
        return spectacle;
    }
}
