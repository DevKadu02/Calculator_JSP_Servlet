import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valor1Str = request.getParameter("valor1");
        String valor2Str = request.getParameter("valor2");
        String operacao = request.getParameter("operacao");

        float valor1 = 0, valor2 = 0, resultado = 0;
        String valor1Erro = null, valor2Erro = null, divisaoErro = null;


        try {
            valor1 = Float.parseFloat(valor1Str);
        } catch (NumberFormatException e) {
            valor1Erro = "Valor inválido";
        }

        try {
            valor2 = Float.parseFloat(valor2Str);
        } catch (NumberFormatException e) {
            valor2Erro = "Valor inválido";
        }

       
        if (valor1Erro == null && valor2Erro == null) {
            switch (operacao) {
                case "+":
                    resultado = valor1 + valor2;
                    break;
                case "-":
                    resultado = valor1 - valor2;
                    break;
                case "*":
                    resultado = valor1 * valor2;
                    break;
                case "/":
                    if (valor2 != 0) {
                        resultado = valor1 / valor2;
                    } else {
                        divisaoErro = "Divisão por zero não é permitida";
                    }
                    break;
                default:
                    divisaoErro = "Operação inválida";
                    break;
            }
        } else {
            resultado = 0;
        }

       
        request.setAttribute("valor1Erro", valor1Erro);
        request.setAttribute("valor2Erro", valor2Erro);
        request.setAttribute("divisaoErro", divisaoErro);
        request.setAttribute("resultado", resultado);

     
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}