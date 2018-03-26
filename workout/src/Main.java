import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File planDir = new File("plans");
        if (!planDir.exists()) {
            planDir.mkdirs();
        }
        prompt();
    }

    public static void prompt() {
        Scanner reader = new Scanner(System.in);
        System.out.println("1: Take me to my plan.");
        System.out.println("2: Create a new workout plan.");
        String output = reader.next();
        if (output.equals("1")) {

        } else if (output.equals("2")) {
            System.out.println("Please enter a name for your workout plan: ");
            String planName = reader.next();
            Plan newPlan = new Plan(planName);
            Plan.makePlanFile(newPlan, planName);
        } else {
            System.out.println("Please enter either 1 or 2.");
            prompt();
        }
    }
}
