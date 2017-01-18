package model;

/**
 * Created by Pawel_Piedel on 2017-01-15.
 */

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Klasa implementujaca logike biznesowa. Reprezentuje encje Spektakl w aplikacji.
 * @author PawełPiędel
 */
public class Spectacle {

    /** Id spektaklu */
    private Integer spectacleId;

    /** Tytul spektaklu */
    private String title;

    /** Opis spektaklu */
    private String description;

    /** Czas trwania spektaklu */
    private Integer durationTime;

    /*Lista dat spektaklu*/
    private HashMap<Integer,Timestamp> dates;

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
     * @return tytul spektaklu
     */
    public String getTitle() {
        return title;
    }

    /**
     * Ustawia tytul spektaklu
     * @param  title tytul spektaklu
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return opis spektaklu
     */
    public String getDescription() {
        return description;
    }

    /**
     * Ustawia opis spektaklu
     * @param  description opis spektaklu
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return czas trwania spektaklu
     */
    public Integer getDurationTime() {
        return durationTime;
    }

    /**
     * Ustawia czas trwania spektaklu
     * @param  durationTime czas trwania spektaklu
     */
    public void setDurationTime(Integer durationTime) {
        this.durationTime = durationTime;
    }

    /**
     * @return dokladne daty wraz z godzinami spektaklu i id przedstawienia
     */
    public HashMap<Integer, Timestamp> getDates() {
        return dates;
    }
    /**
     * Ustawia dokladne daty wraz z godzinami spektaklu
     * @param  dates dokladne daty wraz z godzinami spektaklu i id przedstawienia
     */
    public void setDates(HashMap<Integer, Timestamp> dates) {
        this.dates = dates;
    }

    /**
     * Zwraca reprezentacje spektaklu w postaci lancucha znakow
     */
    @Override
    public String toString() {
        return "Spectacle{" +
                "spectacleId=" + spectacleId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", durationTime=" + durationTime +
                '}';
    }
}

