package ua.prog.java.lesson10;

public class ObjectTwoRepetitions {
	private String name;
	private Integer value;
	private boolean isHero = true;

	public ObjectTwoRepetitions() {
		super();
	}

	public ObjectTwoRepetitions(String name, Integer value, boolean isHero) {
		super();
		this.name = name;
		this.value = value;
		this.isHero = isHero;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public boolean isHero() {
		return isHero;
	}

	public void setHero(boolean isHero) {
		this.isHero = isHero;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", value=" + value + ", isHero=" + isHero + "]";
	}

}
