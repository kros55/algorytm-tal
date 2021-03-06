package pl.edu.wat.tal.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import pl.edu.wat.tal.algorytmy.AlgorytmBruteForce;
import pl.edu.wat.tal.algorytmy.AlgorytmLayering;
import pl.edu.wat.tal.graf.Graf;
import pl.edu.wat.tal.helper.CommonVariables;
import pl.edu.wat.tal.helper.GrafGenerator;
import pl.edu.wat.tal.helper.StatisticsAlgorithmsHelper;
import pl.edu.wat.tal.messages.Messages;
import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;

public class App
{

    private static JFrame frame;
    private static JTextField tfNumberOfMeasurements;
    private static Messages singletonMessages;
    private static JTextField tfNumberOfGraphs;
    private static JTextArea textArea;
    private static JCheckBox chkBoxBruteForceAlgorithm;
    private static JCheckBox chkBoxLayerAlgorithm;
    private static JCheckBox chkBoxComputeComplexity;
    private static JSpinner spinnerVertexFrom;
    private static JSpinner spinnerVertextTo;
    private static JRadioButton rbRandomWeight;
    private static JRadioButton rbStateWeight;
    private static JSlider sliderDensityGraph;
    private static JCheckBox chkBoxComputeMemory;
    private static JRadioButton rdbtnWagiLosoweZ;
    private static JLabel lblNewLabel_4;

    /**
     * Launch the application.
     */
    public static void main( String[] args )
    {

        EventQueue.invokeLater( new Runnable()
        {
            public void run()
            {
                try
                {
                    App window = new App();
                    window.frame.setVisible( true );
                    // runAlgorithms();
                }
                catch ( Exception e )
                {
                    e.printStackTrace();
                }
            }
        } );
    }

    /**
     * Create the application.
     */
    public App()
    {

        try
        {
            UIManager.setLookAndFeel( new SyntheticaClassyLookAndFeel() );
        }
        catch ( UnsupportedLookAndFeelException | ParseException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frame = new JFrame( "FVS ALGORITHM GURNIAK JEDYNAK" );
        frame.setBounds( 350, 150, 1215, 798 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( new GridLayout( 1, 0, 0, 0 ) );

        JPanel panel = new JPanel();
        frame.getContentPane().add( panel );
        panel.setLayout( new GridLayout( 1, 0, 0, 0 ) );

        textArea = new JTextArea();
        // panel.add( textArea );

        textArea.setEditable( false );
        JScrollPane scroll = new JScrollPane( textArea );
        scroll.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        panel.add( scroll );

        JPanel panel_1 = new JPanel();
        panel.add( panel_1 );
        panel_1.setLayout( new GridLayout( 3, 1 ) );

        JPanel panel_3 = new JPanel();
        panel_1.add( panel_3 );
        panel_3.setLayout( new GridLayout( 2, 1 ) );

        JPanel panel_3a = new JPanel();
        panel_3a.setLayout( new GridLayout( 3, 1 ) );
        panel_3.add( panel_3a );

        JLabel lbChooseAlgorithm = new JLabel( "Wyb�r algorytmu" );
        lbChooseAlgorithm.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );
        lbChooseAlgorithm.setHorizontalAlignment( SwingConstants.CENTER );
        panel_3a.add( lbChooseAlgorithm );

        chkBoxBruteForceAlgorithm = new JCheckBox( "Algorytm Brute-force" );
        chkBoxBruteForceAlgorithm.addItemListener( new ItemListener()
        {
            public void itemStateChanged( ItemEvent arg0 )
            {
                if ( chkBoxBruteForceAlgorithm.isSelected() )
                {
                    // textArea.setText( "Wybrano algorytm Brute Force" );
                    CommonVariables.getInstance().GENERUJ_ALGORYTM_BRUTE_FORCE = true;
                }
                else
                {
                    // textArea.setText( "Nie wybrano algorytm Brute Force" );
                    CommonVariables.getInstance().GENERUJ_ALGORYTM_BRUTE_FORCE = false;
                }
            }
        } );

        /*        chkBoxBruteForceAlgorithm.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent arg0) {
                        if(chkBoxBruteForceAlgorithm.isSelected())
                        {
                            textArea.setText( "Wybrano algorytm Brute Force" );
                        }else
                        {
                            textArea.setText( "Nie wybrano algorytm Brute Force" );
                        }
                    }
                });*/
        chkBoxBruteForceAlgorithm.setSelected( true );
        panel_3a.add( chkBoxBruteForceAlgorithm );

        chkBoxLayerAlgorithm = new JCheckBox( "Algorytm warstwowy" );
        chkBoxLayerAlgorithm.addItemListener( new ItemListener()
        {
            public void itemStateChanged( ItemEvent e )
            {
                if ( chkBoxLayerAlgorithm.isSelected() )
                {
                    // textArea.setText( "Wybrano algorytm Warstwowy" );
                    CommonVariables.getInstance().GENERUJ_ALGORYTM_WARSTWOWY = true;
                }
                else
                {
                    // textArea.setText( "Nie wybrano algorytm Warstwowy" );
                    CommonVariables.getInstance().GENERUJ_ALGORYTM_WARSTWOWY = false;
                }
            }
        } );
        /*        chkBoxLayerAlgorithm.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        if(chkBoxLayerAlgorithm.isSelected())
                        {
                            textArea.setText( "Wybrano algorytm Warstwowy" );
                        }else
                        {
                            textArea.setText( "Nie wybrano algorytm Warstwowy" );
                        }
                    }
                });*/

        chkBoxLayerAlgorithm.setSelected( true );
        panel_3a.add( chkBoxLayerAlgorithm );

        JPanel panel_3b = new JPanel();
        panel_3.add( panel_3b );
        panel_3b.setLayout( new GridLayout( 3, 1 ) );

        JLabel lblNewLabel_1 = new JLabel( "Typ pomiaru" );
        lblNewLabel_1.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );
        lblNewLabel_1.setHorizontalAlignment( SwingConstants.CENTER );
        panel_3b.add( lblNewLabel_1 );

        chkBoxComputeComplexity = new JCheckBox( "Czas wykonania" );
        chkBoxComputeComplexity.addItemListener( new ItemListener()
        {
            public void itemStateChanged( ItemEvent e )
            {
                if ( chkBoxComputeComplexity.isSelected() )
                {
                    // textArea.setText(
                    // "Wybrano pomiar z�o�ono�ci obliczeniowej" );
                    CommonVariables.getInstance().GENERUJ_POMIAR_ZLOZONOSCI_OBLICZENIOWEJ = true;
                }
                else
                {
                    // textArea.setText(
                    // "Nie wybrano pomiar z�o�ono�ci obliczeniowej" );
                    CommonVariables.getInstance().GENERUJ_POMIAR_ZLOZONOSCI_OBLICZENIOWEJ = false;
                }
            }
        } );

        chkBoxComputeComplexity.setSelected( true );
        panel_3b.add( chkBoxComputeComplexity );

        chkBoxComputeMemory = new JCheckBox( "Z�o�ono�� pami�ciowa" );
        chkBoxComputeMemory.addItemListener( new ItemListener()
        {
            public void itemStateChanged( ItemEvent e )
            {
                if ( chkBoxComputeMemory.isSelected() )
                {
                    CommonVariables.getInstance().GENERUJ_POMIAR_ZLOZONOSCI_PAMIECIOWEJ = true;
                }
                else
                {
                    CommonVariables.getInstance().GENERUJ_POMIAR_ZLOZONOSCI_PAMIECIOWEJ = false;
                }
            }
        } );
        chkBoxComputeMemory.setEnabled( false );
        panel_3b.add( chkBoxComputeMemory );

        JPanel panel_10 = new JPanel();
        panel_10.setLayout( new GridLayout( 4, 1 ) );
        panel_1.add( panel_10 );

        JPanel panel_5 = new JPanel();
        panel_10.add( panel_5 );
        panel_5.setBounds( 0, 2, 392, 45 );

        JLabel lblNewLabel_2 = new JLabel( "Ustawienia generatora" );
        panel_5.add( lblNewLabel_2 );
        lblNewLabel_2.setHorizontalAlignment( SwingConstants.CENTER );
        lblNewLabel_2.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );

        JPanel panel_7 = new JPanel();
        panel_10.add( panel_7 );
        panel_7.setBounds( 0, 137, 392, 45 );
        panel_7.setLayout( null );

        JLabel label_1 = new JLabel( "Liczba generowanych graf�w" );
        label_1.setBounds( 206, 8, 183, 14 );
        panel_7.add( label_1 );

        tfNumberOfGraphs = new JTextField();
        tfNumberOfGraphs.setColumns( 10 );
        tfNumberOfGraphs.setBounds( 10, 8, 48, 20 );
        panel_7.add( tfNumberOfGraphs );
        tfNumberOfGraphs.setText(CommonVariables.getInstance().LICZBA_GENEROWANYCH_GRAFOW_W_SERII + "");

        JPanel panel_8 = new JPanel();
        panel_10.add( panel_8 );
        panel_8.setLayout( new GridLayout( 1, 3 ) );

        rbRandomWeight = new JRadioButton( "wagi losowe bez powt�rze�" );
        rbRandomWeight.addItemListener( new ItemListener()
        {
            public void itemStateChanged( ItemEvent e )
            {
                if ( rbRandomWeight.isSelected() )
                {
                    // textArea.setText( "Wybrano wag� losow�" );
                    // CommonVariables.getInstance().CZY_WAGOWY = true;
                    CommonVariables.getInstance().WAGI_ROWNE_JEDEN = false;
                    CommonVariables.getInstance().WAGI_LOSOWE_BEZ_POWTORZEN = true;
                    CommonVariables.getInstance().WAGI_LOSOWE_Z_POWTORZENIAMI = false;

                }
            }
        } );
        panel_8.add( rbRandomWeight );
        rbRandomWeight.setSelected( true );
        rbRandomWeight.setHorizontalAlignment( SwingConstants.LEFT );

        rbStateWeight = new JRadioButton( "wagi sta�e" );
        rbStateWeight.addItemListener( new ItemListener()
        {
            public void itemStateChanged( ItemEvent e )
            {
                if ( rbStateWeight.isSelected() )
                {
                    // textArea.setText( "Wybrano sta�� wag�" );
                    CommonVariables.getInstance().WAGI_ROWNE_JEDEN = true;
                    CommonVariables.getInstance().WAGI_LOSOWE_BEZ_POWTORZEN = false;
                    CommonVariables.getInstance().WAGI_LOSOWE_Z_POWTORZENIAMI = false;

                }
            }
        } );

        rdbtnWagiLosoweZ = new JRadioButton( "wagi losowe z powt�rzeniami" );
        rdbtnWagiLosoweZ.addItemListener( new ItemListener()
        {

            @Override
            public void itemStateChanged( ItemEvent arg0 )
            {
                if ( rdbtnWagiLosoweZ.isSelected() )
                {
                    CommonVariables.getInstance().WAGI_ROWNE_JEDEN = false;
                    CommonVariables.getInstance().WAGI_LOSOWE_BEZ_POWTORZEN = false;
                    CommonVariables.getInstance().WAGI_LOSOWE_Z_POWTORZENIAMI = true;
                }

            }
        } );
        panel_8.add( rdbtnWagiLosoweZ );
        panel_8.add( rbStateWeight );
        rbStateWeight.setHorizontalAlignment( SwingConstants.LEFT );

        ButtonGroup btButtonGroup = new ButtonGroup();
        btButtonGroup.add( rbRandomWeight );
        btButtonGroup.add( rbStateWeight );
        btButtonGroup.add( rdbtnWagiLosoweZ );

        JPanel panel_9 = new JPanel();
        panel_10.add( panel_9 );
        panel_9.setLayout( new GridLayout( 2, 1 ) );

        lblNewLabel_4 = new JLabel( "G�sto�� grafu [ 0.00 ]" );
        lblNewLabel_4.setHorizontalAlignment( SwingConstants.CENTER );
        panel_9.add( lblNewLabel_4 );

        sliderDensityGraph = new JSlider();
        sliderDensityGraph.addChangeListener( new ChangeListener()
        {
            public void stateChanged( ChangeEvent e )
            {
                int value = sliderDensityGraph.getValue();
                double setValue = value / 100.0;
                lblNewLabel_4.setText( "G�sto�� grafu [ " + setValue + " ]" );
                // textArea.setText( "Slider value = " + setValue );
                CommonVariables.getInstance().GESTOSC_GRAFU = setValue;

            }
        } );
        sliderDensityGraph.setToolTipText( "Ustaw g�sto�� grafu z zakresu 0,01 - 1,00" );
        sliderDensityGraph.setSnapToTicks( true );
        sliderDensityGraph.setPaintTicks( true );
        sliderDensityGraph.setPaintLabels( true );
        sliderDensityGraph.setMinorTickSpacing( 1 );
        sliderDensityGraph.setValue( 0 );
        panel_9.add( sliderDensityGraph );

        JPanel panel_2 = new JPanel();
        panel_1.add( panel_2 );
        panel_2.setLayout( new GridLayout( 4, 1 ) );

        JPanel panel_4 = new JPanel();
        panel_2.add( panel_4 );
        panel_4.setBounds( 0, 92, 392, 45 );
        panel_4.setLayout( null );

        JLabel label = new JLabel( "Zakres wierzcho�k�w w serii" );
        label.setBounds( 202, 14, 187, 14 );
        panel_4.add( label );

        spinnerVertexFrom = new JSpinner();
        spinnerVertexFrom.setModel( new SpinnerNumberModel( 3, 3, 16, 1 ) );
        spinnerVertexFrom.setBounds( 36, 11, 39, 20 );
        panel_4.add( spinnerVertexFrom );

        spinnerVertextTo = new JSpinner();
        spinnerVertextTo.setModel( new SpinnerNumberModel( 3, 3, 16, 1 ) );
        spinnerVertextTo.setBounds( 119, 11, 39, 20 );
        panel_4.add( spinnerVertextTo );

        JLabel lblOd = new JLabel( "od" );
        lblOd.setBounds( 10, 14, 16, 14 );
        panel_4.add( lblOd );

        JLabel lblDo = new JLabel( "do" );
        lblDo.setBounds( 93, 14, 16, 14 );
        panel_4.add( lblDo );

        JPanel panel_6 = new JPanel();
        panel_6.setBounds( 0, 47, 392, 45 );
        panel_2.add( panel_6 );
        panel_6.setLayout( null );

        tfNumberOfMeasurements = new JTextField();
        tfNumberOfMeasurements.setBounds( 10, 11, 48, 20 );
        panel_6.add( tfNumberOfMeasurements );
        tfNumberOfMeasurements.setColumns( 10 );
        
        tfNumberOfMeasurements.setText(CommonVariables.getInstance().LICZBA_SERII_POMIAROW_DLA_JEDNEGO_ZADANIA + "");

        JLabel lblNewLabel_3 = new JLabel( "Ilo�� pomiar�w dla zadania" );
        lblNewLabel_3.setBounds( 204, 14, 185, 14 );
        panel_6.add( lblNewLabel_3 );

        JPanel panel_11 = new JPanel();
        panel_2.add( panel_11 );

        JLabel lblRozpocznijSymulacj = new JLabel( "Rozpocznij symulacj�" );
        lblRozpocznijSymulacj.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );
        panel_11.add( lblRozpocznijSymulacj );

        JPanel panel_12 = new JPanel();
        panel_2.add( panel_12 );

        JButton btnStart = new JButton( "Start" );

        btnStart.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent arg0 )
            {
                // textArea.setText( "Wci�ni�to Start i rozpocz�to symulacj�\n"
                // );
                // textArea.append( "Liczba generowanych graf�w = " +
                // tfNumberOfGraphs.getText() + "\n" );
                // textArea.append( "Ilo�� pomiar�w dla zadania = " +
                // tfNumberOfMeasurements.getText() + "\n" );
                // textArea.append( "Od = " + spinnerVertexFrom.getValue() +
                // "\n" );
                // textArea.append( "Do = " + spinnerVertextTo.getValue() + "\n"
                // );

                if ( /* !tfNumberOfGraphs.getText().toString().trim().isEmpty() && */!tfNumberOfGraphs.getText().equals(
                        new String( "" ) ) )
                {
                    CommonVariables.getInstance().LICZBA_GENEROWANYCH_GRAFOW_W_SERII = Integer.valueOf( tfNumberOfGraphs.getText() );
                }
                else
                {
                    System.out.println( "Podaj liczb� w ilo�ci generowanych graf�w!" );
                }
                if ( /*!tfNumberOfMeasurements.getText().trim().isEmpty() && */!tfNumberOfMeasurements.getText().equals(
                        new String( "" ) ) )
                {
                    CommonVariables.getInstance().LICZBA_SERII_POMIAROW_DLA_JEDNEGO_ZADANIA = Integer.valueOf( tfNumberOfMeasurements.getText() );
                }
                else
                {
                    System.out.println( "Podaj liczb� w ilo�� pomiar�w dla zadania!" );
                }
                // CommonVariables.getInstance().LICZBA_SERII_POMIAROW_DLA_JEDNEGO_ZADANIA
                // = Integer.valueOf( tfNumberOfMeasurements.getText().trim() );
                CommonVariables.getInstance().SERIA_POMIAROW_OD = (int) spinnerVertexFrom.getValue();
                CommonVariables.getInstance().SERIA_POMIAROW_DO = (int) spinnerVertextTo.getValue();

                setDisableComponents();
                
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                    	//JOptionPane.showMessageDialog(frame, "Prosz� czeka�...");
                    	runAlgorithms();
                    }
                }); 
                
                //runAlgorithms();
                setEnableComponents();

            }
        } );
        btnStart.setForeground( new Color( 0, 0, 0 ) );
        panel_12.add( btnStart );
    }

    public static void runAlgorithms()
    {
    	textArea.setText("");
        StringBuilder results = new StringBuilder();
        GrafGenerator gg = new GrafGenerator();
        AlgorytmBruteForce abf;
        AlgorytmLayering al;
        StatisticsAlgorithmsHelper stAlgorithmsHelperForBF;
        StatisticsAlgorithmsHelper stAlgorithmsHelperForLayer;
        ArrayList<ArrayList<Long>> bfAlgorithmResults = new ArrayList<ArrayList<Long>>(
                CommonVariables.getInstance().LICZBA_GENEROWANYCH_GRAFOW_W_SERII );
        ArrayList<ArrayList<Long>> layerAlgorithmResults = new ArrayList<ArrayList<Long>>(
                CommonVariables.getInstance().LICZBA_GENEROWANYCH_GRAFOW_W_SERII );
        HashMap<String, ArrayList<Long>> resultsForCompare;

        // inicjalizacja element�w listy w zale�no�ci od liczby zada�
        for ( int i = 0; i < CommonVariables.getInstance().LICZBA_GENEROWANYCH_GRAFOW_W_SERII; i++ )
        {
            bfAlgorithmResults.add( new ArrayList<Long>() );
            layerAlgorithmResults.add( new ArrayList<Long>() );
        }

        int iloscSerii = CommonVariables.getInstance().SERIA_POMIAROW_DO
                         - CommonVariables.getInstance().SERIA_POMIAROW_OD + 1;

        for ( int i = 0; i < iloscSerii; i++ )
        {
            int aktualnaSeria = CommonVariables.getInstance().SERIA_POMIAROW_OD + i;
            //results.append( "Seria pomiar�w numer [" + ( i + 1 ) + "], rozmiar problemu [" + aktualnaSeria + "]\n" );
            textArea.append( "Seria pomiar�w numer [" + ( i + 1 ) + "], rozmiar problemu [" + aktualnaSeria + "]:\n\n" );
            System.out.println( "Seria pomiar�w numer [" + ( i + 1 ) + "], rozmiar problemu [" + aktualnaSeria + "]" );
            

            for ( int j = 0; j < CommonVariables.getInstance().LICZBA_GENEROWANYCH_GRAFOW_W_SERII; j++ )
            {
                Graf g = gg.generujGrafCykliczny( aktualnaSeria,
                        CommonVariables.getInstance().LICZBA_SPOJNYCH_SKLADOWYCH_W_GRAFIE,
                        CommonVariables.getInstance().CZY_WAGOWY, CommonVariables.getInstance().WAGI_ROWNE_JEDEN, CommonVariables.getInstance().WAGI_LOSOWE_BEZ_POWTORZEN, CommonVariables.getInstance().WAGI_LOSOWE_Z_POWTORZENIAMI);
                //results.append( "Wygenerowano graf numer [" + ( j + 1 ) + "]\n" );
                textArea.append( "	Wygenerowano graf numer [" + ( j + 1 ) + "]: " + g + "\n\n" );
                System.out.println( "    Wygenerowano graf numer [" + ( j + 1 ) + "]" );
                	
                for ( int k = 0; k < CommonVariables.getInstance().LICZBA_SERII_POMIAROW_DLA_JEDNEGO_ZADANIA; k++ )
                {
                    //results.append( "        Przeprowadzono pomiar numer [" + ( k + 1 ) + "]" );
                	textArea.append( "		Przeprowadzono pomiar numer [" + ( k + 1 ) + "]:\n\n" );
                    System.out.println( "        Przeprowadzono pomiar numer [" + ( k + 1 ) + "]" );

                    
                    
                    // stAlgorithmsHelperForBF = new StatisticsAlgorithmsHelper(
                    // CommonVariables.ALGORITHM_BRUTE_FORCE );
                    stAlgorithmsHelperForLayer = new StatisticsAlgorithmsHelper( CommonVariables.ALGORITHM_LAYERING );

                    // stAlgorithmsHelperForBF.startCalculateComplexity();
                    // long bytesStart = Runtime.getRuntime().freeMemory();
                    double minSumaWagBF = 0.0;
                    double minSumaWagL = 0.0;
                    
                    if(CommonVariables.getInstance().GENERUJ_ALGORYTM_BRUTE_FORCE) {
                    	abf = new AlgorytmBruteForce( g );
                    	StringBuilder resAbf = abf.compute();
                    	textArea.append( resAbf.toString() );
                    	long czas = abf.getCalculateComplexityWrapper();
                    	textArea.append("			Czas: " + czas + " [ns]\n");
                    	bfAlgorithmResults.get( j ).add( czas );
                    	
                    	minSumaWagBF = abf.getMinSumaWag();
                    }
                    
                    if(CommonVariables.getInstance().GENERUJ_ALGORYTM_WARSTWOWY) {
                    	if(CommonVariables.getInstance().GENERUJ_ALGORYTM_BRUTE_FORCE) {
                    		textArea.append("\n");
                    	}
                    	
                    	al = new AlgorytmLayering( g );
                    	StringBuilder resLayer = al.compute();
                    	textArea.append( resLayer.toString() );
                    	long czas = al.getCalculateComplexityWrapper();
                    	textArea.append("			Czas: " + czas + " [ns]\n");
                    	layerAlgorithmResults.get( j ).add( czas );
                    	
                    	minSumaWagL = al.getMinSumaWag();
                    }
                    
                    if(CommonVariables.getInstance().GENERUJ_ALGORYTM_BRUTE_FORCE && CommonVariables.getInstance().GENERUJ_ALGORYTM_WARSTWOWY) {
                    	textArea.append("\n");
                    	if(minSumaWagBF > minSumaWagL) {
                    		double procent = ((minSumaWagBF/minSumaWagL)-1.0)*100.0;
                    		procent = (double) Math.round(procent * 1000) / 1000;
                    		textArea.append("			Algorytm Layering by� lepszy od algorytmu Brute-Force o [" + (minSumaWagBF - minSumaWagL) + "], czyli by� o " + procent + "% lepszy\n");
                    	} else if(minSumaWagL > minSumaWagBF) {
                    		double procent = ((minSumaWagL/minSumaWagBF)-1.0)*100.0;
                    		procent = (double) Math.round(procent * 1000) / 1000;
                    		textArea.append("			Algorytm Brute-Force by� lepszy od algorytmu Layering o [" + (minSumaWagL - minSumaWagBF) + "], czyli by� o " + procent + "% lepszy\n");
                    	} else {
                    		textArea.append("			Wyniki obu algorytm�w by�y r�wnie dobre\n");
                    	}
                    }
                    
                    //results.append( resAbf.toString() );
                    
                    // long bytesStop = Runtime.getRuntime().freeMemory();
                    // System.out.println("pamiec: " + (bytesStart -
                    // bytesStop));
                    // stAlgorithmsHelperForBF.stopCalculateComplexity();
                    // bfAlgorithmResults.get( j ).add(
                    // stAlgorithmsHelperForBF.showResult() );
                    

                    //results.append( "\n-----------------------------------------------------\n" );
                    System.out.println( "\n-----------------------------------------------------" );

                    // stAlgorithmsHelperForLayer.startCalculateComplexity();
                    // long bytesStart2 = Runtime.getRuntime().freeMemory();
                    
                    //results.append( resLayer.toString() );
                    

                    // long bytesStop2 = Runtime.getRuntime().freeMemory();
                    // System.out.println("pamiec2: " + (bytesStart2 -
                    // bytesStop2));
                    // stAlgorithmsHelperForLayer.stopCalculateComplexity();
                    // layerAlgorithmResults.get( j ).add(
                    // stAlgorithmsHelperForLayer.showResult() );
                    

                    //results.append( "\n==========================================================================================================\n" );
                    System.out.println( "\n==========================================================================================================" );
                    textArea.append("\n");
                }

                //results.append( "\n-----------------------------------------------------\n" );
                //results.append( "Z�O�NO�� ALGORYTMU BRUTE FORCE DLA " + ( j + 1 ) + " ZADANIA: \n" );
                System.out.println( "\n-----------------------------------------------------" );
                System.out.println( "Z�O�NO�� ALGORYTMU BRUTE FORCE DLA " + ( j + 1 ) + " ZADANIA: " );
                int y = 1;
                for ( Long result : bfAlgorithmResults.get( j ) )
                {
                    results.append( "URUCHOMIENIE " + y + ": " + result + "\n" );
                    System.out.println( "URUCHOMIENIE " + y + ": " + result );
                    y++;
                }
                //results.append( "\n-----------------------------------------------------\n" );
                //results.append( "Z�O�ONO�� ALGORYTMU WARSTWOWEGO DLA " + ( j + 1 ) + " ZADANIA: \n" );
                System.out.println( "\n-----------------------------------------------------" );
                System.out.println( "Z�O�ONO�� ALGORYTMU WARSTWOWEGO DLA " + ( j + 1 ) + " ZADANIA: " );
                int z = 1;
                for ( Long result : layerAlgorithmResults.get( j ) )
                {
                    results.append( "URUCHOMIENIE " + z + ": " + result + "\n" );
                    System.out.println( "URUCHOMIENIE " + z + ": " + result );
                    z++;
                }

                // por�wnanie wydajno�ci obu algorytm�w
                resultsForCompare = new HashMap<>();
                resultsForCompare.put( CommonVariables.ALGORITHM_BRUTE_FORCE, bfAlgorithmResults.get( j ) );
                resultsForCompare.put( CommonVariables.ALGORITHM_LAYERING, layerAlgorithmResults.get( j ) );
                //results.append( StatisticsAlgorithmsHelper.compareAlgorithms( resultsForCompare ) );
                textArea.append("			>>>PODSUMOWANIE:\n\n");
                textArea.append( StatisticsAlgorithmsHelper.compareAlgorithms( resultsForCompare ) );
                textArea.append("\n");
            }
            
            textArea.append("\n");
        }

        //textArea.append( results.toString() );
        results.setLength(0);
        // jesli wszystko OK to sparsuj plik
        /*TGFHelper tgfHelper = new TGFHelper(file);
        Graf graf = tgfHelper.parseTgfFile();
        graf.przyporzadkujLosoweWagi();
        
        System.out.println(graf);*/

        // rob cos dalej z grafem..

        /*AlgorytmBruteForce abf = new AlgorytmBruteForce(graf);
        abf.compute();
        
        System.out.println("\n*****************************************************");
        
        AlgorytmLayering al = new AlgorytmLayering(graf);
        al.compute();*/

        // to tylko do testow - uzywac zamiast tego metody compute()!
        // abf.computeZlozonePamieciowo();

        // zapisz graf do pliku .tgf
        // tgfHelper.convertGraphToTgf(graf);
    }

    private static void setDisableComponents()
    {
        tfNumberOfMeasurements.setEnabled( false );
        tfNumberOfGraphs.setEnabled( false );
        chkBoxBruteForceAlgorithm.setEnabled( false );
        chkBoxLayerAlgorithm.setEnabled( false );
        chkBoxComputeComplexity.setEnabled( false );
        spinnerVertexFrom.setEnabled( false );
        spinnerVertextTo.setEnabled( false );
        rbRandomWeight.setEnabled( false );
        rbStateWeight.setEnabled( false );
        sliderDensityGraph.setEnabled( false );
        chkBoxComputeMemory.setEnabled( false );
        rdbtnWagiLosoweZ.setEnabled( false );

    }

    private void setEnableComponents()
    {

        tfNumberOfMeasurements.setEnabled( true );
        tfNumberOfGraphs.setEnabled( true );
        chkBoxBruteForceAlgorithm.setEnabled( true );
        chkBoxLayerAlgorithm.setEnabled( true );
        chkBoxComputeComplexity.setEnabled( true );
        spinnerVertexFrom.setEnabled( true );
        spinnerVertextTo.setEnabled( true );
        rbRandomWeight.setEnabled( true );
        rbStateWeight.setEnabled( true );
        sliderDensityGraph.setEnabled( true );
        rdbtnWagiLosoweZ.setEnabled( true );
        // chkBoxComputeMemory.setEnabled( true );
    }
}
