package mappers;

import model.Performance;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Pawel_Piedel on 2017-01-15.
 */
public class PerformanceMapper implements RowMapper {

    /**
     * Metoda mapujaca wiersz z BD na klase Spectacle
     * @param resultSet zbior wynikow
     * @param rowNum numer wiersza w BD
     * @return obiekt klasy Performance
     */
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Performance performance = new Performance();

        performance.setPerformanceId(resultSet.getInt("id_przedstawienia"));
        performance.setSpectacleId(resultSet.getInt("id_spektaklu"));
        performance.setHallId(resultSet.getInt("id_sali"));
        performance.setRepertoireIdl(resultSet.getInt("Id_repertuaru"));
        performance.setTicketsAvailableNumber(resultSet.getInt("liczba_dostepnych_biletow"));
        performance.setPurchasedTicketsNumber(resultSet.getInt("liczba_kupionych_biletow"));
        performance.setBookingsNumber(resultSet.getInt("liczba_rezerwacji"));
        performance.setDate(resultSet.getTimestamp("data"));

        return performance;
    }


}

