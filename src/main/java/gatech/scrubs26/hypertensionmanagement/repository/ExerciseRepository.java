package gatech.scrubs26.hypertensionmanagement.repository;


import gatech.scrubs26.hypertensionmanagement.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Exercise findByType(String type);
}