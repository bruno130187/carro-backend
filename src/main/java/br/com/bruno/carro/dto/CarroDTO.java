package br.com.bruno.carro.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "nome", "marca", "modelo"})
public class CarroDTO {

    private Long id;
    private String nome;
    private String marca;
    private String modelo;

}
