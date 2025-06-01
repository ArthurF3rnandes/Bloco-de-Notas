//Classe generica feita, para a organização do armazenamento e quantidade atual de elementos
public class Metodo1<E> {

    private E[] elementos;
    private int tamanho;

    //Array genetico, que faz um cast forçado para E[]
    //Assim, o compilador gera um unchecked warning
    // o @SuppressWarnings vai servir apeans para esconder o aviso criado
    @SuppressWarnings("unchecked")
    public Metodo1(int capacidade) {
        elementos = (E[]) new Object[capacidade];
        tamanho = 0;
    }
    //Vai verficar se tem espaço no array, se não, lança uma exceção
    // Adiciona o elemento na proxima posição disponível e vai incrementar o tamanho
    public void adicionar(E elemento) {
        if (tamanho >= elementos.length) {
            throw new IllegalStateException("Lista está cheia");
        }
        elementos[tamanho++] = elemento;
    }
    //Validação se o elemento é nulo ou não (lança exceção se for)
    //E tbm vai chamar uma função recursiva auxiliar para contar x vezes o elemento aparece no array
    public int contaElementos(E el) throws Exception {
        if (el == null) {
            throw new Exception("Elemento não pode ser nulo");
        }
        return contaElementos(el, 0);
    }
    //Aqui, ele vai percorrer recurssivamente o array
    //Se o elemento estiver na posição de indice for igual ao buscado, doma 1
    //Vai continuar até o final do Array (indice >= tamanho)
    private int contaElementos(E el, int indice) {
        if (indice >= tamanho) {
            return 0;
        }
        int conta = elementos[indice].equals(el) ? 1 : 0;
        return conta + contaElementos(el, indice + 1);
    }
}

//O que o Metodo1 faz?
//Resumidamente, é uma estrutura de dados genérica para contar quantos parenteses existem