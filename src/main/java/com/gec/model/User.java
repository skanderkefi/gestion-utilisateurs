package com.gec.model;
import javax.persistence.Column;   
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	private Long id;
	private String name;
	private String matricule;
	private String email;
	private String last_login_ip;
	private String password;
	private String profil;
	private int direction;
	private int isactive;
	private String image;
	private String phone;
	private String created_by;
	
	
	
	
	public User(Long id, String name, String matricule, String email, String last_login_ip, String password,
			String profil, int direction, int isactive, String image, String phone, String created_by,
			Long imageId, String imageName, String imageType, byte[] picByte) {
		super();
		this.id = id;
		this.name = name;
		this.matricule = matricule;
		this.email = email;
		this.last_login_ip = last_login_ip;
		this.password = password;
		this.profil = profil;
		this.direction = direction;
		this.isactive = isactive;
		this.image = image;
		this.phone = phone;
		this.created_by = created_by;
	
	}
	
	public User( String name, String matricule, String email, String last_login_ip, String password,
			String profil, int direction, int isactive, String image, String phone, String created_by) {
		super();
		this.name = name;
		this.matricule = matricule;
		this.email = email;
		this.last_login_ip = last_login_ip;
		this.password = password;
		this.profil = profil;
		this.direction = direction;
		this.isactive = isactive;
		this.image = image;
		this.phone = phone;
		this.created_by = created_by;
	}

	public User() {
	}
	
	public User(Long id) {
		this.id = id;
	
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "matricule")
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "last_login_ip")
	public String getLast_login_ip() {
		return last_login_ip;
	}

	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "profil")
	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	@Column(name = "direction")
	public int getDirection() {
		return direction;
	}

	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Column(name = "isactive")
	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	@Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "created_by")
	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}


	
	


}
