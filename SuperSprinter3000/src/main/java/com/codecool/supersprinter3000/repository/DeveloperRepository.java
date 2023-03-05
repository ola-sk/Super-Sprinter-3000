package com.codecool.supersprinter3000.repository;

import com.codecool.supersprinter3000.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, UUID> {

    @Query("SELECT DISTINCT d FROM Developer d LEFT JOIN FETCH d.userStories")
    List<Developer> findAllBy();

    @Query("SELECT d FROM Developer d LEFT JOIN FETCH d.userStories WHERE d.id = :id")
    Optional<Developer> findOneById(UUID id);
}
