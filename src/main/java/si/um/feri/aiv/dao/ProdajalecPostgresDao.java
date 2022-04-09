package si.um.feri.aiv.dao;

import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.aiv.entity.Prodajalec;

import java.util.List;
import java.util.logging.Logger;

@Stateless
@Local(ProdajalecDao.class)
public class ProdajalecPostgresDao implements ProdajalecDao{

    Logger log = Logger.getLogger(ProdajalecPostgresDao.class.toString());

    @PersistenceContext
    EntityManager em;

    @EJB
    NakupDao nakupDao;

    @Override
    public List<Prodajalec> getAll() throws Exception{
        log.info("DAO: Returning All - Prodajalec");
        List<Prodajalec> prodajalecList = em.createQuery("select p from Prodajalec p").getResultList();
        for (Prodajalec prodajalec : prodajalecList) {
            prodajalec.setSteviloProdanihVinjet(nakupDao.getNumberOfNakupForProdajalec(prodajalec));
            em.merge(prodajalec);
        }
        return prodajalecList;
    }

    @Override
    public Prodajalec find(Integer id) throws Exception{
        log.info("DAO: Finding - Prodajalec " + id);
        return em.find(Prodajalec.class, id);
    }

    @Override
    public void save(Prodajalec prodajalec) throws Exception {
        log.info("DAO: Saving " + prodajalec);
        em.merge(prodajalec);
    }

    @Override
    public void delete(Integer id) throws Exception{
        log.info("DAO: Deleting " + find(id).getNaziv());
        em.remove(em.find(Prodajalec.class, id));
    }
}
