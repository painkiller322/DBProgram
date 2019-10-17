package model;

public class Model {

	private int id_num;
	private String name;
	private String depart;
	private String salary;
	private String hire_date;

	public int getId_num() {
		return id_num;
	}

	public void setId_num(int id_num) {
		this.id_num = id_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	@Override
	public String toString() {
		return "Model [id_num=" + id_num + ", name=" + name + ", depart=" + depart + ", salary=" + salary
				+ ", hire_date=" + hire_date + "]";
	}

}
