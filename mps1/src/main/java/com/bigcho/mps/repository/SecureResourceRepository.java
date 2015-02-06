package com.bigcho.mps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bigcho.mps.entity.SecureResource;


@Repository
public interface SecureResourceRepository extends JpaRepository<SecureResource, Long> {
}
