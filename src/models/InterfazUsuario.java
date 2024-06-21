package models;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfazUsuario {
    private DataConversion conversiones;
    private CalculoDeConversiones calculoDeConversiones = new CalculoDeConversiones();
    public InterfazUsuario(DataConversion dataConversion) {
        this.conversiones = dataConversion;
    }
    private void impresionResultado (Double monedaOrigen, Double monedaDestino, String simboloMonedaOrigen, String simboloDestino){
        Scanner lectura = new Scanner(System.in);
        Double cantidad;
        System.out.print("Ingrese el monto que desea convertir: ");
        try {
            cantidad = Double.valueOf(lectura.nextInt());
            System.out.println("La conversion de la cantidad de "+ cantidad + simboloMonedaOrigen + " a " +
                    simboloDestino + " es =" + String.format("%.2f",calculoDeConversiones.conversionMonedas (monedaOrigen, monedaDestino, cantidad) ) );
        }catch ( InputMismatchException e){
            System.out.println("Ingrese solamente numero con punto decimal");
            lectura.next();
        }
    }
    private void textoMenu (){
        System.out.println("1) Dolar (USD)");
        System.out.println("2) Peso Mexicano(MXN)");
        System.out.println("3) Peso Argentino(ARS)");
        System.out.println("4) Peso Colombiano(COP)");
        System.out.println("5) Euro (EUR)");
        System.out.println("6) Lira turca (TRY)");
        System.out.println("7) Salir");
        System.out.print("Elija una opción Válida: ");
    }
    private void subMenu (Double monedaOrigen, String simboloMonedaOrigen) {
        Scanner lectura = new Scanner(System.in);
        Integer inOpcion = 0;
        do {
            limpiarConsola();
            System.out.println("************************ Bienvenid@ al Conversor de Monedas. ************************\n");
            System.out.println("Divisa Origen "+ simboloMonedaOrigen +".");
            System.out.println("Selecione la moneda a la que desea convertir:");
            textoMenu();
            try {
                inOpcion = Integer.valueOf(lectura.nextInt());
                switch (inOpcion) {
                    case 1:
                        impresionResultado(monedaOrigen, conversiones.USD(), simboloMonedaOrigen, "USD");
                        break;
                    case 2:
                        impresionResultado(monedaOrigen, conversiones.MXN(), simboloMonedaOrigen, "MXN");
                        break;
                    case 3:
                        impresionResultado(monedaOrigen, conversiones.ARS(), simboloMonedaOrigen, "ARS");
                        break;
                    case 4:
                        impresionResultado(monedaOrigen, conversiones.COP(), simboloMonedaOrigen, "COP");
                        break;
                    case 5:
                        impresionResultado(monedaOrigen, conversiones.EUR(), simboloMonedaOrigen, "EUR");
                        break;
                    case 6:
                        impresionResultado(monedaOrigen, conversiones.TRY(), simboloMonedaOrigen, "TRY");
                        break;
                    case 7:
                        System.out.println("Regresando al menu anterior");
                        return;
                    default:
                        System.out.println("Opcion Invalida seleccione una opcion valida");
                }
            }catch ( InputMismatchException e){
                System.out.println("Ingrese solamente numeros");
                lectura.next();
            }

        }while (inOpcion != 7);
    }
    public void Menu() {
        Scanner lectura = new Scanner(System.in);
        Integer inOpcion = 0;
        do {
            System.out.println("************************ Bienvenid@ al Conversor de Monedas. ************************\n\n\n");
            System.out.println("Selecione la moneda que desea convertir:");
            textoMenu();
            try {

                inOpcion = Integer.valueOf(lectura.nextInt());
                switch (inOpcion){
                    case 1:
                        subMenu(conversiones.USD(), "USD");
                        break;
                    case 2:
                        subMenu(conversiones.MXN(), "MXN");
                        break;
                    case 3:
                        subMenu(conversiones.ARS(), "ARS");
                        break;
                    case 4:
                        subMenu(conversiones.COP(), "COP");
                        break;
                    case 5:
                        subMenu(conversiones.EUR(), "EUR");
                        break;
                    case 6:
                        subMenu(conversiones.TRY(), "TRY");
                        break;
                    case 7:
                        System.out.println("Gracias, hasta luego");
                        break;
                    default:
                        System.out.println("Opcion Invalida seleccione una opcion valida");
                }
            }catch ( InputMismatchException e){
                System.out.println("Ingrese solamente numeros");
                lectura.next();
            }
        }while (inOpcion != 7);

    }
    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
