package com.application.signup.api.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@ControllerAdvice
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table(name="USERS")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true, length = 255)
    private String email;
	
	@Column(nullable = false, unique=true, length = 255)
    private String username;
	
	@Column(length = 255)
	private String phone_number;
    
    @Column(nullable = false, length = 255)
    private String password;
    
    @Column(length = 50)
    private String create_user;
    
    @Column(length = 50)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp create_date;
    
    @Column(length = 50)
    private String update_user;
    
    @Column(length = 50)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp update_date;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Roles role;
    
    @PrePersist
    protected void onCreate() {
    	create_user = "SYSTEM";
    	create_date = Timestamp.valueOf(LocalDateTime.now());
    }
    
    @PreUpdate
    protected void onUpdate() {    	
    	update_user = System.getenv("USERNAME");
    	update_date = Timestamp.valueOf(LocalDateTime.now());
    }
    
}
