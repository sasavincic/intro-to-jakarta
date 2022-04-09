package si.um.feri.aiv.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.NakupDao;
import si.um.feri.aiv.exceptions.VinjetaException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Logger;

@Named("kontrolor")
@SessionScoped
public class KontrolorBean implements Serializable {
    private static final long serialVersionUID = -8979220536758073133L;

    Logger log = Logger.getLogger(KontrolorBean.class.toString());

    private String registrskaOznakaVozila;
    private String message;

    @EJB
    NakupDao nakupDao;

    public void checkForVinjeta() throws Exception {
        try {
            nakupDao.checkForVinjeta(registrskaOznakaVozila);
            message = "Vinjeta za vozilo: " + registrskaOznakaVozila + " je veljavna.";
        } catch (VinjetaException e) {
            message = e.getMessage();
        } catch (SQLException e) {
            e.printStackTrace();
            message = "Napaka pri SQL poizvedbi!";
        }
    }

    public String getRegistrskaOznakaVozila() {
        return registrskaOznakaVozila;
    }

    public void setRegistrskaOznakaVozila(String registrskaOznakaVozila) {
        this.registrskaOznakaVozila = registrskaOznakaVozila;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
