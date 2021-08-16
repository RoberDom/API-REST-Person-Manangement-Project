package com.dio.personAPI.entity;

import lombok.AllArgsConstructor; //Importação do LOMBOK para criar construtores
import lombok.Builder; //Define um padrão para construção de objetos
import lombok.Data; //Importação do LOMBOK para criar métodos Getters, Setters, ToString e HashCode
import lombok.NoArgsConstructor; //Importação do LOMBOK para criar construtores vazios
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity //Mapeamento para definir a classe como uma entidade no Banco de Dados

public class Pessoas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotações para gerar ID e o tipo de estratégia nessa geração
    private Long ID;

    @Column(nullable = false) //Definição que essa coluna não aceita valores nulos
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true) //Essa coluna não aceita nulo e o valor de CPF deve ser único
    private long cpf;

    private LocalDate aniversario;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade ={CascadeType.ALL} ) //Relação entre tabelas
    private List<Telefone> telefones;

}
