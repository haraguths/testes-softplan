package exception;

public class ArquivoNaoEncontradoException extends RuntimeException {

    public ArquivoNaoEncontradoException() { super("Arquivo não encontrado."); }
}
