import java.util.*;
import static java.lang.System.out;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Task> toDo = new ArrayList<>();
		ArrayList<Task> done = new ArrayList<>();
		out.println("---- TO-DO List ----");
		out.println("\nCreate your holiday to-do list:");
		int opt, pN, t;
		String tN;

		do {
			// Main menu
			out.println("1. Create a new task\n2. Print my task list(s)\n3. Exit");
			out.print("Enter choice: ");
			opt = s.nextInt();
			s.nextLine(); // Consume the leftover newline
			System.out.println();

			// Option 1: Create a new task
			if (opt == 1) {
				out.print("Task name? (Character limit 40): ");
				tN = s.nextLine();
				while (tN.length() > 40) {
					out.println("\nOops!! You exceeded the character limit. Shorten PLS");
					out.print("Task name? (Character limit 40): ");
					tN = s.nextLine();
				}

				// Priority
				out.print("Pick your priority (1- RIGHT NOW! 2 - ASAP 3 - End of Day): ");
				pN = s.nextInt();

				// Time needed
				out.print("Estimate how long this task might take you (in hours and minutes): ");
				int h = s.nextInt();
				int m = s.nextInt();
				t = time(h, m);

				// Add the task to the to-do list
				toDo.add(new Task(tN, pN, t));
				out.println();
			}

			// Option 2: Print task lists
			else if (opt == 2) {
				if (toDo.isEmpty()) {
					out.println("GUESS WHAT!! you got no tasks");
				} else {
					out.println("TO-DO List:\nDescription           | Priority | Time needed");
					printTasks(toDo);
				}
				out.println();
			}

		} while (opt != 3);

		out.println("Have a great day!");
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
		for (int i = 1; i <= 3; i++) { // Only priorities 1-3 are supported
			ArrayList<Task> taskList = map.get(i); // Get the list for priority i

			if (taskList != null) { // Check to avoid NullPointerException
				for (Task t : taskList) {
					System.out.println(t.toString());
				}
			}
		} // End of printing tasks
	}
}
