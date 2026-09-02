package service;

import java.util.ArrayList;
import java.util.List;
import metodos.factura;

public class facturaService {

    private List<factura> facturas;
    private int siguienteId;

    public facturaService() {
        this.facturas = new ArrayList<>();
        this.siguienteId = 1;
    }

    public void crearFactura(String servicio, double valor,
                             metodos.cliente cliente) {
        crearfactura(new factura(0, servicio, valor, cliente));
    }

    // CREATE
    public void crearfactura(factura factura) {
        if (factura == null || factura.getCliente() == null
                || factura.getServicio() == null
                || factura.getServicio().trim().isEmpty()
                || factura.getValor() <= 0) {
            System.out.println("Los datos de la factura no son validos.");
            return;
        }

        factura.setId(siguienteId++);

        facturas.add(factura);
        System.out.println("factura creada correctamente.");
    }

    // READ
    public factura buscarfacturaPorId(int id) {

        for (factura factura : facturas) {
            if (factura.getId() == id) {
                return factura;
            }
        }

        return null;
    }

    // READ ALL
    public List<factura> obtenerfacturas() {
        return facturas;
    }

    // UPDATE
    public boolean actualizarfactura(int id,
                                     String servicio,
                                     double valor) {

        factura factura = buscarfacturaPorId(id);

        if (factura != null && servicio != null
            && !servicio.trim().isEmpty() && valor > 0) {
            factura.setServicio(servicio);
            factura.setValor(valor);
            return true;
        }

        return false;
    }

    // DELETE
    public boolean eliminarfactura(int id) {

        factura factura = buscarfacturaPorId(id);

        if (factura != null) {
            facturas.remove(factura);
            return true;
        }

        return false;
    }

    // FUNCIONALIDAD SOLICITADA
    public List<factura> obtenerfacturasPorCliente(int idCliente) {

        List<factura> resultado = new ArrayList<>();

        for (factura factura : facturas) {

            if (factura.getCliente().getId() == idCliente) {
                resultado.add(factura);
            }
        }

        return resultado;
    }

    public List<factura> obtenerfacturasPorDocumento(String documento) {

        List<factura> resultado = new ArrayList<>();

        for (factura factura : facturas) {
            if (factura.getCliente() != null
                    && documento.equals(factura.getCliente().getDocumento())) {
                resultado.add(factura);
            }
        }

        return resultado;
    }

    public factura buscarFacturaPorDocumentoYServicio(String documento,
                                                       String servicio) {
        for (factura factura : facturas) {
            if (!factura.isPagada()
                    && factura.getCliente() != null
                    && documento.equals(factura.getCliente().getDocumento())
                    && factura.getServicio().equalsIgnoreCase(servicio)) {
                return factura;
            }
        }
        return null;
    }

    // Marcar factura como pagada
    public boolean marcarComoPagada(int idfactura) {

        factura factura = buscarfacturaPorId(idfactura);

        if (factura != null) {
            factura.setPagada(true);
            return true;
        }

        return false;
    }

    // Listar todas las facturas
    public void listarfacturas() {

        if (facturas.isEmpty()) {
            System.out.println("No existen facturas registradas.");
            return;
        }

        for (factura factura : facturas) {
            System.out.println(factura);
        }
    }

    // Listar facturas de un cliente
    public void listarfacturasCliente(int idCliente) {

        List<factura> resultado =
                obtenerfacturasPorCliente(idCliente);

        if (resultado.isEmpty()) {
            System.out.println("El cliente no tiene facturas.");
            return;
        }

        for (factura factura : resultado) {
            System.out.println(factura);
        }
    }

    public void listarFacturasCliente(String documento) {
        List<factura> resultado = obtenerfacturasPorDocumento(documento);

        if (resultado.isEmpty()) {
            System.out.println("El cliente no tiene facturas.");
            return;
        }

        for (factura factura : resultado) {
            System.out.println(factura);
        }
    }
}