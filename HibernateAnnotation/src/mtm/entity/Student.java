package mtm.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="mtm_student")
public class Student implements Serializable{

	
	private int sid; //学号
	private String sname; // 姓名
	private String gender; // 性别
	private Set<Teacher> teachers; //教师 多对多关系
	
	@Id
	@Column(name="SID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	@Column(name="SNAME",length=40)
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Column(name="GENDER",length=10)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@ManyToMany
	@JoinTable(name="teachers_students",
						 joinColumns={@JoinColumn(name="SID")},
						 inverseJoinColumns={@JoinColumn(name="TID")})
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
	
}
