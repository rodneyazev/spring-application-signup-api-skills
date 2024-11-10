package com.application.signup.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.signup.api.model.Roles;
import com.application.signup.api.model.RoleEnum;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

	Optional<Roles> findByName(RoleEnum roleEnum);
}