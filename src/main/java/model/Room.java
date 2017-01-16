package model;

/**
 * Klasa implementujaca logike zwiazana z baza danych. Zwiazana z encja Sala
 * @author PawełPiędel
 */
public class Room {

    /*id sali*/
	private int roomId;

	/*nazwa sali*/
	private String name;

	/*opis sali*/
	private String description;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}