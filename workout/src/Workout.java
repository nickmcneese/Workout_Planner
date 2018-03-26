import java.util.ArrayList;

public class Workout {

    private ArrayList<String> progressions;
    private String currProgression;
    private String workoutName;

    public Workout(String workoutName) {
        this.workoutName = workoutName;
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
