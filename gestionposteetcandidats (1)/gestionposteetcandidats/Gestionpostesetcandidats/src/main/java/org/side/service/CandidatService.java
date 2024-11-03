package org.side.service;

import org.side.entities.Candidat;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CandidatService {
    Candidat enregistrerCandidat(String nom, String email, MultipartFile cvFile) throws IOException;
    List<Candidat> obtenirTousLesCandidats();
    Candidat trouverCandidatParId(Long id);

    void supprimerCandidat(Long id);

    void updateCandidat(Candidat candidat);
}
