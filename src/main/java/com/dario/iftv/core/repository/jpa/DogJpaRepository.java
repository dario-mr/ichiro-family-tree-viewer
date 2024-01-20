package com.dario.iftv.core.repository.jpa;

import com.dario.iftv.core.repository.jpa.entity.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DogJpaRepository extends JpaRepository<DogEntity, Long> {

    Optional<DogEntity> findByName(String name);
}
