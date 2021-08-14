package com.dio.personAPI.entity;
import com.dio.personAPI.enums.PhoneType;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType tipo;

    @Column(nullable = false)
    private String numero;
}
