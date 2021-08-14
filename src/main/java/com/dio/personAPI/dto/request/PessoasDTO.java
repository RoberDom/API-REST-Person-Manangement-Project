package com.dio.personAPI.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder



public class PessoasDTO {


        private Long ID;

        @NotEmpty
        private String nome;

        @NotEmpty
        private String sobrenome;

        @NotEmpty
        @CPF // só aceita o padrao numerico de um cpf
        private long cpf;


        private LocalDate aniversario;

        @NotEmpty
        @Valid
        private List<TelefoneDTO> telefones;

    }
