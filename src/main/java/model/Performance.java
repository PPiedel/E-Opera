package model;

/**
 * Created by Pawel_Piedel on 2017-01-15.
 */

import java.sql.Timestamp;

/**
 * entity class
 */
public class Performance {

    private Integer performanceId;
    private Integer spectacleId;
    private Integer hallId;
    private Integer repertoireIdl;
    private Integer ticketsAvailableNumber;
    private Integer purchasedTicketsNumber;
    private Integer bookingsNumber;
    private Timestamp date;

    public Integer getRepertoireIdl() {
        return repertoireIdl;
    }

    public void setRepertoireIdl(Integer repertoireIdl) {
        this.repertoireIdl = repertoireIdl;
    }

    public Integer getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
    }

    public Integer getSpectacleId() {
        return spectacleId;
    }

    public void setSpectacleId(Integer spectacleId) {
        this.spectacleId = spectacleId;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public Integer getTicketsAvailableNumber() {
        return ticketsAvailableNumber;
    }

    public void setTicketsAvailableNumber(Integer ticketsAvailableNumber) {
        this.ticketsAvailableNumber = ticketsAvailableNumber;
    }

    public Integer getPurchasedTicketsNumber() {
        return purchasedTicketsNumber;
    }

    public void setPurchasedTicketsNumber(Integer purchasedTicketsNumber) {
        this.purchasedTicketsNumber = purchasedTicketsNumber;
    }

    public Integer getBookingsNumber() {
        return bookingsNumber;
    }

    public void setBookingsNumber(Integer bookingsNumber) {
        this.bookingsNumber = bookingsNumber;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

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