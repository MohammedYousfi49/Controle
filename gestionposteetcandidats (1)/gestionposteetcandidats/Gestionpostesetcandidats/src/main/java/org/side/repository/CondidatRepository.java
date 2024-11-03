package org.side.repository;


import org.side.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondidatRepository extends JpaRepository<Candidat, Long> {
}
