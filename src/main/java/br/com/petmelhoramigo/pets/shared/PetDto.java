package br.com.petmelhoramigo.pets.shared;

import java.util.List;

public record PetDto(String id,String nome, List<String> procedimentos) {

}

