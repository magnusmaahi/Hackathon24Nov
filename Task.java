public class Task{
	private String description;
	private int priority;
	private int timeNeeded;
	
	public Task(String d, int p, int t){
		description = d;
		isCompleted = false;
		priority = p;
		timeNeeded = t;
	}
	

	//set method for the status
	public void setCompleted(boolean status){
		this.isCompleted = status;
	}
	//getter methods
	public boolean getStatus(){
		return isCompleted;
	}
	
	public Strring getPriority(){
		if (priority == 1) {
			return "Right NOW!";
		}
		else if (priority == 2) {
			return "ASAP";
		} else {
			return "End of day";
		}
	}
	
	public boolean getTime(){
		return timeNeeded;
	}
  
	public String toString(){
		return String.format("          Description.          |  Priority.  | Time needed\n%-35s| %-9s| %-14d| %d mins", description, priority, timeNeeded);
	}
}
