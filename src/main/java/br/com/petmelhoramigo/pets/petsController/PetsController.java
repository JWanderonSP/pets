package br.com.petmelhoramigo.pets.petsController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.petmelhoramigo.pets.service.PetService;
import br.com.petmelhoramigo.pets.shared.PetDto;
import br.com.petmelhoramigo.pets.shared.PetsListagemDto;

@RestController
@RequestMapping("/petmelhoramigo")

public class PetsController {
    @Autowired
    private PetService servico;
    @GetMapping
    private ResponseEntity<List<PetDto>> obterPets(){
        return new ResponseEntity<>(servico.obterTodos(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    private ResponseEntity<PetsListagemDto>obterPorId(@PathVariable String id){
    Optional<PetsListagemDto> pets=servico.obterPorId(id);
         if(pets.isPresent()){
            return new ResponseEntity<>(pets.get(),HttpStatus.OK);
         }
         else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }
    
    @PostMapping
    private ResponseEntity<PetsListagemDto> cadastrar(@RequestBody @Valid PetsListagemDto pets) {
        return new ResponseEntity<>(servico.cadastrar(pets),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirPetPorId (@PathVariable String id){
        servico.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    private ResponseEntity<PetsListagemDto> atualizar(@PathVariable String id, @RequestBody @Valid PetsListagemDto pets){
        PetsListagemDto petatualizado= servico.atualizarPorId(id, pets);
        if(petatualizado!=null){
            return new ResponseEntity<>(petatualizado,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
    
    

    }


    

