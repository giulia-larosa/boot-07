package it.corso.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class Utente {
	
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Caratteri non ammessi")
	private String nome;
	
	// il pattern non va con gli interi, ma posso definire un range di valori
	@Min(value = 1, message = "Valore troppo basso")
	@Max(value = 120, message = "Valore troppo alto")
	private int eta;
	
	@Pattern(regexp = "[a-zA-Z.0-9]{1,20}", message = "Caratteri non ammessi")
	private String username;
	
	// ESPRESSIONE REGOLARE PER UNA PASSWORD
	//(?=.*\\d): almeno un numero
	// (?=.*[a-z]): almeno un carattere minuscolo
	// (?=.*[A-Z]): almeno un carattere maiuscolo
	// [0-9a-zA-Z]: tutti i caratteri ammessi in generale 
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,20}", message = "Password troppo debole")
	private String password;
	
	// METODI GETTER E SETTER
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
