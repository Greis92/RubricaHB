package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Rubrica {
	
	// ATTRIBUTO
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id_rubrica;
	
	private String name;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="voci",cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE) // POSSO CREARE UNA RUBRICA VUOTA
	Set<Voce> listaVoci = new HashSet<Voce>();
	
	// COSTRUTTORE VUOTO
	public Rubrica() {}
	
	// COSTRUTTORE CON NOME
	public Rubrica(String name) {
		this.name = name;
	}
	
	// METODI GET E SET
	public String getId_rubrica() {
		return id_rubrica;
	}

	public void setId_rubrica(String id_rubrica) {
		this.id_rubrica = id_rubrica;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addVoce(Voce voce){
		this.listaVoci.add(voce);
	}
	
}
