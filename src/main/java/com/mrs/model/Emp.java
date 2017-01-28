package com.mrs.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the emp database table.
 * 
 */
@Entity
@Table(name="emp")
public class Emp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empid;

	private BigInteger aatharnumber;

	private String adress1;

	private String adress2;

	@Temporal(TemporalType.DATE)
	private Date createdtime;

	private String district;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Temporal(TemporalType.DATE)
	private Date doj;

	@Temporal(TemporalType.DATE)
	private Date dor;

	private String email;

	private String firstname;

	private String lastname;

	@Temporal(TemporalType.DATE)
	private Date modifiedtime;

	private String pancard;

	private String phone;

	private String pincode;

	private String state;

	//bi-directional many-to-one association to Nominee
	@OneToMany  //(mappedBy="emp")
	@JoinColumn(name="empid")
	private List<Nominee> nominees;

	public Emp() {
	}

	public int getEmpid() {
		return this.empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public BigInteger getAatharnumber() {
		return this.aatharnumber;
	}

	public void setAatharnumber(BigInteger aatharnumber) {
		this.aatharnumber = aatharnumber;
	}

	public String getAdress1() {
		return this.adress1;
	}

	public void setAdress1(String adress1) {
		this.adress1 = adress1;
	}

	public String getAdress2() {
		return this.adress2;
	}

	public void setAdress2(String adress2) {
		this.adress2 = adress2;
	}

	public Date getCreatedtime() {
		return this.createdtime ==null ? new Date() : this.createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return this.doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Date getDor() {
		return this.dor;
	}

	public void setDor(Date dor) {
		this.dor = dor;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getModifiedtime() {
		return this.modifiedtime ==null ? new Date() : this.modifiedtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public String getPancard() {
		return this.pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Nominee> getNominees() {
		return this.nominees;
	}

	public void setNominees(List<Nominee> nominees) {
		this.nominees = nominees;
	}

	/*public Nominee addNominee(Nominee nominee) {
		getNominees().add(nominee);
		nominee.setEmp(this);

		return nominee;
	}

	public Nominee removeNominee(Nominee nominee) {
		getNominees().remove(nominee);
		nominee.setEmp(null);

		return nominee;
	}
*/
}