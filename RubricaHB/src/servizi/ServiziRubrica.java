package servizi;  
 

import java.util.Map;

import model.Rubrica; 
import model.Voce; 
import dao.RubricaDao;
import dao.VoceDao; 
 
 
public class ServiziRubrica { 
	
	private RubricaDao rDao = new RubricaDao();
	private VoceDao vDao = new VoceDao();
 
	// AGGIUNGI RUBRICA
	public boolean registraRubrica(String nome){
		
		boolean res = false;
		
		Rubrica r = new Rubrica(nome);
		
		res = rDao.creaRubrica(r);
		 
		
		return res;
	}
	
	// AGGIUNGI VOCE A RUBRICA
 	public boolean aggiungiVoce(Rubrica r,String nome, String cognome, String telefono){ 
 		
 		boolean res = false;
 		Voce v = new Voce(nome,cognome,telefono);
 		
 		v.setRubrica(r); // SPECIFICA IN QUALE RUBRICA INSERIRE LA VOCE
 		r.addVoce(v); // AGGIUNGE IN QUELLA RUBRICA LA VOCE
 		
 		res = vDao.insertVoce(v); // INSERISCE VOCE NEL DATABASE
 		rDao.updateRubrica(r); // AGGIORNA RUBRICA NEL DATABASE
 		
 		return res;
 	}
 	
 	// RITORNA UNA VOCE DEL NOME E COGNOME E DELLA RUBRICA PASSATI COME PARAMETRO 
 	public Voce getVoce(Rubrica r, String nome, String cognome, String telefono){ 
 		
 		Voce v = null; 
 		
 		v = vDao.readAllVoce(r, nome, cognome, telefono);
 		
 		return v;		 
 	} 
 	
 	// RITORNA TUTTE LE VOCI DELLA RUBRICA PASSATA COME PARAMETRO
 	public Map<String, Voce> getAll(Rubrica r){ 
 		
 		Map<String,Voce> voci = null;
 		
 		voci = vDao.readAllVoci(r.getId_rubrica()); 
 		
 		return voci;
 	
 	} 
 	
 	// AGGIORNA VOCE DELLA RUBRICA PASSATA COME PARAMETRO
 	public Voce updateVoce(Rubrica r, String id, String nome, String cognome, String telefono){ 
 		
 		Voce v = vDao.readVoceConId(id);
 		
 		v.setNome(nome);
 		v.setCognome(cognome);
 		v.setTelefono(telefono);
 		
 		vDao.updateVoce(v);
 		
 		return v; 
	
 	} 
 	
 	// CANCELLA VOCE CON NOME,COGNOME E RUBRICA PASSATI COME PARAMETRI
 	public void deleteVoce(Rubrica r, String nome, String cognome, String telefono){ 
 		
 		Voce v = vDao.readAllVoce(r,nome,cognome,telefono); 
 		
 		vDao.deleteVoce(v);		 
 	
 	} 
 
 	 
} 
