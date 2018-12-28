package br.com.estoque.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.conexao.ConnectionFactory;
import br.com.estoque.bean.EstoqueProdutoBean;
import br.com.estoque.dao.EstoqueProdutoDao;

public class EstoqueTeste {
	public static void main(String[] args) {

		//testeSalvar();
		// testeBuscar();
		//testeExcluir();
		// testeAlterar();
		//testeBuscarTodos();
		
	}
	private static void testeSalvar() {
		EstoqueProdutoBean bean = new EstoqueProdutoBean();

		bean.setDescProduto("Pão de forma integral");
		bean.setNomeProduto("Panco");
		bean.setQtdProduto(15);
		
		EstoqueProdutoDao dao = new EstoqueProdutoDao();
		dao.salvar(bean);
	}
	private static void testeBuscar() {
		
		
		EstoqueProdutoDao epd = new EstoqueProdutoDao();
		
		EstoqueProdutoBean epb = epd.findById(1); 
		
		System.out.println("Descrição: " + epb.getDescProduto() );
		
	}
	private static void testeExcluir() {
		
		EstoqueProdutoBean estoqueProdutoBean = new EstoqueProdutoBean();
		estoqueProdutoBean.setId(6);
		
//		EstoqueProdutoDao dao = new EstoqueProdutoDao();
//		dao.excluir(estoqueProdutoBean);
	
	}
	private static void testeAlterar () {
		EstoqueProdutoBean epb = new EstoqueProdutoBean();
		epb.setId(2);
		epb.setDescProduto("Arroz ");
		epb.setNomeProduto("Arroz Camil");
		epb.setQtdProduto(20);
		
		EstoqueProdutoDao epd = new EstoqueProdutoDao();
		epd.salvar(epb);
		
	}
private static void testeBuscarTodos() {
		
		EstoqueProdutoDao dao = new EstoqueProdutoDao();
		
		for(EstoqueProdutoBean epb: dao.findAll()) {
			System.out.println("Descrição: "+ epb.getDescProduto());
		}
		
	}

}
