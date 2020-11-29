package gatech.scrubs26.hypertensionmanagement.service;

import gatech.scrubs26.hypertensionmanagement.model.Exercise;
import gatech.scrubs26.hypertensionmanagement.repository.RoleRepository;
import gatech.scrubs26.hypertensionmanagement.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;


    @Override
    public void save(Exercise exercise) {
        exercise.setType(exercise.getType());
        exercise.setDuration(exercise.getDuration());
        exercise.setNotes(exercise.getNotes());

        exerciseRepository.save(exercise);
    }

    @Override
    public Exercise findByType(String type) {
        return exerciseRepository.findByType(type);
    }
}