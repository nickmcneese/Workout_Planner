import java.io.*;
import java.util.ArrayList;

public class Plan {
    private String name;
    private ArrayList<Workout> workouts;

    public Plan(String planName) {
        this.name = planName;
    }

    public String getName() {
        return name;
    }

    public void addWorkout(String workoutName) {
        this.workouts.add(new Workout(workoutName));
    }

    public static void makePlanFile(Plan plan, String planName) {
        String objDir = "plans/";
        String newFileLoc = objDir + planName;
        File outFile = new File(newFileLoc);
        if (outFile.exists()) {
            System.out.println("A plan with this name already exists! Enter a different name.");
        } else {
            try {
                ObjectOutputStream out =
                        new ObjectOutputStream(new FileOutputStream(outFile));
                out.writeObject(plan);
                out.close();
            } catch (IOException excp) {
                excp.printStackTrace();
            }
        }
    }

    public static Plan reconstructPlan(String planName) {
        Plan plan0;
        File inFile = new File("plans/" + planName + "/");
        try {
            ObjectInputStream inp =
                    new ObjectInputStream(new FileInputStream(inFile));
            plan0 = (Plan) inp.readObject();
            inp.close();
        } catch (IOException | ClassNotFoundException excp) {
            excp.printStackTrace();
            plan0 = null;
        }
        return plan0;
    }
}
