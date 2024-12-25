package br.com.bruno.carro.service;

import br.com.bruno.carro.dto.CarroDTO;
import br.com.bruno.carro.entity.Carro;
import br.com.bruno.carro.exception.CarroException;
import br.com.bruno.carro.repository.CarroRepository;
import br.com.bruno.carro.util.Message;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarroService {

    private ModelMapper mapper = new ModelMapper();

    private final CarroRepository carroRepository;

    public Carro findById(Long id) {
        return carroRepository.findById(id)
                .orElseThrow(() -> new CarroException(String.format("%s%d", Message.SEM_CARRO_COM_ID_, id)));
    }

    public List<Carro> findAll(){
        return new ArrayList<>(carroRepository.findAll());
    }

    public List<Carro> findAllSortedByNome() {
        return carroRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Carro save(Carro carro){
        return carroRepository.save(carro);
    }

    public void deleteById(long id){
        carroRepository.deleteById(id);
    }

}
