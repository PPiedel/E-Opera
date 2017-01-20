package dao;

public interface AccountDao {

	/**
	 * 
	 * @param clientId id klienta
	 * @param login	 login
	 * @param password haslo
	 */
	void create(Integer clientId, String login, String password);

	/**
	 * 
	 * @param login login
	 * @param password	 haslo
	 */
	void identify(String login, String password);

	/**
	 * 
	 * @param clientId id klienta
	 */
	void remove(int clientId);

}