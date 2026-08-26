package modelo;

import java.math.BigDecimal;

public class Cuenta {

    protected final String numero;
    protected final String titular;
    protected BigDecimal saldo;

    public Cuenta(String numero, String titular, BigDecimal saldoInicial) {

        if (saldoInicial.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "El saldo inicial no puede ser negativo"
            );
        }

        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Operación de negocio: depositar
    public void depositar(BigDecimal monto) {
        this.saldo = this.saldo.add(monto);
    }

    // Operación de negocio: debitar
    public void debitar(BigDecimal monto) {

        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser positivo"
            );
        }

        if (monto.compareTo(this.saldo) > 0) {
            throw new SaldoInsuficienteException(
                    "Saldo: " + saldo
                    + ", solicitado: " + monto
            );
        }

        this.saldo = this.saldo.subtract(monto);
    }

    // Consultar saldo
    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }
}
