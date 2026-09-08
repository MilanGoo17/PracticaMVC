package view;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class CajeroView {
    private Scanner scanner;

    public void CajeroView(){
        Scanner scanner = new Scanner(System.in);
    }
    public String solicitarNumeroCuent(){
        System.out.println("===== CAJERO AUTOMATICO =====");
        System.out.println("Ingrese su numero de cuenta: " );
        return scanner.nextLine();
    }
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public void mostrarBienvenida(String titular, String numeroCuenta){
        System.out.println("\nBienvenido: "+ titular);
        System.out.println("Numero de cuenta: " + numeroCuenta);
    }

    public int solicitarYObtenerOpcion(){
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
        System.out.println("Seleccione una opcion: ");
        return scanner.nextInt();
    }
    public double solicitarCantidad(String tipoOperacion){
        System.out.println("Cantidad a " + tipoOperacion + " $: ");
        return scanner.nextDouble();
    }
    public void cerrarScanner(){
        scanner.close();
    }

}
