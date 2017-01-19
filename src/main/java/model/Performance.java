package model;

/**
 * Created by Pawel_Piedel on 2017-01-15.
 */

import java.sql.Timestamp;

/**
 * Klasa implementujaca logike zwiazana z baza danych. Zwiazana z encja Przedstawienie
 * @author PawełPiędel
 */
public class Performance {


    /*id przedstawienia*/
    private Integer performanceId;

    /*id spektaklu*/
    private Integer spectacleId;

    /*id sali*/
    private Integer hallId;

    /*id repertuaru*/
    private Integer repertoireIdl;

    /*liczba dostepnych biletow*/
    private Integer ticketsAvailableNumber;

    /*liczba kupionych biletow*/
    private Integer purchasedTicketsNumber;

    /*liczba rezerwacji*/
    private Integer bookingsNumber;

    /*data*/
    private Timestamp date;

    /*cena*/
    private Integer price;

    /**
     * @return id przedstawienia
     */
    public Integer getPerformanceId() {
        return performanceId;
    }

    /**
     * Ustawia id spektaklu
     * @param  performanceId id przedstawienia
     */
    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
    }

    /**
     * @return id spektaklu
     */
    public Integer getSpectacleId() {
        return spectacleId;
    }

    /**
     * Ustawia id spektaklu
     * @param  spectacleId id spektaklu
     */
    public void setSpectacleId(Integer spectacleId) {
        this.spectacleId = spectacleId;
    }

    /**
     * @return id sali
     */
    public Integer getHallId() {
        return hallId;
    }

    /**
     * Ustawia id sali
     * @param  hallId id sali
     */
    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    /**
     * @return id repertuaru
     */
    public Integer getRepertoireIdl() {
        return repertoireIdl;
    }

    /**
     * Ustawia id repertuaru
     * @param  repertoireIdl id repertuaru
     */
    public void setRepertoireIdl(Integer repertoireIdl) {
        this.repertoireIdl = repertoireIdl;
    }

    /**
     * @return liczba dostepnych biletow
     */
    public Integer getTicketsAvailableNumber() {
        return ticketsAvailableNumber;
    }

    /**
     * Ustawia liczbe dostepnych biletow
     * @param  ticketsAvailableNumber liczba dostepnych biletow
     */
    public void setTicketsAvailableNumber(Integer ticketsAvailableNumber) {
        this.ticketsAvailableNumber = ticketsAvailableNumber;
    }

    /**
     * @return liczba kupionych biletow
     */
    public Integer getPurchasedTicketsNumber() {
        return purchasedTicketsNumber;
    }

    /**
     * Ustawia liczbe kupionych biletow
     * @param  purchasedTicketsNumber liczba kupionych biletow
     */
    public void setPurchasedTicketsNumber(Integer purchasedTicketsNumber) {
        this.purchasedTicketsNumber = purchasedTicketsNumber;
    }

    /**
     * @return liczba rezerwacji
     */
    public Integer getBookingsNumber() {
        return bookingsNumber;
    }

    /**
     * Ustawia liczbe rezerwacji
     * @param  bookingsNumber liczba rezerwacji
     */
    public void setBookingsNumber(Integer bookingsNumber) {
        this.bookingsNumber = bookingsNumber;
    }

    /**
     * @return data
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Ustawia date
     * @param  date data
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * @return cena
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Ustawia cene jednostkawa biletu na przedstawienie
     * @param  price cena
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return przedstawienie w formie lancucha znakow
     */
    @Override
    public String toString() {
        return "Performance{" +
                "performanceId=" + performanceId +
                ", spectacleId=" + spectacleId +
                ", hallId=" + hallId +
                ", repertoireIdl=" + repertoireIdl +
                ", ticketsAvailableNumber=" + ticketsAvailableNumber +
                ", purchasedTicketsNumber=" + purchasedTicketsNumber +
                ", bookingsNumber=" + bookingsNumber +
                ", date=" + date +
                '}';
    }
}