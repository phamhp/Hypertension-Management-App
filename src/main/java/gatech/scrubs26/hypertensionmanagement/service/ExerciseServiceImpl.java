package gatech.scrubs26.hypertensionmanagement.service;

import gatech.scrubs26.hypertensionmanagement.model.Diet;
import gatech.scrubs26.hypertensionmanagement.model.Exercise;
import gatech.scrubs26.hypertensionmanagement.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public void save(Exercise exercise) {exerciseRepository.save(exercise); }

    @Override
    public List<Exercise> findAll() { return exerciseRepository.findAll(); }

}