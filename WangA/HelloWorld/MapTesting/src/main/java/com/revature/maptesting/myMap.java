package main.java.com.revature.maptesting;

public class myMap  {
	String[] originKey;
	int[] originValue;
	String[] updateKey;
	int[] updateValue;
	int remove;
	int foundValue;
	int foundKeyIndex;
	
	public myMap() {
		super();
	}
	
	public void addKey(String key, int value) {
		String[] updateKey = new String[originKey.length + 1];
		int[] updateValue = new int[originValue.length + 1]; //increasing size of array
		for (int x = 0; x < originKey.length; x++) {
			updateKey[x] = originKey[x];
			updateValue[x] = originValue[x]; //copy values to new array
		}
		updateKey[updateKey.length] = key;
		updateValue[updateValue.length] = value; //adding new values to new array	
	}
	
	public void removeKey(String key) {
		String[] updateKey = new String[originKey.length - 1];
		int[] updateValue = new int[originValue.length - 1]; //decreasing size of array
		int remove = retrieveKeyIndex(key); //get index of key to remove
		for (int x = 0; x < updateKey.length; x++) {
			if (x >= remove) {
				updateKey[x] = originKey[x+1];
				updateValue[x] = originValue[x+1];
			} else {
				System.out.println("Key not found.");	
			}
		}	
	}
	
	public int retrieveValue(String key) {
		for (int x = 0; x < originKey.length; x++) {
			if (originKey[x].equals(key)) {
				foundValue = originValue[x];				
			} else {
				System.out.println("Value not found.");
			}
		}
		return foundValue;
	}
	
	public int retrieveKeyIndex(String key) {
		for (int x = 0; x < originKey.length; x++) {
			if (originKey[x].equals(key)) {
				return x;
			} else {
				System.out.println("Key index not found.");
			}
		}
		return foundKeyIndex;
	}
}
