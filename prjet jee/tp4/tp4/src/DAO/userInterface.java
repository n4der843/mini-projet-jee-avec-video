package DAO;
import java.util.List;
import Beans.user;

public interface userInterface {
	public List<user> getAll();
	public void addUser(user user);
	public int findUser(String name);
	public void deleteUser(int id);
	public int findUserByLetter(String name);
	public void updateUser(user user);
	public user findUserById(int id);
	public int CountUser();
}
