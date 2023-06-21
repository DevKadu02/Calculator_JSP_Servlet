<%-- 
    Document   : index
    Created on : 19 de jun. de 2023, 12:32:49
    Author     : kadu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculadora</title>
</head>
<body>
    <h1>Calculadora</h1>
    
    <form action="calculo" method="post">
        Valor 1: <input type="text" name="valor1" /><br/>
        Valor 2: <input type="text" name="valor2" /><br/>
        Operação (+, -, *, /): <input type="text" name="operacao" /><br/>
        <input type="submit" value="Calcular" />
         
    <% if (request.getAttribute("valor1Erro") != null) { %>
        <p><font color="red">Erro no valor 1: <%= request.getAttribute("valor1Erro") %></font></p>
    <% } %>
    <% if (request.getAttribute("valor2Erro") != null) { %>
        <p><font color="red">Erro no valor 2: <%= request.getAttribute("valor2Erro") %></font></p>
    <% } %>
    <% if (request.getAttribute("divisaoErro") != null) { %>
        <p><font color="red">Erro de divisão: <%= request.getAttribute("divisaoErro") %></font></p>
    <% } %>

    
    <% if (request.getAttribute("resultado") != null) { %>
        <p>Resultado: <%= request.getAttribute("resultado") %></p>
    <% } %>
    </form>
</body>
</html>
