package cn.tri.web.pojo;

public class Student {
	private int id ;
	private String name ;
	private String age ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Student(int id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
