package com.qintess.veterinaria.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qintess.veterinaria.model.Medicamento;


public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {

	public Medicamento findByNome(String nome);

	public List<Medicamento> findAll();

	public Medicamento findById(int codigo);

}
