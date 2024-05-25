package ru.sber.test.app.sbertestapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sber.test.app.sbertestapp.model.Genre;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class OrderDTO extends GenericDTO {

    private String orderNumber;

    private Set<Long> MovieIds;
}
