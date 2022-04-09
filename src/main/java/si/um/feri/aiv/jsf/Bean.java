package si.um.feri.aiv.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.*;
import si.um.feri.aiv.entity.Prodajalec;
import si.um.feri.aiv.entity.TipVinjete;
import si.um.feri.aiv.entity.Nakup;

@Named("demo")
@SessionScoped
public class Bean implements Serializable {

	private static final long serialVersionUID = -8979220536758073133L;

	Logger log = Logger.getLogger(Bean.class.toString());

	@EJB
	private ProdajalecDao prodajalecPostgresDao;
	@EJB
	private TipVinjeteDao tipVinjetePostgresDao;
	@EJB
	private NakupDao nakupPostgresDao;

	private Nakup selectedNakup = new Nakup();
	private TipVinjete selectedTipVinjete = new TipVinjete();
	private Prodajalec selectedProdajalec = new Prodajalec();

	private Integer selectedIdProdajalec;
	private Integer selectedIdTipVinjete;
	private Integer selectedIdNakup;

	private Integer tempIdTipa;
	private Integer tempIdProdajalca;

	public List<Nakup> getAllNakup() throws Exception {
		return nakupPostgresDao.getAll();
	}

	public List<TipVinjete> getAllTipVinjete() throws Exception {
		return tipVinjetePostgresDao.getAll();
	}

	public List<Prodajalec> getAllProdajalec() throws Exception {
		return prodajalecPostgresDao.getAll();
	}

	public String saveNakup() throws Exception {
		selectedNakup.setTipVinjete(tipVinjetePostgresDao.find(tempIdTipa));
		selectedNakup.setProdajalec(prodajalecPostgresDao.find(tempIdProdajalca));
		nakupPostgresDao.save(selectedNakup);
		return "listNakup";
	}

	public String saveTipVinjete() throws Exception {
		tipVinjetePostgresDao.save(selectedTipVinjete);
		return "listTipVinjete";
	}

	public String saveProdajalec() throws Exception {
		prodajalecPostgresDao.save(selectedProdajalec);
		return "listProdajalec";
	}


	public void deleteNakup(Nakup nakup) throws Exception {
		nakupPostgresDao.delete(nakup.getId());
	}

	public void deleteTipVinjete(TipVinjete tipVinjete) throws Exception {
		tipVinjetePostgresDao.delete(tipVinjete.getId());
	}

	public void deleteProdajalec(Integer id) throws Exception {
		prodajalecPostgresDao.delete(id);
	}

	public Nakup getSelectedNakup() {
		return selectedNakup;
	}

	public void setSelectedNakup(Nakup selectedNakup) {
		this.selectedNakup = selectedNakup;
	}

	public TipVinjete getSelectedTipVinjete() {
		return selectedTipVinjete;
	}

	public void setSelectedTipVinjete(TipVinjete selectedTipVinjete) {
		this.selectedTipVinjete = selectedTipVinjete;
	}

	public Prodajalec getSelectedProdajalec() {
		return selectedProdajalec;
	}

	public void setSelectedProdajalec(Prodajalec selectedProdajalec) {
		this.selectedProdajalec = selectedProdajalec;
	}

	public Integer getSelectedIdNakup() {
		return selectedIdNakup;
	}

	public void setSelectedIdNakup(Integer id) throws Exception{
		this.selectedIdNakup = id;
		selectedNakup = nakupPostgresDao.find(selectedIdNakup);
		if (selectedNakup == null){
			selectedNakup = new Nakup();
		}
	}

	public Integer getSelectedIdProdajalec() {
		return selectedIdProdajalec;
	}

	public void setSelectedIdProdajalec(Integer id) throws Exception {
		this.selectedIdProdajalec = id;
		selectedProdajalec = prodajalecPostgresDao.find(selectedIdProdajalec);
		if (selectedProdajalec == null){
			selectedProdajalec = new Prodajalec();
		}
	}

	public Integer getSelectedIdTipVinjete() {
		return selectedIdTipVinjete;
	}

	public void setSelectedIdTipVinjete(Integer id) throws Exception {
		this.selectedIdTipVinjete = id;
		selectedTipVinjete = tipVinjetePostgresDao.find(selectedIdTipVinjete);
		if (selectedTipVinjete == null){
			selectedTipVinjete = new TipVinjete();
		}
	}

	public Integer getTempIdTipa() {
		return tempIdTipa;
	}

	public void setTempIdTipa(Integer tempIdTipa) {
		this.tempIdTipa = tempIdTipa;
	}

	public Integer getTempIdProdajalca() {
		return tempIdProdajalca;
	}

	public void setTempIdProdajalca(Integer tempIdProdajalca) {
		this.tempIdProdajalca = tempIdProdajalca;
	}
}