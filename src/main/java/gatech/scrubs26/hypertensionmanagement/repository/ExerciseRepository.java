package gatech.scrubs26.hypertensionmanagement.repository;

import gatech.scrubs26.hypertensionmanagement.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Exercise findByType(String type);

    List<Exercise> findByUsername(String username);
}