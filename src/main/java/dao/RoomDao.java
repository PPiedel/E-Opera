package dao;

import model.Room;

import java.util.List;

/**
 * Interfejs implementujacy logike biznesowa zwiazana z BD wg wzorca projektowego DAO zwiazany  z encja Sala
 * @author PawełPiędel
 */

public interface RoomDao {

	/**
	 * 
	 * @param roomId id sali
	 */
	void addRoom(int roomId);

	/**
	 * 
	 * @param roomId id sali
	 */
	void deleteRoom(int roomId);

	/**
	 * 
	 * @param roomId id sali
	 */
	void updateRoom(int roomId);

	/**
	 *
	 * @return liste sali
	 */
	List<Room> getAllRooms();

}