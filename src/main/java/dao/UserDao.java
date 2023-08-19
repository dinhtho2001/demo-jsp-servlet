package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

	private ConnectMysql connectMysql = new ConnectMysql();

	public List<User> findAll() {
		Connection connection;
		List<User> users = new ArrayList<User>();
		try {
			connection = connectMysql.Connect();
			String sql = "SELECT * FROM user";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				users.add(new User(resultSet.getLong("id"), resultSet.getString("username"),
						resultSet.getString("password")));
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User findByUsernameAndPassword(String username, String password) {
		Connection connection;
		User user = new User();
		try {
			connection = connectMysql.Connect();
			String sql = "SELECT * FROM user WHERE username = ? and password = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				user.setId(resultSet.getLong("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User findbyId(Long id) {
		Connection connection;
		User user = new User();
		try {
			connection = connectMysql.Connect();
			String sql = "SELECT * FROM user WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				user.setId(resultSet.getLong("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public Boolean update(User user) {
		Boolean result = false;
		try {
			Connection connection;
			connection = connectMysql.Connect();
			String sql = "UPDATE user SET username = ?, password = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			result = statement.executeUpdate() > 0;
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Boolean delete(Long id) {
		Boolean result = null;
		try {
			Connection connection;
			connection = connectMysql.Connect();
			String sql = "DELETE FROM user WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			result = statement.executeUpdate() > 0;
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Boolean save(User user) {
		Boolean result = null;
		try {
			Connection connection;
			connection = connectMysql.Connect();
			String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(1, user.getPassword());
			result = statement.executeUpdate() > 0;
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
