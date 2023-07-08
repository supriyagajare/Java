package OneToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;
	
	private String name;
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foreignKey")
	private Address adrs;
	public Address getAdrs() {
		return adrs;
	}
	public void setAdrs(Address adrs) {
		this.adrs = adrs;
	}
}
