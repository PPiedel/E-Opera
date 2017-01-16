package dao;

import model.Performance;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Interfejs implementujacy logike biznesowa zwiazana z BD wg wzorca projektowego DAO zwiazany  z encja Przedstawienie
 * @author PawełPiędel
 */

public interface PerformanceDao {

	/**
	 * Ustaw zrodlo danych
	 * @param dataSource zrodlo danych
	 */
	void setDataSource(DataSource dataSource);

	/**
	 * Znajdz wszystkie przedstawienia
	 * @return lista wszystkich przedstawien
	 */
	List<Performance> listAllPerformances();

	/**
	 * Znajdz wszystkie przedstawienia o danej dacie
	 * @return lista wszystkich przedstawien z danego dnia
	 */
	List<Performance> listPerformancesFromDate(Date date);


	/**
	 * Znajdz przedstawienie
	 * @param id id przedstawienia
	 */
	Performance findById(Integer id);

}