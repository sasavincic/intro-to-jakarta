package si.um.feri.aiv.dao;

import jakarta.ejb.Remote;
import si.um.feri.aiv.exceptions.VinjetaException;

@Remote
public interface KontrolorRemote {
    String checkForVinjeta(String registrskaOznakaVozila) throws Exception, VinjetaException;
}
