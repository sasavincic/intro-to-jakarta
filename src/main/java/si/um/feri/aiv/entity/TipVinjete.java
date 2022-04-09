package si.um.feri.aiv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TipVinjete {
    @Id
    @GeneratedValue
    private Integer id;

    private String naziv;

    private String tipVozila;

    private Integer veljavnostVinjete;

    public TipVinjete(){}
    public TipVinjete(String naziv, String tipVozila, Integer veljavnostVinjete, Integer id) {
        this.naziv = naziv;
        this.tipVozila = tipVozila;
        this.veljavnostVinjete = veljavnostVinjete;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTipVozila() {
        return tipVozila;
    }

    public void setTipVozila(String tipVozila) {
        this.tipVozila = tipVozila;
    }

    public Integer getVeljavnostVinjete() {
        return veljavnostVinjete;
    }

    public void setVeljavnostVinjete(Integer veljavnostVinjete) {
        this.veljavnostVinjete = veljavnostVinjete;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
