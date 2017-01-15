package dao;

import model.Performance;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

/**
 * Interfejs implementujacy logike biznesowa zwiazana z BD wg wzorca projektowego DAO zwiazany  z encja Przedstawienie
 * @author PawełPiędel
 */

public interface PerformanceDao {

	/**
	 *
	 * @param dataSource zrodlo danych
	 */
	void setDataSource(DataSource dataSource);

	/**
	 *
	 * @return lista wszystkich przedstawien
	 */
	List<Performance> listPerformances();


	/**
	 * 
	 * @param id id przedstawienia
	 */
	Performance findById(Integer id);

}