package com.dario.iftv.core.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "DOG", schema = "ICHIRO")
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class DogEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "dog_id")
    private Long id;

    @Column(name = "dog_name")
    private String name;

    @Column(name = "dog_gender")
    private String gender;

    @Column(name = "dog_country")
    private String country;

    @Column(name = "dog_date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "dog_color")
    private String color;

    @Column(name = "dog_image_url")
    private String imageUrl;

    @Column(name = "dog_profile_url")
    private String profileUrl;

    @Column(name = "dog_generation")
    private Integer generation;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "dog_mother_id", referencedColumnName = "dog_id")
    private DogEntity mother;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "dog_father_id", referencedColumnName = "dog_id")
    private DogEntity father;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DogEntity that = (DogEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
