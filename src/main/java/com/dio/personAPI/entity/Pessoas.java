package com.dio.personAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data // Importação do LOMBOK para criar metodos Getttes, Setters, ToString e HashCode
@AllArgsConstructor // Importação do LOMBOK para criar construtores
@NoArgsConstructor //Importação do LOMBOK para criar construtores vazios
@Builder // Define um padrao para construção de objetos
@Entity // Mapeamento para definir a classe como uma entidade no Banco de Dados

public class Pessoas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotações para gerar ID e o tipo de estrategia nessa geração
    private Long ID;

    @Column(nullable = false) //Definição que essa coluna não aceita valores nulos
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true) // Essa coluna não aceita nulo e o valor de CPF deve ser unico
    private long cpf;


    private LocalDate aniversario;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade ={CascadeType.ALL} ) // Relação entre tabelas
    private List<Telefone> telefones;

}
