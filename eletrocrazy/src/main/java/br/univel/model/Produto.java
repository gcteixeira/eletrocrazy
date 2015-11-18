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
import br.univel.model.Categoria;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "produto")
@XmlRootElement
public class Produto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(name = "idproduto", nullable = false)
	private float Idproduto;

	@Column(name = "descricao")
	private String Descricao;

	@Column(name = "quantidadeproduto")
	private double QuantidadeProduto;

	@Column(name = "produtovalor")
	private double ProdutoValor;

	@Column(name = "idcategoria")
	private Categoria idcategoria;

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
		if (!(obj instanceof Produto)) {
			return false;
		}
		Produto other = (Produto) obj;
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

	public float getIdproduto() {
		return Idproduto;
	}

	public void setIdproduto(float Idproduto) {
		this.Idproduto = Idproduto;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String Descricao) {
		this.Descricao = Descricao;
	}

	public double getQuantidadeProduto() {
		return QuantidadeProduto;
	}

	public void setQuantidadeProduto(double QuantidadeProduto) {
		this.QuantidadeProduto = QuantidadeProduto;
	}

	public double getProdutoValor() {
		return ProdutoValor;
	}

	public void setProdutoValor(double ProdutoValor) {
		this.ProdutoValor = ProdutoValor;
	}

	public Categoria getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Categoria idcategoria) {
		this.idcategoria = idcategoria;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		result += "Idproduto: " + Idproduto;
		if (Descricao != null && !Descricao.trim().isEmpty())
			result += ", Descricao: " + Descricao;
		result += ", QuantidadeProduto: " + QuantidadeProduto;
		result += ", ProdutoValor: " + ProdutoValor;
		return result;
	}
}