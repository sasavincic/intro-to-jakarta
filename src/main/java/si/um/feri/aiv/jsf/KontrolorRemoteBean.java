package si.um.feri.aiv.jsf;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import si.um.feri.aiv.dao.KontrolorRemote;
import si.um.feri.aiv.dao.NakupDao;
import si.um.feri.aiv.exceptions.VinjetaException;

import java.io.Serializable;
import java.sql.SQLException;

@Stateless
public class KontrolorRemoteBean implements Serializable, KontrolorRemote {

    @EJB
    NakupDao nakupDao;

    @Override
    public String checkForVinjeta(String registrskaOznakaVozila) throws Exception, VinjetaException {
        String message = "";
        try {
            nakupDao.checkForVinjeta(registrskaOznakaVozila);
            message = "Vinjeta za vozilo: " + registrskaOznakaVozila + " je veljavna.";
        } catch (VinjetaException e) {
            message = e.getMessage();
        } catch (SQLException e) {
            e.printStackTrace();
            message = "Napaka pri SQL poizvedbi!";
        }
        return message;
    }
}
