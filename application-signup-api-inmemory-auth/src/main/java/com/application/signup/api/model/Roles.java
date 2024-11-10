package com.application.signup.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table(name="ROLES")
public class Roles {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    @Column(unique = true, nullable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;
    
    @Column
    private String description;

}
