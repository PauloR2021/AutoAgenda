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
    <link rel="stylesheet" href="css/style_listar.css">
</head>
<body>

    <header class="cabecalho">
        <div class="nav-buttons">
            <a href="index.html">Cadastrar Produto</a>
        </div>
    </header>

    <div class="container">
        <h1>Veiculos Agendados</h1>

        <% if (lista == null || lista.isEmpty()) { %>
            <p>Nenhum Veiculo Agendado.</p>
        <% } else { %>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Nome Motorista</th>
                    <th>Veiculo</th>
                    <th>Placa</th>
                    <th>Data da Retirada</th>
                    <th>Data do Retorno</th>
                    <th>Observacao</th>
                    <th>Status</th>
                </tr>
                <% for (Agendamento p : lista) { %>
                    <tr>
                        <td><%= p.getId() %></td>
                        <td><%= p.getMotorista() %></td>
                        <td><%= p.getVeiculo()%></td>
                        <td><%= p.getPlaca()%></td>
                        <td><%= p.getDataRetirada()%></td>
                        <td><%= p.getDataDevolucao()%></td>
                        <td><%= p.getObservacao()%></td>
                        <td><%= p.getStatus()%></td>
                        
                    </tr>
                    <button type="submit">Alterar</button>
                    <button type="submit">Deletar</button>
                <% } %>
            </table>
        <% } %>
    </div>

</body>
</html>