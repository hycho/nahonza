package com.bigcho.mps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bigcho.mps.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
