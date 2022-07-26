package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Boyaki;

public class BoyakiDaoImpl implements BoyakiDao {

	private DataSource ds;

	public BoyakiDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Boyaki> findAll() throws Exception {
		List<Boyaki> boyakiList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT" + " boyaki.id, boyaki.upper, boyaki.middle, boyaki.lower,"
					+ " users.name AS user_name," + " boyaki.user_id, is_secret, boyaki.date"
					+ " FROM boyaki JOIN users ON boyaki.user_id = users.id"
					+ " ORDER BY id DESC;";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				boyakiList.add(mapToBoyaki(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return boyakiList;
	}

	@Override
	public Boyaki findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Boyaki boyaki) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = "INSERT INTO boyaki" 
					+ " (upper, middle, lower, user_id, is_secret, date)"
					+ " VALUES"
					+ " (?, ?, ?, ?, ?, NOW())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, boyaki.getUpper());
			stmt.setString(2, boyaki.getMiddle());
			stmt.setString(3, boyaki.getLower());
			stmt.setObject(4, boyaki.getUserId(),Types.INTEGER);
			stmt.setObject(5, boyaki.getIsSecret(),Types.BOOLEAN);
			stmt.executeUpdate();
		} catch(Exception e){
			throw e;
		}

	}

	@Override
	public void update(Boyaki boyaki) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Boyaki boyaki) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private Boyaki mapToBoyaki(ResultSet rs) throws Exception{
		Boyaki boyaki = new Boyaki();
		boyaki.setId((Integer)rs.getObject("id"));
		boyaki.setUpper(rs.getString("upper"));
		boyaki.setMiddle(rs.getString("Middle"));
		boyaki.setLower(rs.getString("lower"));
		boyaki.setUserId((Integer)rs.getObject("user_id"));
		boyaki.setUserName(rs.getString("user_name"));
		boyaki.setIsSecret((Boolean)rs.getObject("is_secret"));
		boyaki.setDate(rs.getTimestamp("date"));
		return boyaki;
	}

}
