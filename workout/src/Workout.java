public class Workout {

    private String[] progressions;
    private String currProgression;
    public Workout() {
    }

    public void setCurrentProgression(String currProgression){
        this.currProgression = currProgression;
    }
    public String getCurrentProgression(){
        return this.currProgression;
    }
}
