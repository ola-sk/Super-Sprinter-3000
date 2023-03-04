package com.codecool.supersprinter3000.repository;

import com.codecool.supersprinter3000.entity.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, UUID> {

    List<UserStory> findAllByOrderById(UUID id);
    //    @Query("SELECT us FROM UserStory us ORDER BY :arg")
    //    List<UserStory> findAllBySomething(String arg);
}
