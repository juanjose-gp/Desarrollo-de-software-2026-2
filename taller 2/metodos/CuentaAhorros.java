package metodos;

public class CuentaAhorros extends cuenta {

    public CuentaAhorros(int numeroCuenta, double saldo, cliente cliente) {
        super(numeroCuenta, saldo, cliente);
    }

    @Override
    public void mostrarTipoCuenta() {
        System.out.println("Cuenta de Ahorros");
    }
}