package si.um.feri.aiv.dao;

import si.um.feri.aiv.entity.TipVinjete;

import java.util.List;

public interface TipVinjeteDao {
    List<TipVinjete> getAll() throws Exception;
    TipVinjete find(Integer id) throws Exception;
    void save(TipVinjete tipVinjete) throws Exception;
    void delete(Integer id) throws Exception;

}
