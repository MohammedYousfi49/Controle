package org.side.repository;


import java.util.List;
import java.util.Optional;

import org.side.entities.Poste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
@Repository
public interface PosteRepository extends JpaRepository<Poste, Long> {
    Optional<Poste> findByTitre(String titre);






}































//	@Autowired
// private JdbcTemplate jdbcTemplate;
//	public List<Poste> getPostes(){
//		var postes = new ArrayList<Poste>();
//		String sql ="SELECT * FROM postes ORDER BY id DESC";
//		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
//
//
//		while(rows.next()) {
//			Poste poste = new Poste();
//			poste.setId(rows.getLong("id"));
//			poste.setTitre(rows.getString("titre"));
//			poste.setDescription(rows.getString("description"));
//			poste.setDateFinCandidature(rows.getDate("date_fin_candidature"));
//			postes.add(poste);
//		}
//		return postes;


//public Poste getPoste(long id){
//
//		String sql ="SELECT * FROM postes WHERE id=?";
//		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql,id);
//
//
//		while(rows.next()) {
//			Poste poste = new Poste();
//			poste.setId(rows.getLong("id"));
//			poste.setTitre(rows.getString("titre"));
//			poste.setDescription(rows.getString("description"));
//			poste.setDateFinCandidature(rows.getDate("date_fin_candidature"));
//			return poste;
//
//		}
//		return null;
//
//	}
//
//public Poste getPostes(String titre){
//
//		String sql ="SELECT * FROM postes WHERE titre=?";
//		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql,titre);
//
//
//		while(rows.next()) {
//			Poste poste = new Poste();
//			poste.setId(rows.getLong("id"));
//			poste.setTitre(rows.getString("titre"));
//			poste.setDescription(rows.getString("description"));
//			poste.setDateFinCandidature(rows.getDate("date_fin_candidature"));
//			return poste;
//
//		}
//		return null;
//
//	}

//     public Poste createPoste(Poste poste) {
//    String sql = "INSERT INTO postes(titre, description, date_fin_candidature) VALUES (?, ?, ?)";
//    int count = jdbcTemplate.update(sql, poste.getTitre(), poste.getDescription(), poste.getDateFinCandidature());
//    if (count > 0) {
//        long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
//        return getPoste(id);
//    }
//    return null;
//}
//public Poste updatePoste(Poste poste) {
//    String sql = "UPDATE postes SET titre=?, description= ?,date_fin_candidature=? WHERE id=?";
//    jdbcTemplate.update(sql, poste.getTitre(), poste.getDescription(), poste.getDateFinCandidature(),poste.getId());
//    return  getPoste(poste.getId());
//}
//
//public void deletePoste(long id) {
//	String sql = "DELETE FROM postes WHERE id=?";
//	jdbcTemplate.update(sql,id);







