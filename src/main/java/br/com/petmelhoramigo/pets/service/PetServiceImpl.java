package br.com.petmelhoramigo.pets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petmelhoramigo.pets.model.Pets;
import br.com.petmelhoramigo.pets.repository.PetRepository;
import br.com.petmelhoramigo.pets.shared.PetDto;
import br.com.petmelhoramigo.pets.shared.PetsListagemDto;
@Service
public class PetServiceImpl implements PetService {
  @Autowired
    private PetRepository repositorio;
   
    @Override
    public List<PetDto> obterTodos() {
       return repositorio.findAll()
       .stream()
       .map(p -> new PetDto(p.getId(),p.getNome(),p.getProcedimentos()))
       .toList();
    }
    @Override
    public Optional<PetsListagemDto> obterPorId(String id) {
       Optional<Pets> pets=repositorio.findById(id);
       if(pets.isPresent()){
        return Optional.of(new PetsListagemDto(pets.get().getId(), pets.get().getNome() ,pets.get().getProcedimentos(), pets.get().getAnoNascimento(), pets.get().getRaca(),pets.get().getVacinado()));
       }else{
        return Optional.empty();
       }
    }

    @Override
    public PetsListagemDto cadastrar (PetsListagemDto dto) {
        Pets pets= new Pets(dto);
         repositorio.save(pets);
         return new PetsListagemDto (pets.getId(),
         pets.getNome(),
         pets.getProcedimentos(),
         pets.getAnoNascimento(), 
         pets.getRaca(),
         pets.getVacinado()
         );
    }

    @Override
    public PetsListagemDto atualizarPorId (String id, PetsListagemDto dto) {
        Pets pets = repositorio.findById(id).orElse(null);
        if(pets!=null){
            Pets novopet=new Pets(dto);
            novopet.setId(id);
            repositorio.save(novopet);
            return new PetsListagemDto(novopet.getId(),
            novopet.getNome(),
            novopet.getProcedimentos(),
            novopet.getAnoNascimento(),
            novopet.getRaca(),
            novopet.getVacinado());
    }
        return dto;
}


    @Override
    public void excluir(String id) {
        repositorio.deleteById(id);
    }

    
    }

