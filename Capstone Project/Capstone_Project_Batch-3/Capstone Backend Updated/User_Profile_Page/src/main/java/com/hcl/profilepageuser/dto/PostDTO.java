package com.hcl.profilepageuser.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

@Builder
@Table(name="posts")
public class PostDTO{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int userId;
	public String userName;
	public String postName;
    private LocalDateTime date;
	public String image;
	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostDTO(int userId, String userName, String postName, LocalDateTime date, String image) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.postName = postName;
		this.date = date;
		this.image = image;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "PostDTO [userId=" + userId + ", userName=" + userName + ", postName=" + postName + ", date=" + date
				+ ", image=" + image + "]";
	}
	
	
}
