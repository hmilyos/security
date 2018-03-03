/**
 * 
 */
package com.osm.dto;

/**
 * @author ouShiming
 *
 */
public class Student {
	
	private Integer id;
	private String name;
	private Integer age;
	private byte[] pic;
	private String remark;
	
	//private Address address;
	
	//private Grade grade;


	public byte[] getPic() {
		return pic;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", remark=" + remark + "]";
	}



	public void setPic(byte[] pic) {
		this.pic = pic;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}

}
