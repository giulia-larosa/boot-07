package it.corso.service;

import org.springframework.stereotype.Service;

import it.corso.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Override
	public void registrazioneUtente(Utente utente) {
		// qui verrebbe il momento di chiamare il componente che interagisce col database. Di fatto qui avverrà il collegamento col database
		System.out.println(utente.getNome() + " registrato");

	}

}
