package dao;

import java.util.List;

import domain.Boyaki;

public interface BoyakiDao {
	public List<Boyaki> findAll() throws Exception;
	public Boyaki findById(String id) throws Exception;
	public void insert(Boyaki boyaki) throws Exception;
	public void update(Boyaki boyaki) throws Exception;
	public void delete(Boyaki boyaki) throws Exception;

}
