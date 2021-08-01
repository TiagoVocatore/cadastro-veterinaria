package com.qintess.veterinaria.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;


@Entity
public class Prontuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@OneToOne
	@JoinColumn(name = "atendimento_codigo")
	private Atendimento atendimento;
	@ManyToMany
	@JoinTable(name="exame_prontuario",
	uniqueConstraints = @UniqueConstraint(columnNames = {"prontuario_codigo", 
			"exame_codigo"}),
	joinColumns = @JoinColumn(name="prontuario_codigo"),
	inverseJoinColumns = @JoinColumn(name="exame_codigo"))
	private List<Exame> exames;
	@ManyToMany
	@JoinTable(name="medicamento_prontuario",
			uniqueConstraints = @UniqueConstraint(columnNames = {"prontuario_codigo", 
					"medicamento_codigo"}),
	joinColumns = @JoinColumn(name="prontuario_codigo"),
	inverseJoinColumns = @JoinColumn(name="medicamento_codigo"))
	private List<Medicamento> medicamentos;
	
	private String diagnostico;
	@Column(columnDefinition = "text")
	private String prescricao;
	
	
	
	public Prontuario() {
	}



	public Prontuario(com.qintess.veterinaria.model.Atendimento atendimento, List<Exame> exames,
			List<Medicamento> medicamentos, String diagnostico, String prescricao) {
		this.atendimento = atendimento;
		this.exames = exames;
		this.medicamentos = medicamentos;
		this.diagnostico = diagnostico;
		this.prescricao = prescricao;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}
	
}
