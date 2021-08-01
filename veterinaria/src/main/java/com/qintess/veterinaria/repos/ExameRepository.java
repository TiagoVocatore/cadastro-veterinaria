package com.qintess.veterinaria.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qintess.veterinaria.model.Exame;


public interface ExameRepository extends JpaRepository<Exame, Integer> {

	public Exame findByNome(String nome);

	public List<Exame> findAll();

	public Exame findById(int codigo);

}
