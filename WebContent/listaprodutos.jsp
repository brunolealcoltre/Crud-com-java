<%@page import="br.com.estoque.bean.EstoqueProdutoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<table border="1">
		<tr bgcolor="#cccccc">
			
			<th>ID</th> <th>NomeProduto</th><th>descricao</th><th>Quantidade</th><th>Acao</th>
		</tr>
		
<%

//SCRIPLET
List<EstoqueProdutoBean>lista = (List<EstoqueProdutoBean>)request.getAttribute("lista");	

for(EstoqueProdutoBean epb : lista){
%>	
		<!-- lista dos produtos que aparecem para o usuario -->
		<tr>
			<td><%= epb.getId() %></td>
			<td><%= epb.getNomeProduto() %></td>
			<td><%= epb.getDescProduto() %></td>
			<td><%= epb.getQtdProduto() %></td>
			<td>
			<!-- 1° PARA EXCLUIR -->
			<a href="ServletProduto?acao=exc&id=<%=epb.getId()%>">Excluir</a>
			<!-- 1° PARA ALTERAR -->
			<a href="ServletProduto?acao=alt&id=<%=epb.getId()%>">Alterar</a>
			
			</td>
		</tr>			 
	

<% } %>

		</table>
		
		<tr>
		<td>
			<a href="ServletProduto?acao=cad">Cadastrar</a>
		</td>
		</tr>
		
</body>
</html>