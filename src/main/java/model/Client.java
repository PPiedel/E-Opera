package model;

import com.sun.org.apache.xpath.internal.operations.Or;

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
	public void setAge(int age) {
		this.age = age;
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
}