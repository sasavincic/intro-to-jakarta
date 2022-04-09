package si.um.feri.aiv.dao;

import si.um.feri.aiv.entity.Prodajalec;

import java.util.List;

public interface ProdajalecDao {
    List<Prodajalec> getAll() throws Exception;
    Prodajalec find(Integer id) throws Exception;
    void save(Prodajalec prodajalec) throws Exception;
    void delete(Integer id) throws Exception;
}
