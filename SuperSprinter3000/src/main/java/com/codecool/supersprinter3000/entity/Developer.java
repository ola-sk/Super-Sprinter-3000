package com.codecool.supersprinter3000.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Developer {
    @Id
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    @EqualsAndHashCode.Include
    private String email;
    @OneToMany(mappedBy = "developer", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<UserStory> userStories = new HashSet<>();

    public Developer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
