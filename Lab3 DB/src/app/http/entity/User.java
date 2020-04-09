package app.http.entity;
import app.http.annotation.*;

@Table("user")
public class User {

	@Column("id")
    private int id;

	@Column("username")
    private String username;
    
	@Column("age")
    private int age;

    @Column("email")
    private String email;

    @Column("telephone")
    private String telephone;

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
