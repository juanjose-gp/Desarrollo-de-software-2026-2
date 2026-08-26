package pagos;
// Implementación 3: pago en efectivo
import java.math.BigDecimal;
package pagos;

public class PagoEfectivo implements Pago {

    @Override
    public void procesar(BigDecimal monto) {
        System.out.println("Registrando pago en efectivo de $" + monto);
    }

    @Override
    public String getDescripcion() {
        return "Efectivo";
    }

}

