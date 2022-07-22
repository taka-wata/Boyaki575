package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
					+ " users.name AS boyaki_name," + " boyaki.user_id, is_secret"
					+ " FROM boyaki JOIN users ON boyaki.user_id = users.id";
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
	public Boyaki findById(String id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Boyaki boyaki) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

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
		return boyaki;
	}

}
