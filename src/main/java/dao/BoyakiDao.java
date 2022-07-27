package dao;

import java.util.List;

import domain.Boyaki;

public interface BoyakiDao {
	public List<Boyaki> findAll() throws Exception;
	public Boyaki findById(Integer id) throws Exception;
	public void insert(Boyaki boyaki) throws Exception;
	public void update(Boyaki boyaki) throws Exception;
	public void delete(Boyaki boyaki) throws Exception;
	public void addGoodsCount(Integer id, Integer goodsCount) throws Exception;
	public Integer getCount() throws Exception;

}
