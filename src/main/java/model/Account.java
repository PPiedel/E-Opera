package model;

/**
 * entity class
 */
public class Account {

	private int accountId;
	private String login;
	private String password;

	public String getLogin() {
		return this.login;
	}

	/**
	 * 
	 * @param login login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

    /**
     *
     * @return id klienta
     */
	public int getAccountId() {
		return accountId;
	}

    /**
     *
     * @return haslo enta
     */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param password haslo
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}