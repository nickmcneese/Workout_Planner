import java.io.File;
import java.util.Scanner;

public class Main {

    private static Plan plan;

    public static void main(String[] args) {
        File planDir = new File("plans");
        if (!planDir.exists()) {
            planDir.mkdirs();
        }
        prompt();
    }

    public static void prompt() {
        Scanner reader = new Scanner(System.in);
        File folder = new File("plans/");
        System.out.println("1: Select a current workout plan.");
        System.out.println("2: Create a new workout plan.");
        System.out.println("3: Exit.");
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
                plan = Plan.reconstructPlan(recallName);
            } else {
                System.out.println("A plan by that name does not exist.\n");
                prompt();
            }
        } else if (output.equals("2")) {
            createNewPlan();
        } else if (output.equals("3")) {
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
