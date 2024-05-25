package ru.sber.test.app.sbertestapp.dto;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public abstract class GenericDTO {
    private Long id;

//    private LocalDateTime createdWhen;
//    private String createdBy;
//    private boolean isDeleted;
//    private LocalDateTime deletedWhen;
//    private String deletedBy;
}
