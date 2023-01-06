package com.example.demo.testForGetAllUsersMethod.repo;

import com.example.demo.testForGetAllUsersMethod.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
