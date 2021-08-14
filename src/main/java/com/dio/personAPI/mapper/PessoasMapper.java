package com.dio.personAPI.mapper;

import com.dio.personAPI.dto.request.PessoasDTO;
import com.dio.personAPI.entity.Pessoas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PessoasMapper {

    PessoasMapper INSTANCE = Mappers.getMapper(PessoasMapper.class);


    @Mapping(target = "aniversario", source = "aniversario", dateFormat = "dd-MM-yyyy")
   Pessoas toModel (PessoasDTO pessoasDTO);
    PessoasDTO toDTO (Pessoas pessoas);



}
