package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;
import org.jxmapviewer.OSMTileFactoryInfo;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIMappa extends JFrame {

	private static final long serialVersionUID = 1L;
	private static double[] coord=new double[2];
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMappa frame = new GUIMappa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUIMappa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 201, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panelMappa = new JPanel();
		panelMappa.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_panelMappa = new GridBagConstraints();
		JXMapViewer mapViewer=getJxMapViewer();
		
		
		gbc_panelMappa.insets = new Insets(0, 0, 5, 5);
		gbc_panelMappa.fill = GridBagConstraints.BOTH;
		gbc_panelMappa.gridx = 4;
		gbc_panelMappa.gridy = 1;
		contentPane.add(mapViewer, gbc_panelMappa);
		
		JButton btnStampa = new JButton("Stampa");
		btnStampa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Coordinate: "+coord[0]+ ", " +coord[1]);
			}
		});
		GridBagConstraints gbc_btnStampa = new GridBagConstraints();
		gbc_btnStampa.insets = new Insets(0, 0, 0, 5);
		gbc_btnStampa.gridx = 4;
		gbc_btnStampa.gridy = 2;
		contentPane.add(btnStampa, gbc_btnStampa);
	}
	private static JXMapViewer getJxMapViewer() {

        JXMapViewer mapViewer = new JXMapViewer();


        OSMTileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);


        
        mapViewer.setZoom(2);
        GeoPosition myPoint= new GeoPosition(41.9028, 12.4964);
		mapViewer.setAddressLocation(myPoint);

        Set<Waypoint> waypoints = new HashSet<>();
        

        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);


        mapViewer.setOverlayPainter(waypointPainter);
        mapViewer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){


                // Ottieni le coordinate del punto cliccato
                Point clickPoint = e.getPoint();
                GeoPosition geoPosition = mapViewer.convertPointToGeoPosition(clickPoint);

                // Stampa le coordinate in console
                //System.out.println("Punto selezionato: " + geoPosition.getLatitude() + ", " + geoPosition.getLongitude());
                
				coord[0]=geoPosition.getLatitude();
				coord[1]=geoPosition.getLongitude();
				waypoints.clear();
				
                // Aggiungi un nuovo waypoint
                DefaultWaypoint waypoint = new DefaultWaypoint(geoPosition);
                waypoints.add(waypoint);

                // Aggiorna il painter della mappa per mostrare i waypoints
                waypointPainter.setWaypoints(waypoints);
                mapViewer.repaint();
                }
            }
        });
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
        mapViewer.addMouseMotionListener(new PanMouseInputListener(mapViewer));
        return mapViewer;
    }
}
