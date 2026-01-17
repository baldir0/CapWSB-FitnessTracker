package pl.wsb.fitnesstracker.training.internal;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingRepository;

import java.util.List;

@Component
public class TrainingReportScheduler {

    public final TrainingRepository trainingRepository;

    public TrainingReportScheduler(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Scheduled(cron = "0 0 9 * * Mon")
    public void generateRaport() {

        List<Training> traingings =  trainingRepository.findAll().stream().toList();

        for (Training training : traingings) {
            System.out.println(" ------ ");
            System.out.println("Report Id. " + training.getId());
            System.out.println("User: " + training.getUser().getFirstName() + " " + training.getUser().getLastName());
            System.out.println("Distance: " + training.getDistance());
            System.out.println("Avg Speed: " +  training.getAverageSpeed());
            System.out.println("Start Time: " + training.getStartTime());
            System.out.println("End Time: " + training.getEndTime());
        }

    }
}
