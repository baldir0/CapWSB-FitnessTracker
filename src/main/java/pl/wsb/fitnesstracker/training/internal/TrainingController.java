package pl.wsb.fitnesstracker.training.internal;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingDto;

import java.util.List;

@RestController
@RequestMapping("/v1/trainings")
public class TrainingController {
    TrainingServiceImpl trainingService;

    TrainingMapper trainingMapper;
    public TrainingController(TrainingServiceImpl trainingService) {

        this.trainingService = trainingService;
    }

    @GetMapping
    public List<TrainingDto> getTrainings() {
        return this.trainingService.getTrainings().stream().map(TrainingMapper::toTrainingDto).toList();
    }

    @GetMapping("/{id}")
    public List<TrainingDto> getTraining(@PathVariable Long id) {
        return this.trainingService.getTraining(id).stream().map(TrainingMapper::toTrainingDto).toList();
    }
}
