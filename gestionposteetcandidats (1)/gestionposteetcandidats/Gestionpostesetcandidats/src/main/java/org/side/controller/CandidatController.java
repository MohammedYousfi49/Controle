package org.side.controller;


import org.side.entities.Candidat;
import org.side.service.CandidatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class CandidatController {

    private final CandidatService candidatService;

    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }
    @GetMapping("/candidatures")
    public String formulaireCandidature(Model model) {
        return "Candidat/candidatureForm";  // Affiche le formulaire de candidature
    }

    @PostMapping("/candidatures")
    public String soumettreCandidature(
            @RequestParam("nom") String nom,
            @RequestParam("email") String email,
            @RequestParam("cv") MultipartFile cvFile) {
        try {
            candidatService.enregistrerCandidat(nom, email, cvFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/candidats";
    }
    @GetMapping("/candidats")
    public String afficherTousLesCandidats(Model model) {
        model.addAttribute("candidats", candidatService.obtenirTousLesCandidats());
        return "Candidat/candidats";
    }

    @GetMapping("/candidats/delete/{id}")
    public String deleteCandidat(@PathVariable(value = "id") long id) {

        // call delete candidat method
        this.candidatService.supprimerCandidat(id);
        return "redirect:/candidats";
    }

    @GetMapping("/candidats/edit/{id}")
    public String editCandidat(@PathVariable("id") Long id, Model model) {
        Candidat candidat = candidatService.trouverCandidatParId(id);
        model.addAttribute("candidat", candidat);
        return "Candidat/edit";
    }

    // Méthode pour mettre à jour le candidat
    @PostMapping("/candidats/update")
    public String updateCandidat(@ModelAttribute("candidat") Candidat candidat,
                                 @RequestParam("cv") MultipartFile cvFile) throws IOException {
        // Conversion du fichier CV en tableau de bytes avant de l'affecter à l'entité Candidat
        if (!cvFile.isEmpty()) {
            candidat.setCv(cvFile.getBytes());  // Convertir le fichier en byte[]
        }

        candidatService.updateCandidat(candidat);
        return "redirect:/candidats"; // Redirection vers la liste des candidats
    }
    @GetMapping("/candidats/downloadCv/{id}")
    @ResponseBody
    public byte[] downloadCv(@PathVariable Long id) {
        Candidat candidat = candidatService.trouverCandidatParId(id);
        return candidat.getCv();
    }
}
