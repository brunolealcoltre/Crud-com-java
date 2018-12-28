

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.com.estoque.bean.EstoqueProdutoBean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>crud Bruno</title>
<style type="text/css">
	body{
	          background-color:#A9F5F2;
	          
	    }
</style>
</head>
<body>

<center>
<div class="container">
      <h1>Cadastro Produtos</h1>
    
    <!--   ENDEREÇO NA WEB  http://localhost:8082/ProjetoControleDeEstoque/ServletProduto?acao=cad  -->  
    
    <%
    EstoqueProdutoBean estoqueProdutoBean = (EstoqueProdutoBean) request.getAttribute("produto");
    %>
    
      <form class="" action="ServletProduto" method="post">

        <p>
        <input type="text" name="txtid" placeholder="Seu id:" value='<%= estoqueProdutoBean.getId() %>'   >
        </p>
		
		<p>
        <input type="text" name="txtnomeProduto"placeholder="Nome do produto:" value='<%=estoqueProdutoBean.getNomeProduto() %>' >
        </p>

        <p>
        <textarea name="txtdescricao" rows="8" cols="21"placeholder="Descrição do produto"><%=estoqueProdutoBean.getDescProduto()%></textarea >
        </p>
        
        <p>
        <input type="text" name="txtquantidade"placeholder="quantidade do produto" value='<%=estoqueProdutoBean.getQtdProduto() %>'>
        </p>

        <p>
          <input type="submit" name="Cadastrar" value="CADASTRAR">
        </p>

		
        
      </form>
    </div>
    </center>
</body>
</html>

