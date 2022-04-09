package si.um.feri.aiv.dao;

import si.um.feri.aiv.exceptions.VinjetaException;
import si.um.feri.aiv.entity.Nakup;
import si.um.feri.aiv.entity.Prodajalec;

import java.util.List;

public interface NakupDao {
	List<Nakup> getAll() throws Exception;
	Nakup find(Integer id) throws Exception;
	List<Nakup> findByRegistrskaOznakaVozila(String registrskaOznakaVozila) throws Exception;
	void save(Nakup nakup) throws Exception;
	void delete(Integer id) throws Exception;
	boolean checkForVinjeta(String registrskaOznakaVozila) throws Exception, VinjetaException;
	Integer getNumberOfNakupForProdajalec(Prodajalec prodajalec) throws Exception;
	
}