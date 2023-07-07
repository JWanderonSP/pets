package br.com.petmelhoramigo.pets.service;

import java.util.List;
import java.util.Optional;

import br.com.petmelhoramigo.pets.shared.PetDto;
import br.com.petmelhoramigo.pets.shared.PetsListagemDto;

public interface PetService {
   List <PetDto> obterTodos();
   Optional <PetsListagemDto> obterPorId(String id);
    PetsListagemDto cadastrar (PetsListagemDto dto);
    PetsListagemDto atualizarPorId (String id, PetsListagemDto dto);
    void excluir(String id);
   

   }
    

