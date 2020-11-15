package gatech.scrubs26.hypertensionmanagement.service;

import gatech.scrubs26.hypertensionmanagement.model.Diet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DietService {
    void save(Diet diet);

    List<Diet> findAll();
}


