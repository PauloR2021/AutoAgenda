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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
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
                    <th>Veículo</th>
                    <th>Placa</th>
                    <th>Data Retirada</th>
                    <th>Data Retorno</th>
                    <th>Observação</th>
                    <th>Status</th>
                    <th>Retirado</th>
                    <th>Devolver</th>
                    <th>Cancelar</th>
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
                        <td>
                            <!-- Criando o Button para Mudar o Status para Retirado no banco -->
                            <form action="retirado" method="get" style="display:inline;">
                                <input type="hidden" name="id" value="<%=p.getId() %>">
                                <button type="submit" class="btn-retirado" onclick="return confirm('Deseja realmente Retirar o Veículo?');">
                                    <i class="fas fa-check-circle"></i> RETIRADO
                                </button>   
                            </form>
                        </td>
                        
                        <td>
                            <!-- Criando o Button para Mudar o Status para Devolvido -->
                            <form action="devolvido" method="get" style="display:inline;">
                                <input type="hidden" name="id" value="<%=p.getId() %>">
                                <button type="submit" class="btn-devolvido" onclick="return confirm('Deseja realmente devolver esse Veículo?')">
                                    <i class="fas fa-check-circle"></i> DEVOLVER
                                </button>   
                            </form>
                        </td>
                        
                        <td>
                            <!-- Criando o Button para Cancelar o Agendamento do Veiculo -->
                            <form action="CancelarServelt" method="get" style="display:inline;">
                                <input type="hidden" name="id" value="<%=p.getId() %>">
                                <button type="submit" class="btn-cancelado">
                                  <i class="fas fa-times-circle"></i> CANCELAR
                                </button>   
                            </form>
                         
                        </td> 
                    </tr>
                    
                <% } %>
            </table>
        <% } %>
    </div>

</body>
</html>