package gatech.scrubs26.hypertensionmanagement.service;

import gatech.scrubs26.hypertensionmanagement.model.Diet;
import gatech.scrubs26.hypertensionmanagement.repository.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietServiceImpl implements DietService{
    @Autowired
    private DietRepository dietRepository;

    @Override
    public void save(Diet diet) {
        dietRepository.save(diet);
    }

    @Override
    public List<Diet> findAll() {
        return dietRepository.findAll();
    }


}
