package elbar;

import java.io.*;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.*;



@XmlRootElement(name ="user")
@Entity
@Table(name ="tbl_students")
public class User implements Serializable {
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "password")
	private String password;
	@Column(name = "fname")
	private String fname;
	@Column(name = "lname")
	private String lname;
	@Column(name = "birth_date")
	private String birthdate ;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "department")
	private String department ;
	@Column(name = "subjects")
	private int subjectnum;
	@Column(name = "degree")
	private double degree;
	@Column(name = "grade")
	private String grade;
	@Column(name = "start_date")
	private String startdate ;
	@Column(name = "end_date")
	private String enddate ;
	@Column(name = "paid")
	private boolean paid ;

	public User() {
	}

	public User(int id, String password, String fname, String lname, String birthdate, String phone, String email,
			String department, int subjectnum, double degree, String grade, String startdate, String enddate,
			boolean paid) {
		super();
		this.id = id;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.birthdate = birthdate;
		this.phone = phone;
		this.email = email;
		this.department = department;
		this.subjectnum = subjectnum;
		this.degree = degree;
		this.grade = grade;
		this.startdate = startdate;
		this.enddate = enddate;
		this.paid = paid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSubjectnum() {
		return subjectnum;
	}

	public void setSubjectnum(int subjectnum) {
		this.subjectnum = subjectnum;
	}

	public double getDegree() {
		return degree;
	}

	public void setDegree(double degree) {
		this.degree = degree;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	
}
