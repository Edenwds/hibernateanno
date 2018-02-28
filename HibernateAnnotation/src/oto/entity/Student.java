package oto.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="oto_student")
public class Student implements Serializable{

	
	private int sid; //学号
	private String major; //专业
	private IdCard idcard; //身份证  一对一关系
	
	
	@Id
	@Column(name="SID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	@Column(name="MAJOR",length=15)
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CARDNUM",unique=true)
	public IdCard getIdcard() {
		return idcard;
	}
	public void setIdcard(IdCard idcard) {
		this.idcard = idcard;
	}
	
	
}
