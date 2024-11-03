package org.side.service;

import java.util.List;

import org.side.entities.Poste;

public interface PosteService {
	List<Poste> getAllPostes();

	Poste savePoste(Poste poste);
	Poste getPosteByTitre(String titre);


	Poste getPosteById(long id);
	Poste updatePoste(Poste poste);

	void deletePosteById(long id);
	Poste createPoste(Poste poste);

}
