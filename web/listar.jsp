<%-- 
    Document   : listar
    Created on : 2 de jun. de 2025, 20:39:41
    Author     : Paulo
--%>

<%@page import="br.com.prsoftware.model.Agendamento"%>
<%@ page import="java.util.*, br.com.prsoftware.model.Agendamento" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    List<Agendamento> lista = (List<Agendamento>) request.getAttribute("agendamentos");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
%>


<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Consultar Produtos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/consulta_style.css">
</head>
<body>

    <header class="cabecalho">
        <div class="nav-buttons">
            <a href="index.html">Cadastrar Produto</a>
        </div>
    </header>

    <div class="container">
        <h1>Produtos Cadastrados</h1>

        <% if (lista == null || lista.isEmpty()) { %>
            <p>Nenhum produto encontrado.</p>
        <% } else { %>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Quantidade</th>
                    <th>Preço</th>
                </tr>
                <% for (Produto p : lista) { %>
                    <tr>
                        <td><%= p.getId() %></td>
                        <td><%= p.getDescricao() %></td>
                        <td><%= p.getQuantidade() %></td>
                        <td>R$ <%= p.getPreco() %></td>
                    </tr>
                <% } %>
            </table>
        <% } %>
    </div>

</body>
</html>