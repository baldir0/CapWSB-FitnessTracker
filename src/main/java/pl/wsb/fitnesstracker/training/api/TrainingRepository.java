package pl.wsb.fitnesstracker.training.api;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainingRepository {

    @PersistenceContext
    private EntityManager em;

    public Training getTraining(int id) {
        String SQLStatement = "select t from Training t where id = :id";
        return (Training) em.createQuery(SQLStatement).setParameter("id", id).getSingleResult();
    }

    public List<Training> getAllTrainings() {
        String SQLStatement = "select t from Training t";
        return (List<Training>) em.createQuery(SQLStatement).getResultList();
    }
}
