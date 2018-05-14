package Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import Mundo.*;

/**
 * Panel manejo de los datos de reserva
 */
public class PanelReserva extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando Agregar silla
     */
    private static final String AGREGAR = "AGREGAR";

    /**
     * Comando pago en efectivo
     */
    private static final String PAGAR_EFECTIVO = "PAGAR_EFECTIVO";

    /**
     * Comando pago con tarjeta
     */
    private static final String PAGAR_TARJETA = "PAGAR_TARJETA";

    /**
     * Comando cancelar
     */
    private static final String CANCELAR = "CANCELAR";

    /**
     * Comando guardar reserva
     */
    private static final String GUARDAR = "GUARDAR";

    /**
     * Comando cargar reserva
     */
    private static final String CARGAR = "CARGAR";

    /**
     * Comando de cambio de tipo de silla
     */
    private static final String CAMBIO_TIPO = "CAMBIO_TIPO";

    /**
     * Comando de cambio de fila
     */
    private static final String CAMBIO_FILA = "CAMBIO_FILA";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazCine ventana;

    /**
     * Cine de donde se saca la información
     */
    private Cine cine;

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Tipo de silla
     */
    private JComboBox cboTipoSilla;

    /**
     * Fila de la silla
     */
    private JComboBox cboFila;

    /**
     * Numero de la silla en la fila
     */
    private JComboBox cboNumero;

    /**
     * Botón agregar silla
     */
    private JButton btnAgregarSilla;

    /**
     * Botón Pagar en efectivo
     */
    private JButton btnPagoEfectivo;

    /**
     * Botón pagar con tarjeta
     */
    private JButton btnPagoTarjeta;

    /**
     * Botón Cancelar
     */
    private JButton btnCancelar;

    /**
     * Botón Guardar
     */
    private JButton btnGuardar;

    /**
     * Botón Cargar reserva
     */
    private JButton btnCargar;

    /**
     * Lista de sillas reservadas
     */
    private JList lstSillas;

    /**
     * Scroll para la lista
     */
    private JScrollPane scrollLista;

    /**
     * Etiqueta de sillas reservadas
     */
    private JLabel etiquetaSillasReservadas;

    /**
     * Etiqueta seleccionar silla
     */
    private JLabel etiquetaSeleccionarSilla;

    /**
     * Total Dinero
     */
    private JLabel etiquetaDinero;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param laVentana Ventana principal
     * @param elCine Cine
     */
    public PanelReserva( InterfazCine laVentana, Cine elCine )
    {
        ventana = laVentana;
        cine = elCine;

        setLayout( new GridBagLayout( ) );

        //Total dinero
        etiquetaDinero = new JLabel( "Total Dinero en la caja: $0" );

        //Combo Número
        cboNumero = new JComboBox( );
        cboNumero.setPreferredSize( new Dimension( 150, 20 ) );

        //Combo Fila
        cboFila = new JComboBox( );
        cboFila.setActionCommand( CAMBIO_FILA );
        cboFila.addActionListener( this );
        cboFila.setPreferredSize( new Dimension( 150, 20 ) );

        //Combo Tipo
        cboTipoSilla = new JComboBox( );
        cboTipoSilla.setActionCommand( CAMBIO_TIPO );
        cboTipoSilla.addActionListener( this );
        cboTipoSilla.addItem( "General" );
        cboTipoSilla.addItem( "Preferencial" );
        cboTipoSilla.setPreferredSize( new Dimension( 150, 20 ) );

        //Botón Agregar Silla
        btnAgregarSilla = new JButton( "Agregar Silla" );
        btnAgregarSilla.setActionCommand( AGREGAR );
        btnAgregarSilla.addActionListener( this );
        btnAgregarSilla.setPreferredSize( new Dimension( 140, 25 ) );

        //Botón pago efectivo
        btnPagoEfectivo = new JButton( "Pagar en Efectivo" );
        btnPagoEfectivo.setActionCommand( PAGAR_EFECTIVO );
        btnPagoEfectivo.addActionListener( this );
        btnPagoEfectivo.setPreferredSize( new Dimension( 140, 25 ) );

        //Botón pago tarjeta
        btnPagoTarjeta = new JButton( "Pagar con tarjeta" );
        btnPagoTarjeta.setActionCommand( PAGAR_TARJETA );
        btnPagoTarjeta.addActionListener( this );
        btnPagoTarjeta.setPreferredSize( new Dimension( 140, 25 ) );

        //Botón Cancelar
        btnCancelar = new JButton( "Eliminar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        btnCancelar.setPreferredSize( new Dimension( 140, 25 ) );

        //Botón Guardar
        btnGuardar = new JButton( "Guardar Reserva" );
        btnGuardar.setActionCommand( GUARDAR );
        btnGuardar.addActionListener( this );
        btnGuardar.setPreferredSize( new Dimension( 140, 25 ) );

        //Botón Cargar Reserva
        btnCargar = new JButton( "Cargar Reserva" );
        btnCargar.setActionCommand( CARGAR );
        btnCargar.addActionListener( this );
        btnCargar.setPreferredSize( new Dimension( 140, 25 ) );

        //Lista de sillas reservadas
        lstSillas = new JList( );
        lstSillas.setAutoscrolls( true );
        scrollLista = new JScrollPane( lstSillas );
        scrollLista.setPreferredSize( new Dimension( 120, 100 ) );

        //Etiquetas
        etiquetaSillasReservadas = new JLabel( "Sillas Reservadas:" );
        etiquetaSeleccionarSilla = new JLabel( "Seleccionar Silla:" );

        //Agrega los elementos

        JPanel panelDinero = new JPanel( );
        panelDinero.setBorder( new TitledBorder( "Dinero" ) );
        panelDinero.add( etiquetaDinero );

        GridBagConstraints posicion = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets( 3, 3, 3, 3 ), 0, 0 );
        add( panelDinero, posicion );

        //Panel Sillas
        JPanel panelSillas = new JPanel( new GridBagLayout( ) );
        panelSillas.setBorder( new TitledBorder( "Sillas de la Reserva" ) );

        posicion = new GridBagConstraints( 0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 3, 3, 3, 3 ), 0, 0 );
        panelSillas.add( etiquetaSeleccionarSilla, posicion );

        posicion = new GridBagConstraints( 0, 1, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 3, 3, 3, 3 ), 0, 0 );
        panelSillas.add( cboTipoSilla, posicion );

        posicion = new GridBagConstraints( 0, 3, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 3, 3, 3, 3 ), 0, 0 );
        panelSillas.add( cboFila, posicion );

        posicion = new GridBagConstraints( 0, 5, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 3, 3, 3, 3 ), 0, 0 );
        panelSillas.add( cboNumero, posicion );

        posicion = new GridBagConstraints( 2, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 3, 3, 3, 3 ), 0, 0 );
        panelSillas.add( btnAgregarSilla, posicion );

        posicion = new GridBagConstraints( 2, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 3, 3, 3, 3 ), 0, 0 );
        panelSillas.add( etiquetaSillasReservadas, posicion );

        posicion = new GridBagConstraints( 2, 1, 2, 6, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 3, 3, 3, 3 ), 0, 0 );
        panelSillas.add( scrollLista, posicion );

        posicion = new GridBagConstraints( 0, 1, 1, 4, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets( 3, 3, 3, 3 ), 0, 0 );
        add( panelSillas, posicion );

        //Panel Reserva
        JPanel panelReserva = new JPanel( new GridBagLayout( ) );
        panelReserva.setBorder( new TitledBorder( "Reserva" ) );

        posicion = new GridBagConstraints( 0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 3, 3, 3, 3 ), 0, 0 );
        panelReserva.add( btnCancelar, posicion );

        posicion = new GridBagConstraints( 1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 3, 3, 3, 3 ), 0, 0 );
        panelReserva.add( btnGuardar, posicion );

        posicion = new GridBagConstraints( 2, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 3, 3, 3, 3 ), 0, 0 );
        panelReserva.add( btnCargar, posicion );

        posicion = new GridBagConstraints( 0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 3, 3, 3, 3 ), 0, 0 );
        add( panelReserva, posicion );

        //Panel Pagos
        JPanel panelPagos = new JPanel( new GridLayout( 1, 2 ) );
        panelPagos.setBorder( new TitledBorder( "Pagar reserva" ) );

        panelPagos.add( btnPagoEfectivo );

        panelPagos.add( btnPagoTarjeta );

        posicion = new GridBagConstraints( 0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets( 3, 3, 3, 3 ), 0, 0 );
        add( panelPagos, posicion );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Repinta las reservas
     * @param reservaActual Reserva actual
     */
    public void repintar( Reserva reservaActual )
    {
        //Repinta la reserva
        lstSillas.removeAll( );
        ArrayList sillas = reservaActual.darSillas( );
        String[] listaSillas = new String[sillas.size( )];
        for( int i = 0; i < sillas.size( ); i++ )
        {
            Silla silla = ( Silla )sillas.get( i );
            listaSillas[ i ] = Character.toString( silla.darFila( ) ) + Integer.toString( silla.darNumero( ) );
        }
        lstSillas.setListData( listaSillas );

        //Recarga las sillas
        recargarSillas( );

        //Total dinero
        etiquetaDinero.setText( "Total Dinero en la caja: $" + cine.darTotalDinero( ) );
    }

    /**
     * Recarga las filas
     */
    private void recargarFilas( )
    {
        //Borra los elementos
        cboFila.removeAllItems( );
        cboNumero.removeAllItems( );

        //Selecciona el tipo de sillas
        String tipoSilla;
        if( cboTipoSilla.getSelectedItem( ) != null )
        {
            if( cboTipoSilla.getSelectedItem( ).equals( "General" ) )
            {
                tipoSilla = Silla.GENERAL;
            }
            else
            {
                tipoSilla = Silla.PREFERENCIAL;
            }

            //Busca las filas y las agrega
            char[] filas = cine.darFilas( tipoSilla );
            for( int i = 0; i < filas.length; i++ )
            {
                cboFila.addItem( new Character( filas[ i ] ) );
            }
        }
    }

    /**
     * Recarga las sillas para el tipo seleccionado, y la fila seleccionada
     */
    private void recargarSillas( )
    {
        try
        {
            cboNumero.removeAllItems( );
            if( cboFila.getSelectedItem( ) != null )
            {
                char fila = ( ( Character )cboFila.getSelectedItem( ) ).charValue( );
                ArrayList sillas = cine.darSillasDisponibles( fila );
                for( int i = 0; i < sillas.size( ); i++ )
                {
                    Silla silla = ( Silla )sillas.get( i );
                    cboNumero.addItem( new Integer( silla.darNumero( ) ) );
                }
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "Error al cargar las sillas: " + e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( CAMBIO_TIPO.equals( comando ) )
        {
            recargarFilas( );
        }
        else if( CAMBIO_FILA.equals( comando ) )
        {
            recargarSillas( );
        }
        else if( AGREGAR.equals( comando ) )
        {
            try
            {
                char fila = ( ( Character )cboFila.getSelectedItem( ) ).charValue( );
                int numero = ( ( Integer )cboNumero.getSelectedItem( ) ).intValue( );
                ventana.agregarSilla( fila, numero );
            }
            catch( Exception e2 )
            {
                JOptionPane.showMessageDialog( this, "Debe seleccionar una silla válida.", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( PAGAR_EFECTIVO.equals( comando ) )
        {
            ventana.pagarEfectivo( );
        }
        else if( PAGAR_TARJETA.equals( comando ) )
        {
            ventana.pagarTarjeta( );
        }
        else if( CANCELAR.equals( comando ) )
        {
            ventana.cancelarReserva( );
        }
        else if( GUARDAR.equals( comando ) )
        {
            ventana.guardar( );
        }
        else if( CARGAR.equals( comando ) )
        {
            ventana.cargar( );
        }
    }
}
