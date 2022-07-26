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
					+ " users.name AS user_name," + " boyaki.user_id, is_secret, boyaki.date, boyaki.goods_count"
					+ " FROM boyaki JOIN users ON boyaki.user_id = users.id" + " ORDER BY id DESC;";

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
		Boyaki boyaki = new Boyaki();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT" + " boyaki.id, boyaki.upper, boyaki.middle, boyaki.lower,"
					+ " users.name AS user_name," + " boyaki.user_id, is_secret, boyaki.date, boyaki.goods_count"
					+ " FROM boyaki JOIN users ON boyaki.user_id = users.id" + " WHERE boyaki.id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();

			if (rs.next() != false) {
				boyaki = mapToBoyaki(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return boyaki;
	}

	@Override
	public void insert(Boyaki boyaki) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO boyaki" + " (upper, middle, lower, user_id, is_secret, date, goods_count)"
					+ " VALUES" + " (?, ?, ?, ?, ?, NOW()),0 ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, boyaki.getUpper());
			stmt.setString(2, boyaki.getMiddle());
			stmt.setString(3, boyaki.getLower());
			stmt.setObject(4, boyaki.getUserId(), Types.INTEGER);
			stmt.setObject(5, boyaki.getIsSecret(), Types.BOOLEAN);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Boyaki boyaki) throws Exception {

	}

	@Override
	public void delete(Boyaki boyaki) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void addGoodsCount(Integer id, Integer goodsCount) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE boyaki" + " SET goods_count=?" + " WHERE id=?";
			// いいね！を＋１
			goodsCount++;
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, goodsCount, Types.INTEGER);
			stmt.setObject(2, id, Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	private Boyaki mapToBoyaki(ResultSet rs) throws Exception {
		Boyaki boyaki = new Boyaki();
		boyaki.setId((Integer) rs.getObject("id"));
		boyaki.setUpper(rs.getString("upper"));
		boyaki.setMiddle(rs.getString("Middle"));
		boyaki.setLower(rs.getString("lower"));
		boyaki.setUserId((Integer) rs.getObject("user_id"));
		boyaki.setUserName(rs.getString("user_name"));
		boyaki.setIsSecret((Boolean) rs.getObject("is_secret"));
		boyaki.setDate(rs.getTimestamp("date"));
		boyaki.setGoodsCount((Integer) rs.getObject("goods_count"));
		return boyaki;
	}

}
