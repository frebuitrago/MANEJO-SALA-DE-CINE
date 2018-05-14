package Mundo;

import java.util.ArrayList;

import Mundo.Silla;

/**
 * Clase que representa una reserva
 */
public class Reserva
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Cédula del cliente que realizó la reserva
     */
    private int cedula;

    /**
     * Sillas reservadas por el cliente
     */
    private ArrayList sillasReservadas;

    /**
     * Indica si la reserva ya fue pagada
     */
    private boolean pagada;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea una nueva reserva
     */
    public Reserva( )
    {
        cedula = 0;
        pagada = false;
        sillasReservadas = new ArrayList( );
    }

    /**
     * Devuelve la cédula del cliente que realizó la reserva
     * @return Cédula del cliente que realizó la reserva
     */
    public int darCedula( )
    {
        return cedula;
    }

    /**
     * Cambia la cédula de la reserva
     * @param laCedula Cédula del cliente
     */
    public void cambiarCedula( int laCedula )
    {
        cedula = laCedula;
    }

    /**
     * Agrega una nueva silla a la reserva. <br>
     * <b>pre: </b> El estado de la Silla es Disponible. <br>
     * <b>post: </b> El estado de la silla es reservada y está en la reserva.
     * @param silla Silla a agregar. silla != null.
     * @throws Exception La silla no está disponible
     */
    public void agregarSilla( Silla silla ) throws Exception
    {
        if( !silla.estaDisponible( ) )
        {
            throw new Exception( "No puede reservar la silla " + silla.darFila( ) + silla.darNumero( ) + ":\r\nLa silla no se encuentra disponible." );
        }
        silla.reservarSilla( );
        sillasReservadas.add( silla );
    }

    /**
     * Devuelve una ArrayList con las sillas incluidas en la reserva.
     * @return ArrayList con las sillas incluidas en la reserva.
     */
    public ArrayList darSillas( )
    {
        return sillasReservadas;
    }

    /**
     * Cancela la reserva <br>
     * <b>post: </b> Todas las sillas de la reserva quedan disponibles.
     */
    public void cancelar( )
    {
        for( int i = 0; i < sillasReservadas.size( ); i++ )
        {
            Silla silla = ( Silla )sillasReservadas.get( i );
            silla.dejarDisponible( );
        }
        sillasReservadas.clear( );
    }

    /**
     * Devuelve el costo actual de la reserva
     * @return Costo actual de la reserva
     */
    public int darSaldoReserva( )
    {
        int total = 0;
        for( int i = 0; i < sillasReservadas.size( ); i++ )
        {
            Silla silla = ( Silla )sillasReservadas.get( i );
            total += silla.darCosto( );
        }
        return total;
    }

    /**
     * Indica si la reserva ya fue pagada
     * @return true si está pagada, false en caso contrario
     */
    public boolean estaPagada( )
    {
        return pagada;
    }

    /**
     * Establece que la reserva ya fue pagada. <br>
     * <b>post: </b> La reserva queda pagada y Todas las sillas quedan vendidas.
     * @throws Exception Error generado cuando la reserva ya fue pagada
     */
    public void volverPagada( ) throws Exception
    {
        if( pagada )
        {
            throw new Exception( "La reserva ya fue pagada" );
        }
        pagada = true;
        for( int i = 0; i < sillasReservadas.size( ); i++ )
        {
            Silla silla = ( Silla )sillasReservadas.get( i );
            silla.venderSilla( );
        }
    }
}