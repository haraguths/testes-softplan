package exception;

public class ErrosComposicaoDTOException extends RuntimeException {
    public ErrosComposicaoDTOException() {
        super("Não foi possível realizar cálculo das composições.");
    }
}
