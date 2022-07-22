package domain;

public class Boyaki {
	private Integer id;
	private String upper;
	private String middle;
	private String lower;
	private Integer user_id;
	private Boolean isSecret;

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

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Boolean getIsSecret() {
		return isSecret;
	}

	public void setIsSecret(Boolean isSecret) {
		this.isSecret = isSecret;
	}

}
