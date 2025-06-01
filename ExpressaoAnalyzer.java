import java.util.Stack;

public class ExpressaoAnalyzer {

    private final String expressao; //o que sera analisado aqui
    private final Metodo1<Character> listaCaracteres; //estrutura generica do metodo1, para armazenagem
    private final Metodo2 verificador; //validar o metodo2, se esta com os parenteses ok

    public ExpressaoAnalyzer(String expressao) throws Exception {
        this.expressao = expressao;
        this.listaCaracteres = new Metodo1<>(expressao.length());
        this.verificador = new Metodo2();

        // Preenche a lista de caracteres
        for (char c : expressao.toCharArray()) {
            listaCaracteres.adicionar(c);
        }
    }
//essa parte endiabrada, vai ser o seguinte:
    //vai salvar a expressão, criar uma lista de caracteres com capacidade igual ao tamanho dela
    //depois cria o objetdo Metodo2 e perceorre a expressão, caracter por caracter até adicionar na lista
    public void analisar() throws Exception {
        //calculo dos parenteses
        int qtdAbertura = listaCaracteres.contaElementos('(');
        int qtdFechamento = listaCaracteres.contaElementos(')');

        //o balanceamento por fim do metodo2
        Stack<Character> pilha = new Stack<>();
        for (int i = expressao.length() - 1; i >= 0; i--) {
            pilha.push(expressao.charAt(i));
        }

        boolean estaBalanceado = verificador.checkBrackets(pilha);

        //aqui vai ser os resultados
        System.out.println("Expressão: " + expressao);
        System.out.println("Quantidade de '(': " + qtdAbertura);
        System.out.println("Quantidade de ')': " + qtdFechamento);
        System.out.println("Parênteses balanceados? " + (estaBalanceado ? "Sim" : "Não"));
    }

    //um calculo de uso para fazer um teste, vamos fazer usando um exemplo que será invalido
    public static void main(String[] args) {
        try {
            String expr = "(A+B)+(A+C)"; //É para ser invalido já que ta levando em consideração uma pilha nova só com 1 parenteses
            ExpressaoAnalyzer analise = new ExpressaoAnalyzer(expr);
            analise.analisar();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

//Agora o que a ExpressaoAnalyzer faz, pois tirou meu sabado e domingo?
//Utiliza o Metodo1 e Metodo2, juntando tudo e faz a validação 100%