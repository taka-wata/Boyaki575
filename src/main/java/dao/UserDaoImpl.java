package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.User;

public class UserDaoImpl implements UserDao {

	private DataSource ds;

	public UserDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public User findById(Integer id) throws Exception {
		User user = new User();
		try(Connection con =ds.getConnection()){
			String sql = "SELECT * FROM users WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if(rs.next() != false) {
				user = mapToUser(rs);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return user;
	}

	@Override
	public void insert(User user) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = "INSERT INTO users"
					+ " (login_id, login_pass, name)"
					+ " VALUES"
					+ " (?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getLoginId());
			stmt.setString(2, user.getLoginPass());
			stmt.setString(3, user.getName());
			stmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		}

	}

	@Override
	public void update(User user) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(User user) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public User findByLoginIdAndLoginPass(String loginId, String loginPass) throws Exception {
		User user = null;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM users WHERE login_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(loginPass, rs.getString("login_pass")))
					user = mapToUser(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return user;
	}

	@Override
	public Integer findId(String loginId) throws Exception {
		Integer id = null;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT id FROM users" + " WHERE login_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = (Integer) rs.getObject("id");
			}
		} catch (Exception e) {
			throw e;
		}
		return id;

	}

	private User mapToUser(ResultSet rs) throws Exception {
		User user = new User();
		user.setId((Integer) rs.getObject("id"));
		user.setLoginId(rs.getString("login_id"));
		user.setLoginPass(rs.getString("login_pass"));
		user.setName(rs.getString("name"));
		return user;
	}

}
