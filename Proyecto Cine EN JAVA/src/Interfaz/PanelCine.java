package Interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import Mundo.*;

/**
 * Muestra el cine en la pantalla
 */
public class PanelCine extends JPanel
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Color de silla disponible en general
     */
    private static final Color COLOR_DISPONIBLE_GENERAL = Color.WHITE;

    /**
     * Color de silla disponible en preferencial
     */
    private static final Color COLOR_DISPONIBLE_PREFERENCIAL = Color.LIGHT_GRAY;

    /**
     * Color de silla reservada
     */
    private static final Color COLOR_RESERVADO = Color.YELLOW;

    /**
     * Color de silla vendida
     */
    private static final Color COLOR_VENDIDO = Color.RED;

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Sillas de la sala de cine
     */
    private Silla[] sillas;

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiquetas de las sillas
     */
    private JLabel[] etiquetaSillas;

    /**
     * Etiqueta de la pantalla
     */
    private JLabel etiquetaPantalla;

    //-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------

    /**
     * Construye el panel con las sillas
     * @param lasSillas Sillas de la sala de cine
     */
    public PanelCine( Silla[] lasSillas )
    {
        sillas = lasSillas;
        setLayout( new GridBagLayout( ) );
        setBorder( new TitledBorder( "Sala" ) );

        //Pinta las sillas
        etiquetaSillas = new JLabel[sillas.length];
        int fila = 2;
        int numero = 0;
        for( int i = 0; i < sillas.length; i++ )
        {
            Silla silla = sillas[ i ];
            if( silla.darNumero( ) < 10 )
            {
                etiquetaSillas[ i ] = new JLabel( Character.toString( silla.darFila( ) ) + "0" + Integer.toString( silla.darNumero( ) ) );
            }
            else
            {
                etiquetaSillas[ i ] = new JLabel( Character.toString( silla.darFila( ) ) + Integer.toString( silla.darNumero( ) ) );
            }
            etiquetaSillas[ i ].setBackground( darColorSilla( silla ) );
            etiquetaSillas[ i ].setFont( etiquetaSillas[ i ].getFont( ).deriveFont( ( float )10 ) );
            etiquetaSillas[ i ].setPreferredSize( new Dimension( 22, 22 ) );
            etiquetaSillas[ i ].setBorder( new LineBorder( Color.GRAY ) );
            etiquetaSillas[ i ].setOpaque( true );
            etiquetaSillas[ i ].setHorizontalAlignment( JLabel.CENTER );

            //Ubica la silla
            GridBagConstraints posicion = new GridBagConstraints( numero, fila, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 1, 1, 1, 1 ), 0, 0 );
            add( etiquetaSillas[ i ], posicion );
            numero++;
            if( numero == Cine.SILLAS_POR_FILA )
            {
                fila++;
                numero = 0;
            }
        }

        //Pinta la pantalla
        etiquetaPantalla = new JLabel( "PANTALLA" );
        etiquetaPantalla.setHorizontalAlignment( JLabel.CENTER );
        etiquetaPantalla.setBackground( Color.CYAN );
        etiquetaPantalla.setOpaque( true );
        etiquetaPantalla.setBorder( new LineBorder( Color.GRAY ) );
        etiquetaPantalla.setPreferredSize( new Dimension( ( Cine.SILLAS_POR_FILA - 4 ) * 22, 30 ) );
        GridBagConstraints posicion = new GridBagConstraints( 2, 0, ( Cine.SILLAS_POR_FILA - 4 ), 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 5, 5, 50, 5 ), 0, 0 );
        add( etiquetaPantalla, posicion );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Repinta las sillas de la sala
     */
    public void repintar( )
    {
        for( int i = 0; i < sillas.length; i++ )
        {
            Silla silla = sillas[ i ];
            etiquetaSillas[ i ].setBackground( darColorSilla( silla ) );
        }
    }

    /**
     * Devuelve el color de una silla especifica
     * @param silla Silla a calcular el color
     * @return Color de la silla
     */
    private Color darColorSilla( Silla silla )
    {
        if( silla.estaDisponible( ) )
        {
            if( silla.esGeneral( ) )
            {
                return COLOR_DISPONIBLE_GENERAL;
            }
            else
            {
                return COLOR_DISPONIBLE_PREFERENCIAL;
            }
        }
        else if( silla.estaReservada( ) )
        {
            return COLOR_RESERVADO;
        }
        else
        {
            return COLOR_VENDIDO;
        }
    }
}