package servizi;  
 

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
 		
 		v.setRubrica(r);
 		r.addVoce(v);
 		
 		res = vDao.insertVoce(v);
 		rDao.updateRubrica(r);
 		
 		return res;
 	}
 	
// 	// RITORNA UNA VOCE DEL NOME E COGNOME E DELLA RUBRICA PASSATI COME PARAMETRO 
// 	public Voce getVoce(Rubrica r, String nome, String cognome){ 
// 		
// 		Voce v = null; 
// 		v = vDao.leggiVoceConNomeCognomeId(nome, cognome, r.getId_rubrica()); 
// 		return v;		 
// 	} 
// 	
// 	// RITORNA TUTTE LE VOCI DELLA RUBRICA PASSATA COME PARAMETRO
// 	public Map<String, Voce> getAll(Rubrica r){ 
// 		
// 		return vDao.leggiVoceConId(r.getId_rubrica()); 
// 	
// 	} 
// 	
// 	// AGGIORNA VOCE DELLA RUBRICA PASSATA COME PARAMETRO
// 	public Voce updateVoce(Rubrica r, String nomeVecchio, String cognomeVecchio,  
// 			String nome, String cognome, String telefono){ 
// 		
// 		Voce v = null; 
// 		v = vDao.leggiVoceConNomeCognomeId(nomeVecchio, cognomeVecchio, r.getId_rubrica()); 
// 		if(v!=null){ 
// 			vDao.updateVoce(nome, cognome, telefono, v.getId_voce()); 
// 			v = vDao.leggiVoceConNomeCognomeId(nome, cognome, r.getId_rubrica()); 
// 		} 
// 		return v; 
// 		
// 	} 
// 	
// 	// CANCELLA VOCE CON NOME,COGNOME E RUBRICA PASSATI COME PARAMETRI
// 	public void deleteVoce(Rubrica r, String nome, String cognome){ 
// 		
// 		Voce v = vDao.leggiVoceConNomeCognomeId(nome, cognome, r.getId_rubrica()); 
// 		vDao.deleteVoce(v.getId_voce());		 
// 	
// 	} 
// 
// 	 
} 
