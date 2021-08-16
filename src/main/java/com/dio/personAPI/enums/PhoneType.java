package com.dio.personAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum PhoneType {

    Residencial("Residencial"),
    Comercial ("Comercial"),
    Celular ("Celular");

    private final String descricao;




}
