package dao;

import model.Room;

import java.util.List;

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

	List<Room> getAllRooms();

}