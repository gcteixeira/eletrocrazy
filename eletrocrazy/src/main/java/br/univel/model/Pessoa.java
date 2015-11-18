package br.univel.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "pessoa")
@XmlRootElement
public class Pessoa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(name = "idpessoa", nullable = false)
	private String IdPessoa;

	@Column(name = "nome")
	private String Nome;

	@Column(name = "rg")
	private String Rg;

	@Column(name = "cpf")
	private String Cpf;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pessoa)) {
			return false;
		}
		Pessoa other = (Pessoa) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getIdPessoa() {
		return IdPessoa;
	}

	public void setIdPessoa(String IdPessoa) {
		this.IdPessoa = IdPessoa;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getRg() {
		return Rg;
	}

	public void setRg(String Rg) {
		this.Rg = Rg;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String Cpf) {
		this.Cpf = Cpf;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (IdPessoa != null && !IdPessoa.trim().isEmpty())
			result += "IdPessoa: " + IdPessoa;
		if (Nome != null && !Nome.trim().isEmpty())
			result += ", Nome: " + Nome;
		if (Rg != null && !Rg.trim().isEmpty())
			result += ", Rg: " + Rg;
		if (Cpf != null && !Cpf.trim().isEmpty())
			result += ", Cpf: " + Cpf;
		return result;
	}
}