package si.um.feri.aiv.dto;

import si.um.feri.aiv.entity.Nakup;
import si.um.feri.aiv.entity.Prodajalec;
import si.um.feri.aiv.entity.TipVinjete;

import java.time.LocalDate;

public class NakupDTO {
    String registrskaOznakaVozila;
    String nazivTipVinjete;
    String tipVozilaTipVinjete;
    Integer veljavnostVinjete;
    String tipVozila;
    LocalDate datumNakupa;
    LocalDate datumZacetkaVeljavnosti;
    String nazivProdajalec;

    public NakupDTO(){}
    public NakupDTO(String registrskaOznakaVozila, String nazivTipVinjete, String tipVozilaTipVinjete, Integer veljavnostVinjete, String tipVozila, LocalDate datumNakupa, LocalDate datumZacetkaVeljavnosti, String nazivProdajalec) {
        this.registrskaOznakaVozila = registrskaOznakaVozila;
        this.nazivTipVinjete = nazivTipVinjete;
        this.tipVozilaTipVinjete = tipVozilaTipVinjete;
        this.veljavnostVinjete = veljavnostVinjete;
        this.tipVozila = tipVozila;
        this.datumNakupa = datumNakupa;
        this.datumZacetkaVeljavnosti = datumZacetkaVeljavnosti;
        this.nazivProdajalec = nazivProdajalec;
    }

    public Nakup nakupDTOtoNakup() {
        Nakup nakup = new Nakup();
        nakup.setRegistrskaOznakaVozila(this.registrskaOznakaVozila);
        nakup.setTipVinjete(new TipVinjete(this.nazivTipVinjete, this.tipVozilaTipVinjete, this.veljavnostVinjete));
        nakup.setTipVozila(this.tipVozila);
        nakup.setDatumNakupa(this.datumNakupa);
        nakup.setDatumZacetkaVeljavnosti(this.datumZacetkaVeljavnosti);
        nakup.setProdajalec(new Prodajalec(this.nazivProdajalec));
        return nakup;
    }

    public String getRegistrskaOznakaVozila() {
        return registrskaOznakaVozila;
    }

    public void setRegistrskaOznakaVozila(String registrskaOznakaVozila) {
        this.registrskaOznakaVozila = registrskaOznakaVozila;
    }

    public String getNazivTipVinjete() {
        return nazivTipVinjete;
    }

    public void setNazivTipVinjete(String nazivTipVinjete) {
        this.nazivTipVinjete = nazivTipVinjete;
    }

    public String getTipVozilaTipVinjete() {
        return tipVozilaTipVinjete;
    }

    public void setTipVozilaTipVinjete(String tipVozilaTipVinjete) {
        this.tipVozilaTipVinjete = tipVozilaTipVinjete;
    }

    public Integer getVeljavnostVinjete() {
        return veljavnostVinjete;
    }

    public void setVeljavnostVinjete(Integer veljavnostVinjete) {
        this.veljavnostVinjete = veljavnostVinjete;
    }

    public String getTipVozila() {
        return tipVozila;
    }

    public void setTipVozila(String tipVozila) {
        this.tipVozila = tipVozila;
    }

    public LocalDate getDatumNakupa() {
        return datumNakupa;
    }

    public void setDatumNakupa(LocalDate datumNakupa) {
        this.datumNakupa = datumNakupa;
    }

    public LocalDate getDatumZacetkaVeljavnosti() {
        return datumZacetkaVeljavnosti;
    }

    public void setDatumZacetkaVeljavnosti(LocalDate datumZacetkaVeljavnosti) {
        this.datumZacetkaVeljavnosti = datumZacetkaVeljavnosti;
    }

    public String getNazivProdajalec() {
        return nazivProdajalec;
    }

    public void setNazivProdajalec(String nazivProdajalec) {
        this.nazivProdajalec = nazivProdajalec;
    }

    @Override
    public String toString() {
        return "NakupDTO{" +
                "registrskaOznakaVozila='" + registrskaOznakaVozila + '\'' +
                ", nazivTipVinjete='" + nazivTipVinjete + '\'' +
                ", tipVozilaTipVinjete='" + tipVozilaTipVinjete + '\'' +
                ", veljavnostVinjete=" + veljavnostVinjete +
                ", tipVozila='" + tipVozila + '\'' +
                ", datumNakupa=" + datumNakupa +
                ", datumZacetkaVeljavnosti=" + datumZacetkaVeljavnosti +
                ", nazivProdajalec='" + nazivProdajalec + '\'' +
                '}';
    }
}
