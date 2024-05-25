package ru.sber.test.app.sbertestapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@MappedSuperclass
public class GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
    @Column(name = "id", nullable = false)
    private Long id;

//    @Column(name = "created_when")
//    private LocalDateTime createdWhen;
//
//    @Column(name = "created_by")
//    private String createdBy;
//
//
//    @Column(name = "is_deleted", columnDefinition = "boolean default false")
//    private boolean isDeleted;
//
//    @Column(name = "deleted_when")
//    private LocalDateTime deletedWhen;
//
//    @Column(name = "deleted_by")
//    private String deletedBy;
}
