package br.com.petmelhoramigo.pets.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.petmelhoramigo.pets.model.Pets;

public interface PetRepository extends MongoRepository <Pets, String>{
      
}
