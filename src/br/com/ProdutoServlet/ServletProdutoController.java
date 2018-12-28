package br.com.ProdutoServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estoque.bean.EstoqueProdutoBean;
import br.com.estoque.dao.EstoqueProdutoDao;

/**
 * Servlet implementation class ServletProduto
 */
@WebServlet("/ServletProduto")
public class ServletProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletProdutoController() {
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamando o metodo GET");

		// PEGA OS DADOS QUE VEM DA LISTA DE USUARIOS PARA SABER QUAL AÇÃO TOMAR
		// CAPTURA PARAMETRO DA TELA
		String acao = req.getParameter("acao");

		EstoqueProdutoDao estoqueProdutoDao = new EstoqueProdutoDao();
		
		// 2° PARA EXCLUIR
		if (acao != null && acao.equals("exc")) {
			// CAPTURA PARAMETRO DA TELA(BROWNSER) 
			//REQ.GETPARAMETER ARMAZENA NA VARIAVEL ID O id QUEM VEM DA TELA (BROWNSER)
			String id = req.getParameter("id");
			EstoqueProdutoBean produto = new EstoqueProdutoBean();
			produto.setId(Integer.parseInt(id));
			estoqueProdutoDao.excluir(produto);
			//REDIRECIONANDO PARA A LISTA DE PRODUTO(PELO BROWNSER)
			resp.sendRedirect("ServletProduto?acao=lis");

		}
//		if(acao != null && acao.equals("cad")){
//			EstoqueProdutoBean produto = new EstoqueProdutoBean();
//			produto.setId(0);
//			produto.setNomeProduto("");
//			produto.setDescProduto("");
//			produto.setQtdProduto(0);
//			// COLOCA O ATRIBUTO NO REQUEST E LEVA PARA O JSP NO JSP ELE DA UM
//			// REQUEST.GETPARAMETER PARA RETIRAR O ATRIBUTO DO REQUEST E IMPRIMIR NA TELA
//			req.setAttribute("produto", produto);
//			// ENCAMINHA O OBJETO PARA A TELA
//			RequestDispatcher saida = req.getRequestDispatcher("CadastroProdutos.jsp");
//			saida.forward(req, resp);
//		}
//		
		// 2°PARA ALTERAR
		if (acao != null && acao.equals("alt")) {
			// CAPTURA PARAMETRO DA TELA
			String id = req.getParameter("id");
			// BUSCAR O OBJETO NO BANCO
			EstoqueProdutoBean produto = estoqueProdutoDao.findById(Integer.parseInt(id));
			// COLOCA O ATRIBUTO NO REQUEST E LEVA PARA O JSP NO JSP ELE DA UM
			// REQUEST.GETPARAMETER PARA RETIRAR O ATRIBUTO DO REQUEST E IMPRIMIR NA TELA
			req.setAttribute("produto", produto);
			// ENCAMINHA O OBJETO PARA A TELA
			RequestDispatcher saida = req.getRequestDispatcher("CadastroProdutos.jsp");
			saida.forward(req, resp);
			
		}
		
		if (acao == null || acao.equals("lis")) {
			// OBTER A LISTA
			List<EstoqueProdutoBean> lista = estoqueProdutoDao.findAll();

			// ENGAVETAR NO REQUEST A LISTA
			req.setAttribute("lista", lista);
			
			// ENCAMINHAR PARA O JSP
			RequestDispatcher saida = req.getRequestDispatcher("listaprodutos.jsp");
			saida.forward(req, resp);
			
			
		}
		
		if (acao != null && acao.equals("lis")) {
			// OBTER A LISTA
			List<EstoqueProdutoBean> lista = estoqueProdutoDao.findAll();

			// ENGAVETAR NO REQUEST A LISTA
			req.setAttribute("lista", lista);
			
			// ENCAMINHAR PARA O JSP
			RequestDispatcher saida = req.getRequestDispatcher("listaprodutos.jsp");
			saida.forward(req, resp);
			
			
		}

		if (acao != null && acao.equals("cad")) {
			
			// CRIA NOVO OBJETO USUARIO
			EstoqueProdutoBean produto = new EstoqueProdutoBean();
			produto.setId(0);
			produto.setNomeProduto("");
			produto.setDescProduto("");
			produto.setQtdProduto(0);
			// COLOCA O ATRIBUTO NO REQUEST E LEVA PARA O JSP NO JSP ELE DA UM
			// REQUEST.GETPARAMETER PARA RETIRAR O ATRIBUTO DO REQUEST E IMPRIMIR NA TELA
			req.setAttribute("produto", produto);
			// ENCAMINHA O OBJETO PARA A TELA
			RequestDispatcher saida = req.getRequestDispatcher("CadastroProdutos.jsp");
			saida.forward(req, resp);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Chamando o metodo post");

		// Recebe dados na tela
		String id = request.getParameter("txtid");
		String nomeProduto = request.getParameter("txtnomeProduto");
		String descProduto = request.getParameter("txtdescricao");
		String qtdProduto = request.getParameter("txtquantidade");

		// cria o objeto usuario e seta os valores da tela
		EstoqueProdutoBean produtoBean = new EstoqueProdutoBean();

		if (id != "") {
			produtoBean.setId(Integer.parseInt(id));
		}

		produtoBean.setNomeProduto(nomeProduto);
		produtoBean.setDescProduto(descProduto);
		produtoBean.setQtdProduto(Integer.parseInt(qtdProduto));

		// Pede para o metodo dao cadastrar no banco de dados

		EstoqueProdutoDao dao = new EstoqueProdutoDao();
		dao.cadastrar(produtoBean);

		// Saida do Browser
		PrintWriter saida = response.getWriter();// Manda imprimir no browser
		saida.println("Salvo com sucesso!");
		//TESTE
	}

}
