import java.util.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        out.println("TO-DO List");
        out.print("Create your list");
        int opt, pN, t;
        String tN;

        do {
            //main menu
            out.println("1. Create a new task\n2. Print my task list(s)\n3. Exit");
            opt = s.nextInt();
        } while (c) {
            //Option 1
            if (opt == 1) {
                out.print("Task name? (Character limit 40): ");
                tN = s.nextLine();
                
                while (tN.length() > 40) {
                    out.println("Oops!! You exceeded the character limit. Shorten PLS");
                    out.print("Task name? (Character limit 40): ");
                    tN = s.nextLine();
                }

                //priority
                out.print("\nPick your priority (1- RIGHT NOW! 2 - ASAP 3- End of Day): ");
                pN = s.nextInt();
                    
                //time needed
                out.print("\nEstimate how long this task might take you (in hours and minutes): ");//we can offer a time using our clock lab we did in cs3
                int h = s.nextInt();
                int m = s.nextInt();
                t = time(h, m); 
                    
                tasks.add(new Task(tN, pN, t));
            }
        
            //Option 2
            else if (opt == 2){
                if (tasks.size() == 0) {
                    out.println("GUESS WHAT!! you got no tasks");
                }
                else {
                    printTasks(tasks);
                }
            }

            //Option 3
            else {
                c = false;
                break;
            }
        }
    }

    public static int time(int h, int m) {
        return m + (h * 60);
    }

    public static void printTasks(ArrayList<Task> list) {
    HashMap<Integer, ArrayList<Task>> map = new HashMap<>();
    int index = 0;

    // Populate the HashMap with tasks grouped by priority
    while (index < list.size()) {
        int priority = list.get(index).getPriority();
        Task t = list.get(index);

        if (map.containsKey(priority)) {
            map.get(priority).add(t);
        } else {
            ArrayList<Task> taskList = new ArrayList<>();
            taskList.add(t);
            map.put(priority, taskList);
        }
        index++;
    } // End of while loop

    // Print tasks grouped by priority
    for (int i = 1; i <= 4; i++) {
        ArrayList<Task> taskList = map.get(i); // Get the list for priority i

        if (taskList != null) { // Check to avoid NullPointerException
            for (Task t : taskList) {
                System.out.println(t.toString());
            }
        }
    } // End of printing tasks
} // End of method  
}
