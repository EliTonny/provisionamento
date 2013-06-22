package MyExceptions;

public class ReferenciaException extends DaoException {

    public ReferenciaException(String mensagem, Exception ex) {
        super(mensagem, ex);
    }

    public ReferenciaException(Exception ex) {
        super(ex);
    }
    public ReferenciaException(String mensage) {
        super(mensage);
    }
}