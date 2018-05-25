package ua.prog.java.lesson10;

import java.util.HashMap;
import java.util.Map;

public class Repetitions {
	private Object[] objectsArray;
	private Map<Object, Integer> objectsMap = new HashMap<>();

	public Repetitions() {

	}

	public Repetitions(Object[] objectsArray) {
		super();
		this.objectsArray = objectsArray;
	}

	public Object[] getObjectsArray() {
		return objectsArray;
	}

	public void setObjectsArray(Object[] objectsArray) {
		this.objectsArray = objectsArray;
	}

	public Map<Object, Integer> getObjectsMap() {
		return objectsMap;
	}

	public void countRepetitionsNumber() {
		for (Object definedObject : objectsArray) {
			if (objectsMap.containsKey(definedObject)) {
				Integer value = objectsMap.get(definedObject) + 1;
				objectsMap.put(definedObject, value);
			} else {
				objectsMap.put(definedObject, 1);
			}
		}
	}

	@Override
	public String toString() {
		String objectsMapAsString = "";
		for (Object key : objectsMap.keySet()) {
			objectsMapAsString += "Object: " + key.toString() + " - Quantity: " + objectsMap.get(key) + "\n";
		}
		return "\nResult:\n" + objectsMapAsString;
	}

}
