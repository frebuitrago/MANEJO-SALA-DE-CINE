package Mundo;

/**
 * Clase que representa una tarjeta TARCINE
 */
public class Tarjeta
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Monto de carga inicial
     */
    public static final int CARGA_INICIAL = 70000;

    /**
     * Monto de recarga de la tarjeta
     */
    public static final int RECARGA = 50000;

    /**
     * Descuento por compra con tarjeta
     */
    public static final double DESCUENTO = 0.1;

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Dinero disponible en la tarjeta
     */
    private int dineroDisponible;

    /**
     * Cédula del usuario de la tarjeta
     */
    private int cedula;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor de la tarjeta
     * @param laCedula Cédula del dueño de la tarjeta
     */
    public Tarjeta( int laCedula )
    {
        cedula = laCedula;
        dineroDisponible = CARGA_INICIAL;
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Resta una cantidad especifica de la tarjeta. <br>
     * <b>pre: </b> cantidad > 0 && dineroDisponible > cantidad. <br>
     * <b>post: </b> dineroDisponible = dineroDisponible - cantidad.
     * @param cantidad Cantidad de dinero a restar.
     * @throws Exception No tiene los fondos necesarios.
     */
    public void restarDinero( int cantidad ) throws Exception
    {
        if( cantidad > dineroDisponible )
        {
            throw new Exception( "La tarjeta no tiene el cupo necesario." );
        }
        dineroDisponible -= cantidad;
    }

    /**
     * Recarga la tarjeta con el valor de la recarga. <br>
     * <b>post: </b> dineroDisponible = dineroDisponible + RECARGA.
     */
    public void recargar( )
    {
        dineroDisponible += RECARGA;
    }

    /**
     * Devuelve la cantidad de dinero disponible en la tarjeta.
     * @return Cantidad de dinero disponible en la tarjeta
     */
    public int darCantidadDisponible( )
    {
        return dineroDisponible;
    }

    /**
     * Devuelve la cédula del dueño de la tarjeta
     * @return Cédula del dueño de la tarjeta
     */
    public int darCedula( )
    {
        return cedula;
    }
}
