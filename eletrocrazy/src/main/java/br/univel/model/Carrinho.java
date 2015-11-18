package br.univel.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import br.univel.model.Pessoa;
import br.univel.model.Produto;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "carrinho")
@XmlRootElement
public class Carrinho implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(name = "idcarrinho", nullable = false)
	private int Idcarrinho;

	@Column(name = "idpessoa")
	private Pessoa Idpessoa;

	@Column(name = "idproduto", nullable = false)
	private Produto Idproduto;

	@Column(name = "preco")
	private float Preco;

	@Column(name = "quantidade")
	private int Quantidade;

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
		if (!(obj instanceof Carrinho)) {
			return false;
		}
		Carrinho other = (Carrinho) obj;
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

	public int getIdcarrinho() {
		return Idcarrinho;
	}

	public void setIdcarrinho(int Idcarrinho) {
		this.Idcarrinho = Idcarrinho;
	}

	public Pessoa getIdpessoa() {
		return Idpessoa;
	}

	public void setIdpessoa(Pessoa Idpessoa) {
		this.Idpessoa = Idpessoa;
	}

	public Produto getIdproduto() {
		return Idproduto;
	}

	public void setIdproduto(Produto Idproduto) {
		this.Idproduto = Idproduto;
	}

	public float getPreco() {
		return Preco;
	}

	public void setPreco(float Preco) {
		this.Preco = Preco;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int Quantidade) {
		this.Quantidade = Quantidade;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		result += "Idcarrinho: " + Idcarrinho;
		result += ", Preco: " + Preco;
		result += ", Quantidade: " + Quantidade;
		return result;
	}
}