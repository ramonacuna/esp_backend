
package com.espe.tipos_contratos.utilidad.validacion;
import com.espe.infrastructure.exception.ValidationException;

public class TipoContratoValidar {
     private static final  int LONGITUD = 150;

    public TipoContratoValidar() {
    }
     
    private static void validarNombreVacio(String nombre) {
    if(nombre == null || nombre.trim().isEmpty()) {
        throw new ValidationException("Nombre tipo de contrato requerido");
        }
    }
     
    public static void validarLongitud(String nombre, int maximo) {
    if(nombre.trim().length() > maximo) {
        throw new ValidationException("Longitud superada");
        }
    }
     
    public static void validarNombre(String nombre) {
    validarNombreVacio(nombre);
    validarLongitud(nombre, LONGITUD);
    }
}
