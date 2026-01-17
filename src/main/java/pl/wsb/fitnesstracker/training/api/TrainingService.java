package pl.wsb.fitnesstracker.training.api;

import java.util.List;
import java.util.Optional;

public interface TrainingService {
    Optional<Training> getTraining(final Long id);
    List<Training> getTrainings();
}
