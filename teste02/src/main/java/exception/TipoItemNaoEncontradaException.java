package exception;

public class TipoItemNaoEncontradaException extends RuntimeException{

    public TipoItemNaoEncontradaException(){
        super("Tipo item não encontrada.");
    }
}
