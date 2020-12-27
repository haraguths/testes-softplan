package exception;

public class DescricaoComposicaoNaoEncontradaException extends RuntimeException {
    public DescricaoComposicaoNaoEncontradaException() {
        super("Descrição composição não encontrada.");
    }
}
