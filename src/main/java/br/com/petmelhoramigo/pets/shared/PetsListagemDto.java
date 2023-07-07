package br.com.petmelhoramigo.pets.shared;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.petmelhoramigo.pets.model.Vacinado;

public record PetsListagemDto(String id,

@NotEmpty(message="Seu pet tem de ter um nome. Por favor digite o nome do pet!")
String nome,
@NotEmpty(message="Caro usuário é necessário pelo menos um procedimento.")
List<String> procedimentos,

@Positive(message="Por favor digite o ano de nascimento")
@Size(min=4,max=4,message="O ano de nascimento deve ter 4 digitos")
int anoNascimento,
@NotEmpty(message="Qual a raça de seu bichinho?")
String raca,
@NotNull(message="Esse campo deve ser TRUE OU FALSE.")
Vacinado vacinado

)

 {

   





 
   
    
}
