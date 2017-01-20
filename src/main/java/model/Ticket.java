package model;

import java.util.Date;

public class Ticket {

	private int ticketId;
	private int price;
	private Date makeDate;

	public int getTicketId() {
		return this.ticketId;
	}

	/**
	 * 
	 * @param ticketId id biletu
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price cena biletu
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	public Date getMakeDate() {
		return this.makeDate;
	}

	/**
	 * 
	 * @param makeDate data utworzenia
	 */
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

}