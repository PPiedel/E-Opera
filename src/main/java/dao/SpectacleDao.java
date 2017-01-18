package dao;

import model.Spectacle;

import javax.sql.DataSource;
import java.util.List;

/**
 * Interfejs implementujacy logike biznesowa zwiazana z BD wg wzorca projektowego DAO zwiazany z encja Spektakl
 * @author PawełPiędel
 */

public interface SpectacleDao {

	/**
	 * Ustaw zrodlo danych
	 * @param ds zrodlo danych
	 */
	void setDataSource(DataSource ds);


	/**
	 * Zwraca spektakl
	 * @param id id spektaklu
	 */
	Spectacle findById(Integer id);

	/**
	 * Zwraca liste spektaklow
	 * @return lista spektaklow
	 */
	List<Spectacle> listSpectacles();

	/**
	 * Usun spektakl znajdac jego id
	 * @param id id spektaklu
	 */
	void delete(Integer id);

	/**
	 * Aktualizuje spektakl
	 * @param id id spektaklu
	 * @param title tytul sppektaklu
	 */
	void update(Integer id, String title);

}