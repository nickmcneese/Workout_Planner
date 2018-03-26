import java.util.ArrayList;

public class Workout {

    private ArrayList<String> progressions;
    private String currProgression;
    private String planName;
    public Workout(String planName) {
        this.planName = planName;
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
