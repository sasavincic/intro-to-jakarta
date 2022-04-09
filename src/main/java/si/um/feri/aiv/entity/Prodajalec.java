package si.um.feri.aiv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Prodajalec {

    @Id
    @GeneratedValue
    private Integer id;

    private String naziv;

    private Integer steviloProdanihVinjet = 0;

    public Prodajalec(){}

    public Prodajalec(String naziv, Integer steviloProdanihVinjet, Integer id){
        this.naziv = naziv;
        this.steviloProdanihVinjet = steviloProdanihVinjet;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getSteviloProdanihVinjet() {
        return steviloProdanihVinjet;
    }

    public void setSteviloProdanihVinjet(Integer steviloProdanihVinjet) {
        this.steviloProdanihVinjet = steviloProdanihVinjet;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
