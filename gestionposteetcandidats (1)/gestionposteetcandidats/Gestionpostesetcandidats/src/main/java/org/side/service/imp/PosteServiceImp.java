package org.side.service.imp;

import java.util.List;

import org.side.entities.Poste;
import org.side.repository.PosteRepository;
import org.side.service.PosteService;
import org.springframework.stereotype.Service;
@Service
public class PosteServiceImp implements PosteService {

	private  PosteRepository posteRepository;
	public PosteServiceImp(PosteRepository posteRepository) {
		super();
		this.posteRepository = posteRepository;
	}



	@Override
	public List<Poste> getAllPostes() {
		// TODO Auto-generated method stub
		return posteRepository.findAll();
	}




	@Override
	public Poste savePoste(Poste poste) {
		// TODO Auto-generated method stub
		return posteRepository.save(poste);
	}



	@Override
	public Poste getPosteById(long id) {
		// TODO Auto-generated method stub
		return posteRepository.findById(id).get();
	}



	@Override
	public Poste updatePoste(Poste poste) {
		// TODO Auto-generated method stub
		return posteRepository.save(poste);
	}



	@Override
	public void deletePosteById(long id) {

		posteRepository.deleteById(id);

	}

	@Override
	public Poste getPosteByTitre(String titre) {
	    return posteRepository.findByTitre(titre).orElse(null);
	}


	@Override
	public Poste createPoste(Poste poste) {

	    return posteRepository.save(poste);
	}














}
