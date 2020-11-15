package gatech.scrubs26.hypertensionmanagement.repository;

import gatech.scrubs26.hypertensionmanagement.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DietRepository extends JpaRepository<Diet, Long> {
    Diet findByName(String name);

    List<Diet> findAll();
}
