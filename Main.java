import java.util.*;

import static java.lang.System.out;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        out.println("TO-DO List");
        out.print("Create your list");
        int a , c, d, e, f;
        String b, priority;
        
        do{
            //main menu
            out.println("1.Create a new task\n2.Print my task(s)\n3.Change the status of my task");
            a = s.nextInt();
            //Option 1
            if(a == 1){
                out.print("Task name? (Character limit 35): ");
                b = s.nextLine();
            while(b.length() > 35){
                out.println("Oops!! You exceeded the character limit. Abbreviate PLS");
                out.print("Task name? (Character limit 35): ");
                b = s.nextLine();
            }
            //priority
            out.print("Pick your priority (1- RIGHT NOW! 2 - ASAP 3- End of Day): ");
            c = s.nextInt();
            if(c == 1){
                priority = "Right NOW!";
            }
            else if(c == 2){
                priority = "ASAP";
            }
            else{
                priority = "End of Day";
            }
            //time needed
            out.print("Estimate how long this task might take you (in minutes): ");//we can offer a time using our clock lab we did in cs3
            d = s.nextInt();
            tasks.add(new Task(b, priority, d));
        }
        
        //Option 2
        else if(a== 2){
            if (tasks.isEmpty()){
                out.println("GUESS WHAT!! you got no tasks");
            }
            else{
                for(Task task : tasks){
                    out.println(task.toString());
                }
            }
        }
        
        //Option 3
        else if(a == 3){
            int length = tasks.size();
            if(tasks.isEmpty()){
                out.println("You have no tasks to change:))))");
            }
            else{
                out.println("Pick the task number: ");
            }
        }
        } while(!tasks.isEmpty());
        System.out.println("Hello World");

        //Branch test

        //aditi_dev test
    }
}
