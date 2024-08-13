package app.Bimba.repository;

import app.Bimba.model.WaliMurid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaliMuridRepository extends JpaRepository<WaliMurid,Integer> {
}
