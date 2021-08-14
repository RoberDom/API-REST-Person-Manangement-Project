package com.dio.personAPI.dto.request;

import com.dio.personAPI.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TelefoneDTO {


        private Long Id;


        @Enumerated(EnumType.STRING)
        private PhoneType tipo;

        @NotEmpty // o campo não pode ser vazio
        @Size(min=13, max=14) //limita o tamanho de numeros inseridos no campo
        private String numero;
}
