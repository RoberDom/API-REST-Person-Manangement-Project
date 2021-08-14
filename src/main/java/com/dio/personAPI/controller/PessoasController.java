package com.dio.personAPI.controller;

import com.dio.personAPI.dto.request.PessoasDTO;
import com.dio.personAPI.dto.response.MessageResponseDTO;
import com.dio.personAPI.exception.PersonNotFoundException;
import com.dio.personAPI.service.PessoasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/pessoas")


public class PessoasController {


  private PessoasService pessoasService;

  @Autowired
  public PessoasController(PessoasService pessoasService) {
        this.pessoasService = pessoasService;
    }


    @PostMapping
    public MessageResponseDTO criarPessoas(@RequestBody @Valid PessoasDTO pessoasDTO){
        return pessoasService.criarPessoas(pessoasDTO);
    }

    @GetMapping
    public List<PessoasDTO> listall(){
      return pessoasService.listall();
  }

  @GetMapping("/{id}")
  public PessoasDTO getPessoasId(@PathVariable Long id) throws PersonNotFoundException {
    return pessoasService.getPessoasId(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
    pessoasService.delete(id);
  }

@PutMapping("/{id}")
  public MessageResponseDTO updateById (@PathVariable Long id, @RequestBody @Valid PessoasDTO pessoasDTO) throws PersonNotFoundException {
  return pessoasService.updateById(id, pessoasDTO);
}


}
