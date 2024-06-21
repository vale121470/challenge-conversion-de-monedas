package main;

import models.CalculoDeConversiones;
import models.ConsultarConversion;
import models.DataConversion;
import models.InterfazUsuario;

public class ChallengeMain {
    public static void main(String[] args) {
        ConsultarConversion consultarConversiones = new ConsultarConversion();
        CalculoDeConversiones calculoDeConversiones = new CalculoDeConversiones();
        DataConversion datosConversiones = consultarConversiones.ConsultarMoneda();
        InterfazUsuario interfazUsuario = new InterfazUsuario(datosConversiones);
        interfazUsuario.Menu();
        //System.out.println(calculoDeConversiones.conversionMonedas(datosConversiones.MXN(), datosConversiones.TRY(), 5.0));
    }
}
