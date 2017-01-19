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

    /**
     * @return id sali
     */
    public int getRoomId() {
        return roomId;
    }


    /**
     * Ustawia id sali
     * @param  roomId id sali
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    /**
     * @return nazwa sali
     */
    public String getName() {
        return name;
    }

    /**
     * Ustawia nazwe sali
     * @param  name nazwa sali
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return opis sali
     */
    public String getDescription() {
        return description;
    }

    /**
     * Ustawia opis sali
     * @param  description opis sali
     */
    public void setDescription(String description) {
        this.description = description;
    }
}