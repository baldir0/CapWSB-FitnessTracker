package pl.wsb.fitnesstracker.training.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;
import pl.wsb.fitnesstracker.training.api.TrainingRepository;

import java.util.List;
import java.util.Optional;

// TODO: Provide Implementation and correct the return type of the method getTraining
@Service
@Slf4j
public class TrainingServiceImpl implements TrainingProvider {

    public final TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public Optional<Training> getTraining(final Long trainingId) {
        return trainingRepository.findById(trainingId);
    }


    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }
}
