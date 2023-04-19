public class Garbage {

	    private String garbageName;
	    private String garbageType;
	    private int amount;

		// Constructor for the Garbage class
	    public Garbage(String garbageName, String garbageType, int amount) {
	        this.garbageName = garbageName;
	        this.garbageType = garbageType;
	        this.amount = amount;
	    }

		// Getter and setter methods for class instances
	    public String getGarbageName() {
	        return garbageName;
	    }

	    public void setGarbageName(String garbageName) {
	        this.garbageName = garbageName;
	    }

	    public String getGarbageType() {
	        return garbageType;
	    }

	    public void setGarbageType(String garbageType) {
	        this.garbageType = garbageType;
	    }

	    public int getAmount() {
	        return amount;
	    }

	    public void setAmount(int amount) {
	        this.amount = amount;
	    }

		// This is the overridden toString() method
		// It returns the garbage's name, type, and amount in a String format
	    @Override
	    public String toString() {
	        return garbageName + "," + garbageType +"," + amount;
	    }

		// This is the overridden equals() method
		// It checks if two Garbage objects are equal based on their name, type, and amount
	@Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (!(obj instanceof Garbage)) {
	            return false;
	        }
	        Garbage other = (Garbage) obj;
	        return this.garbageName.equals(other.garbageName)
	                && this.garbageType.equals(other.garbageType)
	                && this.amount == other.amount;
	    }

	


}
