public interface Fila<T>{
    void adcionar(T valor);
    T remover();
    boolean isCheia();
    boolean isVazia();
    void limpar();
}

public class FilaCircular<T> implements Fila<T> {
private int base = 0;
private int topo = -1;

private T[] dados;

public FilaCircular(int tamanho) {
    this.dados = (T[]) new Object[tamanho];
}
private int mover(int posicao) {
    return posicao +1 == dados.length ? 0 : posicao +1; // ? se entao :
}

public boolean isVazia(){
    return topo == -1;
}

public boolean isCheia() {
    return !isVazia() && mover(topo) == base; //não é vazia E mover o topo é igual a posição da base
}

public void adcionar(T valor) {
    if (isCheia()) { //Está cheia ? Dispara a exceção
        throw new IllegalStateExceptiom("Fila cheia!");
    }
    topo = mover(topo);
    dados[topo] = valor;
}

public T remover(){
    if (isVazia()) { //vazia? dispara execeção
        throw new IllegalStateExceptiom("Fila vazia!");
}
    T dado = dados[base];
    if (base == topo) { //ultimo elemento ?
        limpar();
    } else {
        dados[base] = null;
        base = mover(base);
    }
    return dado;
}
public void limpar() {
    base = 0;
    topo = -1;
    for(int i = 0; i < dados.length; i++) {
        dados[i] = null;
    }
}
