package pl.wsb.fitnesstracker.training.api;

import jakarta.annotation.Nullable;
import pl.wsb.fitnesstracker.training.internal.ActivityType;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Date;

public record TrainingDto(
        @Nullable Long id,
        User user,
        Date startTime,
        Date endTime,
        ActivityType activityType,
        double distance,
        double averageSpeed
) {

}
