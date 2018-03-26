import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Plan implements Serializable {
    private String name;
    private ArrayList<Workout> workouts;
    private static final long serialVersionUID = -5429358616302639821L;

    public Plan(String planName) {
        this.name = planName;
        this.workouts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addWorkout(String workoutName) {
        this.workouts.add(new Workout(workoutName));
    }

    public void removeWorkout(String workoutName) {
        for (Workout w: this.workouts) {
            if (w.getWorkoutName().equalsIgnoreCase(workoutName)) {
                this.workouts.remove(w);
                break;
            }
        }
    }

    public ArrayList<Workout> getWorkouts() {
        if (this.workouts.isEmpty()) {
            System.out.println("\nThere are no workouts in this plan. Please add a workout: ");
            Scanner reader = new Scanner(System.in);
            addWorkout(reader.next());
            System.out.println("\nCurrent Workouts in your plan:");
        }
        return this.workouts;
    }

    public static void makePlanFile(Plan plan, String planName) {
        String objDir = "plans/";
        String name = planName.replaceAll("\\s+","");
        String newFileLoc = objDir + name;
        File outFile = new File(newFileLoc);
        Scanner reader = new Scanner(System.in);
        if (outFile.exists()) {
            System.out.println("A plan with this name already exists! Would you like to overwrite this plan?\n" +
                    "Enter 'yes' if you would like to overwrite.");
            if (reader.next().equalsIgnoreCase("yes")) {
                try {
                    ObjectOutputStream out =
                            new ObjectOutputStream(new FileOutputStream(outFile));
                    out.writeObject(plan);
                    out.close();
                } catch (IOException excp) {
                    excp.printStackTrace();
                }
            }
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
        String name = planName.replaceAll(" \\s+","");
        File inFile = new File("plans/" + name + "/");
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

    public static void updatePlan(Plan plan, String planName) {
        String objDir = "plans/";
        String name = planName.replaceAll("\\s ","");
        String newFileLoc = objDir + name;
        File outFile = new File(newFileLoc);
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
