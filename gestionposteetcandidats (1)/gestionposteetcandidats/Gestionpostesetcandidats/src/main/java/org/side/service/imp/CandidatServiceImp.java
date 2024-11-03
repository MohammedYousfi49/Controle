package org.side.service.imp;

import org.side.entities.Candidat;
import org.side.repository.CondidatRepository;
import org.side.service.CandidatService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatServiceImp implements CandidatService {

    private final CondidatRepository candidatRepository;

    public CandidatServiceImp(CondidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    @Override
    public Candidat enregistrerCandidat(String nom, String email, MultipartFile cvFile) throws IOException {
        Candidat candidat = new Candidat();
        candidat.setNom(nom);
        candidat.setEmail(email);
        candidat.setCv(cvFile.getBytes());  // Enregistrer le CV en base de données
        return candidatRepository.save(candidat);
    }

    @Override
    public List<Candidat> obtenirTousLesCandidats() {
        return candidatRepository.findAll();
    }

    @Override
    public Candidat trouverCandidatParId(Long id) {
        Optional<Candidat> candidat = candidatRepository.findById(id);
        return candidat.orElse(null);
    }



    @Override
    public void supprimerCandidat(Long id) {
        candidatRepository.deleteById(id);
    }

    @Override
    public void updateCandidat(Candidat candidat) {
        candidatRepository.save(candidat);
    }
}
