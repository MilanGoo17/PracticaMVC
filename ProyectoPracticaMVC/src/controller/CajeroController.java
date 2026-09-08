package controller;
import model.Cuenta;
import view.CajeroView;

import java.util.ArrayList;

public class CajeroController {
    private ArrayList<Cuenta> cuentas;
    private Cuenta cuentaActual;
    private CajeroView vista;

    public CajeroController(CajeroView vista){
        this.vista = vista;
        this.cuentas = new ArrayList<>();
        inicializarCuentas();
    }
    private void inicializarCuentas(){
        cuentas.add(new Cuenta("1001", "Juan Pérez", 5000));
        cuentas.add(new Cuenta("1002", "María López", 8500));
        cuentas.add(new Cuenta("1003", "Pedro García", 3200));
        cuentas.add(new Cuenta("1004", "Ana Martínez", 12000));
    }
    public void iniciar(){

    }

    private void procesarMenu(){
        int opc;
        do{
            opc = vista.solicitarYObtenerOpcion();
            double cantidad ;
            switch (opc) {

                case 1:
                    vista.mostrarMensaje("Saldo actual: $" + cuentaActual.getSaldo());break;

                case 2:
                    cantidad = vista.solicitarCantidad("depositar");
                    if (cantidad > 0) {
                        cuentaActual.depositar(cantidad);
                        vista.mostrarMensaje("Depósito exitoso.");
                    } else {
                        vista.mostrarMensaje("Error: el depósito debe ser mayor a $0.");
                    }
                    vista.mostrarMensaje("Saldo actual: $" + cuentaActual.getSaldo());
                    break;

                case 3:
                    cantidad = vista.solicitarCantidad("retirar");
                    vista.mostrarMensaje("Cantidad a retirar: $");
                    if (cantidad <= 0) {
                        vista.mostrarMensaje("Error: la cantidad debe ser mayor a $0.");
                    } else if (cantidad >
                            cuentaActual.getSaldo()) {
                        vista.mostrarMensaje("Error: saldo insuficiente.");
                    } else {
                        cuentaActual.retirar(cantidad);
                        vista.mostrarMensaje("Retiro exitoso.");
                    }
                    vista.mostrarMensaje("Saldo actual: $" + cuentaActual.getSaldo());
                    break;

                case 4:
                    vista.mostrarMensaje("Gracias por utilizar el cajero automático.");
                    break;

                default:
                    vista.mostrarMensaje("Error: opción no válida.");
            }
        }while (opc != 4);
        vista.cerrarScanner();
    }
}
