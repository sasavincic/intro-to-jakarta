package si.um.feri.aiv.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import si.um.feri.aiv.observers.*;

@Entity
public class Nakup implements ObservedPart {

	@Id
	@GeneratedValue
	private Integer id;

	private String registrskaOznakaVozila;

	@ManyToOne(cascade = CascadeType.ALL)
	private TipVinjete tipVinjete;

	private String tipVozila;

	private LocalDate datumNakupa;

	private LocalDate datumZacetkaVeljavnosti;

	@ManyToOne(cascade = CascadeType.ALL)
	private Prodajalec prodajalec;

	@Transient
	private List<Observer> observers = new ArrayList<>();

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyAll(ObserverEventType observerEventType) {
		attach(new BasicObserver());
		attach(new NotValidObserver());
		attach(new MailingObserver());

		for (Observer observer : observers) {
			observer.observe(this, observerEventType);
		}
	}

	public boolean checkIfValid() {
		boolean valid = true;

		ObserverEventType observerEventType = ObserverEventType.BASIC;

		LocalDate currentDate = LocalDate.now();
		LocalDate experationDate = this.getDatumZacetkaVeljavnosti().plusDays(this.getTipVinjete().getVeljavnostVinjete());

		boolean validOnDate = currentDate.isBefore(experationDate);
		boolean validTipVozila = this.getTipVozila().equals(this.getTipVinjete().getTipVozila());

		if (!validOnDate || !validTipVozila){
			valid = false;
			observerEventType = ObserverEventType.NOT_VALID;
		}

		notifyAll(observerEventType);
		return valid;
	}
	public Nakup(){}

	public Nakup(Integer id, String registrskaOznakaVozila, TipVinjete tipVinjete, String tipVozila, LocalDate datumNakupa, LocalDate datumZacetkaVeljavnosti, Prodajalec prodajalec) {
		this.id = id;
		this.registrskaOznakaVozila = registrskaOznakaVozila;
		this.tipVinjete = tipVinjete;
		this.tipVozila = tipVozila;
		this.datumNakupa = datumNakupa;
		this.datumZacetkaVeljavnosti = datumZacetkaVeljavnosti;
		this.prodajalec = prodajalec;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegistrskaOznakaVozila() {
		return registrskaOznakaVozila;
	}

	public void setRegistrskaOznakaVozila(String registrskaOznakaVozila) {
		this.registrskaOznakaVozila = registrskaOznakaVozila;
	}

	public TipVinjete getTipVinjete() {
		return tipVinjete;
	}

	public void setTipVinjete(TipVinjete tipVinjete) {
		this.tipVinjete = tipVinjete;
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

	public Prodajalec getProdajalec() {
		return prodajalec;
	}

	public void setProdajalec(Prodajalec prodajalec) {
		this.prodajalec = prodajalec;
	}
}