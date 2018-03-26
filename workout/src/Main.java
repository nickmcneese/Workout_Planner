import java.io.File;
import java.util.Scanner;

public class Main {

    private static Plan selectedPlan = null;
    private static Workout selectedWorkout = null;

    public static void main(String[] args) {
        File planDir = new File("plans");
        Scanner reader = new Scanner(System.in);
        if (!planDir.exists()) {
            planDir.mkdirs();
        }
        prompt();
        if (selectedPlan != null) {
            System.out.println("\n\n-----------------\nPlan: " + selectedPlan.getName()
                + "\n");
            System.out.println("Current Workouts in your plan:");
            for (Workout w : selectedPlan.getWorkouts()) {
                System.out.println("-" + w.getWorkoutName());
            }
            String command = reader.nextLine();
            if (command.contains("add")) {
                String newWorkout = command.substring(3);
                newWorkout = newWorkout.replaceAll("\\s+", "");
                selectedPlan.addWorkout(newWorkout);
            } else if (command.contains("remove")) {
                String removed = command.substring(6);
                removed = removed.replaceAll("\\s+", "");
                selectedPlan.removeWorkout(removed);
            } else {
                for (Workout w: selectedPlan.getWorkouts()) {
                    if (w.getWorkoutName().equalsIgnoreCase(command)) {
                       selectedWorkout = w;
                       workoutPrompt(w);
                    }
                }
            }
            Plan.updatePlan(selectedPlan, selectedPlan.getName());
        }
    }

    public static void workoutPrompt(Workout workout){
        System.out.println("\n\n-----------------\n " + workout.getWorkoutName() + "\n");

    }

    public static void prompt() {
        Scanner reader = new Scanner(System.in);
        File folder = new File("plans/");
        System.out.println("1: Select a current workout plan.");
        System.out.println("2: Create a new workout plan.");
        System.out.println("3: Remove a workout plan.");
        System.out.println("4: Exit.");
        String output = reader.next();
        if (output.equals("1")) {
            System.out.println("What was the name of your plan? Here are all current plans:");
            System.out.println("-----------------");
            for (File f : folder.listFiles()) {
                if (!f.getName().equals(".DS_Store")) {
                    System.out.println(f.getName());
                }
            }
            System.out.println("-----------------");
            String recallName = reader.next();
            if (new File("plans/" + recallName).exists()) {
                selectedPlan = Plan.reconstructPlan(recallName);
            } else {
                System.out.println("A plan by that name does not exist.\n");
                prompt();
            }
        } else if (output.equals("2")) {
            createNewPlan();
            prompt();
        } else if (output.equals("3")) {
            String planName = reader.next();
            if (new File("plans/" + planName).exists()) {
                new File("plans/" + planName).delete();
                System.out.println(planName + " has been deleted.\n");
            }
        } else if (output.equals("4")) {
            return;
        } else {
            System.out.println("Please enter either 1, 2, or 3.");
            prompt();
        }
    }

    public static void createNewPlan() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter a name for your workout plan: ");
        String planName = reader.next();
        Plan newPlan = new Plan(planName);
        Plan.makePlanFile(newPlan, planName);
    }
}
