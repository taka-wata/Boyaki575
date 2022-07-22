package domain;

import java.util.Date;

public class Boyaki {
	private Integer id;
	private String upper;
	private String middle;
	private String lower;
	private Integer userId;
	private String userName;
	private Boolean isSecret;
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUpper() {
		return upper;
	}

	public void setUpper(String upper) {
		this.upper = upper;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLower() {
		return lower;
	}

	public void setLower(String lower) {
		this.lower = lower;
	}

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getIsSecret() {
		return isSecret;
	}

	public void setIsSecret(Boolean isSecret) {
		this.isSecret = isSecret;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
