public class Task{
	private String description;
	private boolean isCompleted;
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
	
	public int getPriority(){
		return this.priority;
	}
	
	public int getTime(){
		return timeNeeded;
	}
 
	public String toString(){
		return String.format("%-22s| %-9s| %d mins", description, priority, timeNeeded);
	}
}
