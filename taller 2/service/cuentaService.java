package service;

import java.util.ArrayList;
import java.util.List;
import metodos.cliente;
import metodos.cuenta;
import metodos.cuentaCorriente;

public class cuentaService {

    private List<cuenta> cuentas;

    public cuentaService() {
        this.cuentas = new ArrayList<>();
    }

    // CREATE
    public void crearcuenta(cuenta cuenta) {
        if (cuenta == null || cuenta.getCliente() == null
                || cuenta.getNumeroCuenta() <= 0
                || cuenta.getSaldo() < 0) {
            System.out.println("Los datos de la cuenta no son validos.");
            return;
        }

        if (cuenta instanceof cuentaCorriente cuentaCorriente
                && cuentaCorriente.getCreditoDisponible() < 0) {
            System.out.println("El credito inicial no puede ser negativo.");
            return;
        }

        if (buscarcuentaPorNumero(cuenta.getNumeroCuenta()) != null) {
            System.out.println("Ya existe un registro con ese numero de cuenta.");
            return;
        }

        if (buscarcuentaPorDocumento(cuenta.getCliente().getDocumento()) != null) {
            System.out.println("Ya existe una cuenta para esa cedula.");
            return;
        }

        cuentas.add(cuenta);
        System.out.println("cuenta creada correctamente.");
    }

    // READ
    public cuenta buscarcuentaPorNumero(int numerocuenta) {

        for (cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta() == numerocuenta) {
                return cuenta;
            }
        }

        return null;
    }

    public cuenta buscarcuentaPorDocumento(String documento) {

        if (documento == null) {
            return null;
        }

        for (cuenta cuenta : cuentas) {
            cliente cliente = cuenta.getCliente();
            if (cliente != null && documento.equals(cliente.getDocumento())) {
                return cuenta;
            }
        }

        return null;
    }

    // UPDATE
    public boolean actualizarSaldo(int numerocuenta, double nuevoSaldo) {

        if (nuevoSaldo < 0) {
            return false;
        }

        cuenta cuenta = buscarcuentaPorNumero(numerocuenta);

        if (cuenta != null) {
            cuenta.setSaldo(nuevoSaldo);
            return true;
        }

        return false;
    }

    // DELETE
    public boolean eliminarcuenta(int numerocuenta) {

        cuenta cuenta = buscarcuentaPorNumero(numerocuenta);

        if (cuenta != null) {
            cuentas.remove(cuenta);
            return true;
        }

        return false;
    }

    // FUNCIONALIDAD SOLICITADA
    public double obtenerSaldocuenta(int numerocuenta) {

        cuenta cuenta = buscarcuentaPorNumero(numerocuenta);

        if (cuenta != null) {
            return cuenta.getSaldo();
        }

        return -1;
    }

    // Depositar dinero
    public boolean depositar(int numerocuenta, double valor) {

        if (valor <= 0) {
            return false;
        }

        cuenta cuenta = buscarcuentaPorNumero(numerocuenta);

        if (cuenta != null) {
            cuenta.setSaldo(cuenta.getSaldo() + valor);
            return true;
        }

        return false;
    }

    // Retirar dinero
    public boolean retirar(int numerocuenta, double valor) {

        if (valor <= 0) {
            return false;
        }

        cuenta cuenta = buscarcuentaPorNumero(numerocuenta);

        if (cuenta == null) {
            return false;
        }

        if (cuenta.getSaldo() < valor) {
            return false;
        }

        cuenta.setSaldo(cuenta.getSaldo() - valor);
        return true;
    }

    // Listar todas las cuentas
    public void listarCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        } else {
            System.out.println("\n===== LISTADO DE CUENTAS =====");
            for (cuenta c : cuentas) {
                System.out.println(c);
            }
        }
    }

    // Mostrar tipos de cuenta disponibles
    public void mostrarTiposCuenta() {
        System.out.println("\n===== TIPOS DE CUENTA =====");
        System.out.println("1. Cuenta de Ahorros");
        System.out.println("2. Cuenta Corriente");
    }
}