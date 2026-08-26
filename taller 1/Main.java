
import modelo.CuentaCorriente;
import modelo.Pedido;
import modelo.CheckoutService;

import pagos.Pago;
import pagos.PagoTarjeta;
import pagos.PagoTransferencia;
import pagos.PagoEfectivo;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pedido pedido = new Pedido(new BigDecimal("500"));

        CheckoutService checkout = new CheckoutService();

        System.out.println("=== SISTEMA DE PAGOS ===");
        System.out.println("1. Pago con tarjeta");
        System.out.println("2. Pago por transferencia");
        System.out.println("3. Pago en efectivo");
        System.out.print("Seleccione una opción: ");

        int opcion = sc.nextInt();
        sc.nextLine();

        Pago metodoPago = null;

        switch (opcion) {

            case 1:
                System.out.print("Ingrese número de tarjeta: ");
                String tarjeta = sc.nextLine();

                metodoPago = new PagoTarjeta(tarjeta);
                break;

            case 2:
                System.out.print("Ingrese CBU: ");
                String cbu = sc.nextLine();

                metodoPago = new PagoTransferencia(cbu);
                break;

            case 3:
                metodoPago = new PagoEfectivo();
                break;

            default:
                System.out.println("Opción inválida");
                System.exit(0);
        }

        checkout.finalizarCompra(pedido, metodoPago);

        System.out.println("\n=== PRUEBA CUENTA CORRIENTE ===");

        CuentaCorriente cuenta = new CuentaCorriente(
                "001",
                "Juan Jose",
                new BigDecimal("1000"),
                new BigDecimal("500")
        );

        System.out.println("Saldo inicial: " + cuenta.getSaldo());

        cuenta.debitar(new BigDecimal("1200"));

        System.out.println("Saldo después del débito: "
                + cuenta.getSaldo());

        sc.close();
    }
}
