package model;

import java.util.Date;
import java.util.List;

public class Booking {
	private int bookingId;
	private Date date;
	private Date payDate;
	List<Ticket> tickets;

	public int getBookingId() {
		return this.bookingId;
	}

	/**
	 * 
	 * @param bookingId id rezerwacji
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date data rezerwacji
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getPayDate() {
		return this.payDate;
	}

}