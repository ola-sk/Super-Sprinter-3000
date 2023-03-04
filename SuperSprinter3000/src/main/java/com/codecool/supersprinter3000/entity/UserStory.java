package com.codecool.supersprinter3000.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
//@NoArgsConstructor
@Entity
//@Table(name = "user_stories")
public class UserStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 50, message = "Title must be between 5 and 50 characters")
    private String title;
    @NotBlank(message = "Cannot be empty")
    private String story;
//    @Column(name = "acceptance_criteria")
    private String acceptanceCriteria;
    @NotNull(message = "Cannot be empty")
    @DecimalMin(value = "0.5", message = "min 0.5")
    @DecimalMax(value = "40.0", message = "Max 40.0")
    private Double estimation;
    private Integer businessValue = 100;
    @Enumerated(EnumType.STRING)
    private UserStoryStatus userStoryStatus;
}
