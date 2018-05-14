package Mundo;

/**
 * Representa una silla en el teatro
 */
public class Silla
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Tipo de silla General
     */
    public static final String GENERAL = "GENERAL";

    /**
     * Tipo de silla Preferencial
     */
    public static final String PREFERENCIAL = "PREFERENCIAL";

    /**
     * Costo de una silla en general
     */
    private static final int COSTO_GENERAL = 8000;

    /**
     * Costo de una silla en preferencial
     */
    private static final int COSTO_PREFERENCIAL = 11000;

    /**
     * Estado de silla libre
     */
    private static final String ESTADO_DISPONIBLE = "DISPONIBLE";

    /**
     * Estado de silla reservada
     */
    private static final String ESTADO_RESERVADA = "RESERVADA";

    /**
     * Estado de silla vendida
     */
    private static final String ESTADO_VENDIDA = "VENDIDA";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ubicación de la silla en el teatro
     */
    private char fila;

    /**
     * Tipo de Silla
     */
    private String tipo;

    /**
     * Número de la silla en la fila
     */
    private int numero;

    /**
     * Estado de la silla
     */
    private String estado;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor de la silla
     * @param filaSilla Ubicación de la silla
     * @param numeroSilla Número de la silla en la fila
     * @param tipoSilla Tipo de la silla. tipoSilla pertenece a {GERENCIAL, PREFERENCIAL}
     */
    public Silla( char filaSilla, int numeroSilla, String tipoSilla )
    {
        fila = filaSilla;
        numero = numeroSilla;
        tipo = tipoSilla;
        estado = ESTADO_DISPONIBLE;
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Devuelve la fila de la silla
     * @return Fila de la silla
     */
    public char darFila( )
    {
        return fila;
    }

    /**
     * Devuelve el número de la silla en la fila
     * @return Numero de la silla en la fila
     */
    public int darNumero( )
    {
        return numero;
    }

    /**
     * Devuelve el costo de la silla
     * @return Costo de la silla
     */
    public int darCosto( )
    {
        if( tipo.equals( GENERAL ) )
        {
            return COSTO_GENERAL;
        }
        else
        {
            return COSTO_PREFERENCIAL;
        }
    }

    /**
     * Indica si la silla está disponible
     * @return verdadero si la silla está disponible, falso en caso contrario
     */
    public boolean estaDisponible( )
    {
        return estado == ESTADO_DISPONIBLE;
    }

    /**
     * Deja una silla en estado disponible
     */
    public void dejarDisponible( )
    {
        estado = ESTADO_DISPONIBLE;
    }

    /**
     * Indica si la silla está vendida
     * @return verdadero si la silla está vendida, falso en caso contrario
     */
    public boolean estaVendida( )
    {
        return estado == ESTADO_VENDIDA;
    }

    /**
     * Deja una silla en estado vendida
     */
    public void venderSilla( )
    {
        estado = ESTADO_VENDIDA;
    }

    /**
     * Indica si la silla está reservada
     * @return verdadero si la silla está reservada, falso en caso contrario
     */
    public boolean estaReservada( )
    {
        return estado == ESTADO_RESERVADA;
    }

    /**
     * Deja una silla en estado reservada
     */
    public void reservarSilla( )
    {
        estado = ESTADO_RESERVADA;
    }

    /**
     * Indica si la silla es de tipo general
     * @return verdadero si la silla es de tipo general, falso en caso contrario
     */
    public boolean esGeneral( )
    {
        return tipo == GENERAL;
    }

    /**
     * Indica si la silla es de tipo preferencial
     * @return verdadero si la silla es de tipo preferencial, falso en caso contrario
     */
    public boolean esPreferencial( )
    {
        return tipo == PREFERENCIAL;
    }
}