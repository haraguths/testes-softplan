package exception;

public class ProblemasLeituraArquivoException extends RuntimeException {
    public ProblemasLeituraArquivoException() {
        super("Não foi possivel realizar a leitura do arquivo.");
    }
}
