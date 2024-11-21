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
        ArrayList<Task> sorted = new ArrayList<>();
        for(int i = 0; i< list.size(); i++){
            ArrayList<Task> temp = new ArrayList<>();
            for(Task task: list){
                System.out.println(task);
            }
        }
    }  
}
