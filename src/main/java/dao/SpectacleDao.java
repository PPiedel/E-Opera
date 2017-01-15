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
	 * 
	 * @param ds zrodlo danych
	 */
	void setDataSource(DataSource ds);

	/**
	 * 
	 * @param title tytul sppektaklu
	 */
	void createFromTitle(String title);

	/**
	 * 
	 * @param id id spektaklu
	 */
	Spectacle getSpectacle(Integer id);

	/**
	 *
	 * @return lista spektaklow
	 */
	List<Spectacle> listSpectacles();

	/**
	 * 
	 * @param id id spektaklu
	 */
	void delete(Integer id);

	/**
	 * 
	 * @param id id spektaklu
	 * @param title tytul sppektaklu
	 */
	void update(Integer id, String title);

}