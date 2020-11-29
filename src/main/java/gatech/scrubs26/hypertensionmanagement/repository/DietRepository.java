package gatech.scrubs26.hypertensionmanagement.repository;

import gatech.scrubs26.hypertensionmanagement.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DietRepository extends JpaRepository<Diet, Long> {
    List<Diet> findByUsername(String username);
    List<Diet> findAll();
    @Query(value = "Select d From Diet d where username = :username Order By created_date desc")
    List<Diet> findCurrentDietEntries(@Param("username") String username);
}
