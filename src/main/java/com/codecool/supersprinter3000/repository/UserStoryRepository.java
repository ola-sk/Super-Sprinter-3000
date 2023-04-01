package com.codecool.supersprinter3000.repository;

import com.codecool.supersprinter3000.entity.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, UUID> {

    List<UserStory> findAllByOrderById();

    @Query("SELECT DISTINCT us FROM UserStory us LEFT JOIN FETCH us.developers")
    List<UserStory> findAllBy();

    @Query("SELECT us FROM UserStory us LEFT JOIN FETCH us.developers WHERE us.id = :id")
    Optional<UserStory> findOneById(UUID id);
}
