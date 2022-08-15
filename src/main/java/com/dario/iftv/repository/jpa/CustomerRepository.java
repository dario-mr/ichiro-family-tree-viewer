package com.dario.iftv.repository.jpa;

import com.dario.iftv.repository.jpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByLastNameStartsWithIgnoreCase(String lastName);
}
