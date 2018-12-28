package br.com.estoque.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.conexao.ConnectionFactory;
import br.com.estoque.bean.EstoqueProdutoBean;

public class EstoqueProdutoDao {

	public EstoqueProdutoBean salvar(EstoqueProdutoBean produto) {

		EntityManager em = ConnectionFactory.getConnection();

		try {
			em.getTransaction().begin();
			if (produto.getId() == null) {
				em.persist(produto);
			} else {
				em.merge(produto);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return produto;
	}
	
	public void cadastrar (EstoqueProdutoBean produto) {
		if(produto.getId()!=null && produto.getId()!=0) {
			alterar(produto);
		}else {
			salvar(produto);
		}
	}

	public EstoqueProdutoBean findById(Integer id) {

		EntityManager em = ConnectionFactory.getConnection();
		
		EstoqueProdutoBean buscaId = null;
		
		try {
			buscaId = em.find(EstoqueProdutoBean.class,id);
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}

		return buscaId;
		}
	
	public void excluir(EstoqueProdutoBean produto) {
		EntityManager em = ConnectionFactory.getConnection();
		
		EstoqueProdutoBean estoqueProdutoBean = null;
		
		try {
			estoqueProdutoBean = em.find(EstoqueProdutoBean.class, produto.getId());
			em.getTransaction().begin();
			em.remove(estoqueProdutoBean);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	
	public EstoqueProdutoBean alterar(EstoqueProdutoBean produto) {

		EntityManager em = ConnectionFactory.getConnection();

		try {
			em.getTransaction().begin();
			if (produto.getId() == null) {
				em.persist(produto);
			} else {
				em.merge(produto);//merge responsavel por fazer o update
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return produto;
	}
	public List<EstoqueProdutoBean>findAll() {
		
		EntityManager em = ConnectionFactory.getConnection();		
		
		List<EstoqueProdutoBean> estoqueProdutoBean = null;
		
		try {
			estoqueProdutoBean = em.createQuery("from EstoqueProdutoBean ").getResultList();
		
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return estoqueProdutoBean;
	}
}

