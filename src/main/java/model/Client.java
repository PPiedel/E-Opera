package model;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

/**
 * entity class
 */
public class Client {
	private int clientId;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private int age;
	private int pesel;
	private Account account;
	private List<Order> orders;
	private List<Booking> bookings;
	private int maxOrders = 4;
	private int maxBookings = 10;


	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name imie klienta
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	/**
	 * 
	 * @param surname nazwisko klienta
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	/**
	 * 
	 * @param phone telefon
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return this.age;
	}

	/**
	 * 
	 * @param age wiek
	 */
	public boolean setAge(int age) {
		boolean setted = false;
		if (age>=18){
			this.age = age;
			setted = true;
		}
		return setted;
	}


	public int getPesel() {
		return this.pesel;
	}

	/**
	 * 
	 * @param pesel numer pesel
	 */
	public void setPesel(int pesel) {
		this.pesel = pesel;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean addOrder(Order order){
		boolean added = false;
		if (orders ==null){
			orders = new ArrayList<>(2);
			orders.add(order);
			added = true;
		}
		else {
			if (orders.size()<=maxOrders){
				orders.add(order);
				added = true;
			}
		}

		return added;
	}

	public boolean addBooking(Booking booking){
		boolean added = false;
		if (bookings == null){
			bookings = new ArrayList<>(2);
			bookings.add(booking);
			added = true;
		}
		else {
			if (bookings.size()<=maxBookings){
				bookings.add(booking);
				added = true;
			}
		}
		return added;
	}


}