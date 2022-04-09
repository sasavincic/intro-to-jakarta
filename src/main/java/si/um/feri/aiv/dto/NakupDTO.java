package si.um.feri.aiv.dto;

import si.um.feri.aiv.entity.Nakup;

import java.time.LocalDate;

public class NakupDTO {
    String registrskaOznakaVozila;
    String tipVozila;
    LocalDate datumNakupa;
    LocalDate datumZacetkaVeljavnosti;

    public NakupDTO(String registrskaOznakaVozila, String tipVozila, LocalDate datumNakupa, LocalDate datumZacetkaVeljavnosti) {
        this.registrskaOznakaVozila = registrskaOznakaVozila;
        this.tipVozila = tipVozila;
        this.datumNakupa = datumNakupa;
        this.datumZacetkaVeljavnosti = datumZacetkaVeljavnosti;
    }

    public Nakup nakupDTOtoNakup() {
        Nakup nakup = new Nakup();
        return nakup;
    }
}
