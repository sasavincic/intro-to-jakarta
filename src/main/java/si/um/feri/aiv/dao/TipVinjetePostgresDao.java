package si.um.feri.aiv.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.aiv.entity.TipVinjete;

import java.util.List;
import java.util.logging.Logger;

@Stateless
@Local(TipVinjeteDao.class)
public class TipVinjetePostgresDao implements TipVinjeteDao{

    Logger log = Logger.getLogger(ProdajalecPostgresDao.class.toString());

    @PersistenceContext
    EntityManager em;

    @Override
    public List<TipVinjete> getAll() throws Exception{
        log.info("DAO: Returning All - Tip Vinjete");
        List<TipVinjete> tipVinjeteList = em.createQuery("select t from TipVinjete t").getResultList();
        return tipVinjeteList;
    }

    @Override
    public TipVinjete find(Integer id) throws Exception{
        log.info("DAO: Finding - TipVinjete: " + id);
        return em.find(TipVinjete.class, id);
    }

    @Override
    public void save(TipVinjete tipVinjete) throws Exception {
        log.info("DAO: Saving " + tipVinjete);
        em.merge(tipVinjete);
    }

    @Override
    public void delete(Integer id) throws Exception{
        log.info("DAO: Deleting " + find(id).getNaziv());
        em.remove(em.find(TipVinjete.class, id));
    }
}
