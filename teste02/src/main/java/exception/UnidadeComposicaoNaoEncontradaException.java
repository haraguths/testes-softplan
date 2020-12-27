package exception;

public class UnidadeComposicaoNaoEncontradaException extends RuntimeException{
    public UnidadeComposicaoNaoEncontradaException() {
        super("Unidade composição não encontrada.");
    }
}
