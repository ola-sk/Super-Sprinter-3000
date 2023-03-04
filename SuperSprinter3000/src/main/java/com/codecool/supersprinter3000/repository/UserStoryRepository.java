package com.codecool.supersprinter3000.repository;

import com.codecool.supersprinter3000.entity.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

    List<UserStory> findAllByOrderById();
}
