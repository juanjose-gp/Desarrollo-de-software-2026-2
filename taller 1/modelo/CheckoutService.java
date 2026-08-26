package modelo;
import pagos.Pago;
// ✅ El servicio de checkout trabaja con la abstracción Pago,// sin importar cuál es la implementación concreta

public class CheckoutService {

    public void finalizarCompra(Pedido pedido, Pago metodoDePago) {
        // El mismo código funciona para tarjeta, transferencia o efectivo        
        metodoDePago.procesar(pedido.getTotal());
        System.out.println("Compra finalizada. Método: " + metodoDePago.getDescripcion());
    }

}

