import java.util.Stack;

// O Metodo2 vai servir para verificação dos parênteses balanceados
// Usável com qualquer string que contenha parênteses
public class Metodo2 {

    public boolean checkBrackets(Stack<Character> s1) {
        Stack<Character> copia = (Stack<Character>) s1.clone(); // Vai preservar a pilha original
        int contador = 0;

        while (!copia.isEmpty()) {
            char c = copia.pop();
            if (c == '(') {
                contador++; // Abre um parêntese: incrementa
            } else if (c == ')') {
                contador--; // Fecha um parêntese: decrementa
                if (contador < 0) {
                    return false; // Fechar antes de abrir
                }
            }
        }

        // Nessa lógica, ao encontrar (, incrementa. Ao encontrar ), decrementa.
        // Se ficar negativo, significa que houve um fechamento sem correspondente abertura
        return contador == 0; // Tudo ok
    }
    // Se voltar a 0, significa que os parênteses ficaram ok

    public static void main(String[] args) {
        Metodo2 m2 = new Metodo2();
        Stack<Character> pilha = new Stack<>();

        String expressao = "(A+B)";
        for (int i = expressao.length() - 1; i >= 0; i--) {
            pilha.push(expressao.charAt(i));
        }

        boolean resultado = m2.checkBrackets(pilha);
        System.out.println("Expressão válida? " + resultado);
    }
}

// Vai construir as pilhas com os caracteres da expressão em ordem reversa, até char no topo da pilha
// A princípio é para essa gambiarra funcionar, eu acredito pelo menos

// O que o Metodo2 faz?
// Serve para verificar se a estrutura da expressão está correta (balanceada)
// E por consequência, vai mostrar os resultados claros e úteis para a validação das expressões
