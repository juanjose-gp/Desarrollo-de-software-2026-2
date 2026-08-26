package pagos;
// Interfaz común: define el contrato
import java.math.BigDecimal;

public interface Pago {

    void procesar(BigDecimal monto);

    String getDescripcion();
}
