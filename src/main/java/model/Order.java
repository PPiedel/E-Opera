package model;

import java.util.Date;
import java.util.List;

public class Order {

	private int ticketsNumber;
	private Date date;
	private Date payDate;
	List<Ticket> tickets;

	public int getTicketsNumber() {
		return this.ticketsNumber;
	}

	/**
	 * 
	 * @param ticketsNumber liczba biletow
	 */
	public void setTicketsNumber(int ticketsNumber) {
		this.ticketsNumber = ticketsNumber;
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date	 data zlozenia zamowienia
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getPayDate() {
		return this.payDate;
	}

	/**
	 * 
	 * @param payDate data oplacenia zamowienia
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

}