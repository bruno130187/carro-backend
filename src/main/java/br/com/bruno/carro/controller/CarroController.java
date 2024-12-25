package br.com.bruno.carro.controller;

import br.com.bruno.carro.dto.CarroDTO;
import br.com.bruno.carro.dto.ResponseDTO;
import br.com.bruno.carro.entity.Carro;
import br.com.bruno.carro.service.CarroService;
import br.com.bruno.carro.util.Message;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/carro")
public class CarroController {

    private ModelMapper mapper = new ModelMapper();

    @Autowired
    private CarroService carroService;

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        try {
            Carro carro = carroService.findById(id);
            if (carro.getId() != null) {
                CarroDTO carroDTO = mapper.map(carro, CarroDTO.class);
                return new ResponseEntity<>(carroDTO, HttpStatus.OK);
            }
            return new ResponseEntity<>(new ResponseDTO(String.format("%s", Message.CARRO_NAO_ENCONTRADO)), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity getAll(){
        return new ResponseEntity<>(carroService.findAllSortedByNome(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity save(@Valid @RequestBody CarroDTO carroDTO){
        try {
            Carro carro = mapper.map(carroDTO, Carro.class);
            Carro carroSalvo = carroService.save(carro);
            return new ResponseEntity<>(carroSalvo, HttpStatus.CREATED);

        }catch (Exception error){
            return new ResponseEntity<>(new ResponseDTO(error.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity put(@PathVariable Long id, @RequestBody CarroDTO carroDTO) {
        try {
            Carro carroEncontrado = carroService.findById(id);
            if (carroEncontrado.getId() != null) {
                mapper.typeMap(CarroDTO.class, Carro.class).addMappings(mapper -> mapper.skip(Carro::setId));
                mapper.map(carroDTO, carroEncontrado);
                carroService.save(carroEncontrado);
                return new ResponseEntity<>(new ResponseDTO(String.format("%s", Message.CARRO_ATUALIZADO_COM_SUCESSO)), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ResponseDTO(String.format("%s", Message.CARRO_NAO_ENCONTRADO)), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            Carro carro = carroService.findById(id);
            if (carro.getId() != null) {
                carroService.deleteById(id);
                return new ResponseEntity<>(new ResponseDTO(String.format("%s", Message.CARRO_DELETADO_COM_SUCESSO)), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ResponseDTO(String.format("%s", Message.CARRO_NAO_ENCONTRADO)), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(String.format("%s %s", Message.ERRO_AO_DELETAR_CARRO, e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
