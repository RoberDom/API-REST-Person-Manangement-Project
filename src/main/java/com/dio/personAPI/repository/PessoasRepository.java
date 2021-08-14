package com.dio.personAPI.repository;

import com.dio.personAPI.entity.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<Pessoas, Long> {
}
