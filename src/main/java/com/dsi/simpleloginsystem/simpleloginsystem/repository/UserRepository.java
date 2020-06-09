package com.dsi.simpleloginsystem.simpleloginsystem.repository;

import com.dsi.simpleloginsystem.simpleloginsystem.model.CurrentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CurrentUser, Long> {
}
