package models;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.source.tree.IfTree;

public class CalculoDeConversiones {
    public double conversionMonedas (Double monedaOrigen, Double monedaDestino, Double cantidad ){
        if (cantidad<0){return -1;}
        return (1/monedaOrigen)*cantidad*monedaDestino;
    }
}
