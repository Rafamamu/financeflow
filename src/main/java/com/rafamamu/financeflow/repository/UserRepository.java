package com.rafamamu.financeflow.repository;

import com.rafamamu.financeflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
