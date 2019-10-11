package br.com.grk;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

import br.com.grk.dao.DaoGeneric;
import br.com.grk.entidades.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	
	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public String salvar() {
		pessoa = daoGeneric.merge(pessoa);
		carregarPessoas();
		return "";
	}	
	
	public String novo() {
		pessoa =  new Pessoa();
		carregarPessoas();
		return "";
	}	
	
	public String remove() {
		daoGeneric.deletePorId(pessoa);
		pessoa =  new Pessoa();
		carregarPessoas();
		return "";
	}	
	
	@PostConstruct
	public void carregarPessoas() {
		pessoas = daoGeneric.getListEntity(Pessoa.class);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DaoGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
}
