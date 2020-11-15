package gatech.scrubs26.hypertensionmanagement.service;

import gatech.scrubs26.hypertensionmanagement.model.Exercise;
import org.springframework.stereotype.Service;

@Service
public interface ExerciseService {
    void save(Exercise exercise);

    Exercise findByType(String type);
}
