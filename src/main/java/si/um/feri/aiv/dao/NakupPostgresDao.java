package si.um.feri.aiv.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import si.um.feri.aiv.exceptions.VinjetaException;
import si.um.feri.aiv.observers.ObserverEventType;
import si.um.feri.aiv.entity.Nakup;
import si.um.feri.aiv.entity.Prodajalec;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Stateless
@Local(NakupDao.class)
public class NakupPostgresDao implements NakupDao {

    Logger log = Logger.getLogger(NakupPostgresDao.class.toString());

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Nakup> getAll() throws Exception {
        log.info("DAO: Returning All - Nakup");
        List<Nakup> nakupList = em.createQuery("select n from Nakup n").getResultList();
        return nakupList;
    }

    @Override
    public Nakup find(Integer id) throws Exception {
        log.info("DAO: Finding - Nakup " + id);
        return em.find(Nakup.class, id);
    }

    @Override
    public List<Nakup> findByRegistrskaOznakaVozila(String registrskaOznakaVozila) throws Exception{
        log.info("DAO: Finding - Nakup " + registrskaOznakaVozila);
        Query query = em.createQuery("select n from Nakup n where n.registrskaOznakaVozila=:r");
        query.setParameter("r", registrskaOznakaVozila);
        return query.getResultList();
    }

    @Override
    public void save(Nakup nakup) throws Exception {
        log.info("DAO: Saving " + nakup);
        if(nakup.getDatumNakupa() == null) {
            nakup.setDatumNakupa(LocalDate.now());
        }
        if (nakup.getDatumZacetkaVeljavnosti() == null) {
            nakup.setDatumZacetkaVeljavnosti(LocalDate.now());
        }
        em.merge(nakup);
    }

    @Override
    public void delete(Integer id) throws Exception {
        log.info("DAO: Deleting " + find(id).getRegistrskaOznakaVozila());
        em.remove(em.find(Nakup.class, id));
    }

    @Override
    public boolean checkForVinjeta(String registrskaOznakaVozila) throws Exception {
        log.info("DAO: Checking for valid Vinjeta: " + registrskaOznakaVozila);
        List<Nakup> nakupList = findByRegistrskaOznakaVozila(registrskaOznakaVozila);

        boolean valid = false;
        if(!nakupList.isEmpty()) {
            for(Nakup nakup : nakupList) {
                valid = nakup.checkIfValid();
                if(valid) return valid;
            }
            throw new VinjetaException("Vozilo z registrsko oznako vozila: " + registrskaOznakaVozila + " nima veljavnih vinjet!");
        } else {
            Nakup tmpNakup = new Nakup();
            tmpNakup.setRegistrskaOznakaVozila(registrskaOznakaVozila);
            tmpNakup.notifyAll(ObserverEventType.DOES_NOT_EXIST);
            throw new VinjetaException("Za vozilo z registrsko oznako vozila: " + registrskaOznakaVozila + " ni bilo kupljenih vinjet.");
        }
    }

    @Override
    public Integer getNumberOfNakupForProdajalec(Prodajalec prodajalec) throws Exception {
        List<Nakup> nakupList = getAll();
        Integer numberOfNakupForProdajalec = 0;
        for(Nakup nakup : nakupList) {
            if (nakup.getProdajalec().getId() == prodajalec.getId()) {
                numberOfNakupForProdajalec++;
            }
        }
        return numberOfNakupForProdajalec;
    }
}
