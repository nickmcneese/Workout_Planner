import java.io.Serializable;
import java.util.ArrayList;

public class Workout implements Serializable {

    private ArrayList<String> progressions;
    private String currProgression;
    private String workoutName;

    public Workout(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setCurrentProgression(String currProgression){
        this.currProgression = currProgression;
    }
    public String getCurrentProgression(){
        return this.currProgression;
    }

    public void addProgressions(ArrayList<String> progressionList){
        this.progressions = progressionList;
    }

}
