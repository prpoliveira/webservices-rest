package br.unisal.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.unisal.api.util.GsonSingleton;

@Entity
@Table(name="tipo_usuario")
@XmlRootElement
public class TipoUsuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6282168576590541313L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_usuario", unique = true, nullable = false)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="sigla", unique=true)
	private String sigla;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="enable")
	private Boolean enable;
	
	public TipoUsuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Boolean getEnable() {
		return enable;
	}
	
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoUsuario other = (TipoUsuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return GsonSingleton.getInstance().toJson(this);
	}
	
}
