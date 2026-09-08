import controller.CajeroController;
import view.CajeroView;

public class Main {
    public static void main(String[] arg){
        CajeroView vista = new CajeroView();
        CajeroController controlador = new CajeroController(vista);
        controlador.iniciar();
    }

}
