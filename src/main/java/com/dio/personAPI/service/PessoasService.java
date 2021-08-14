package com.dio.personAPI.service;

import com.dio.personAPI.dto.request.PessoasDTO;
import com.dio.personAPI.dto.response.MessageResponseDTO;
import com.dio.personAPI.entity.Pessoas;
import com.dio.personAPI.exception.PersonNotFoundException;
import com.dio.personAPI.mapper.PessoasMapper;
import com.dio.personAPI.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PessoasService {

    private PessoasRepository pessoasRepository;

    @Autowired
    public PessoasService(PessoasRepository pessoasRepository) {
        this.pessoasRepository = pessoasRepository;
    }

    private final PessoasMapper pessoasMapper = PessoasMapper.INSTANCE;


    public MessageResponseDTO criarPessoas(PessoasDTO pessoasDTO) {
        Pessoas personToSave = pessoasMapper.toModel(pessoasDTO);

        Pessoas savedperson = pessoasRepository.save(personToSave);
        return createMessageResponse ("Criado com sucesso!");
    }

    public List<PessoasDTO> listall() {
        List<Pessoas> listarPessoas = pessoasRepository.findAll();
        return listarPessoas.stream()
                .map(pessoasMapper::toDTO)
                .collect(Collectors.toList());
    }


    public PessoasDTO getPessoasId(Long id) throws PersonNotFoundException {
        Pessoas pessoas = verifyIfExists (id);
        return pessoasMapper.toDTO(pessoas);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists (id);
        pessoasRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PessoasDTO pessoasDTO) throws PersonNotFoundException {
        verifyIfExists (id);
        Pessoas personToUpdate = pessoasMapper.toModel(pessoasDTO);

        Pessoas updateperson = pessoasRepository.save(personToUpdate);

        return createMessageResponse ("Atualizado com sucesso!");

    }

    private MessageResponseDTO createMessageResponse(String s) {
        return MessageResponseDTO
                .builder ()
                .mensagem (s)
                .build ();
    }
    private Pessoas verifyIfExists(Long id) throws PersonNotFoundException {
        return pessoasRepository.findById (id)
                .orElseThrow (() -> new PersonNotFoundException (id));
    }
}

