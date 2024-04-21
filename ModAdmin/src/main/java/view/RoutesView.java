package view;

import dataStructures.Array;
import model.domain.mapRoute.Rail;
import model.domain.mapRoute.Route;
import model.messenger.Messenger;
import model.observer.Observer;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.function.UnaryOperator;

public class RoutesView extends Observer<Messenger> {
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel EstacionesLabel;
    private javax.swing.JLabel Header;
    private javax.swing.JLabel LabelParaelGrafo;
    private javax.swing.JLabel NoseLabel;
    private javax.swing.JLabel TrainLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JFrame jFrame1;

    public RoutesView(Messenger subject) throws ParseException {
        super(subject);
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Header = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        EstacionesLabel = new javax.swing.JLabel();
        NoseLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        TrainLabel = new javax.swing.JLabel();
        LabelParaelGrafo = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField(new MaskFormatter("##:##"));
        jFrame1 = new javax.swing.JFrame();
        subject.attach(this);
    }

    @Override
    public void update() {

    }

    public void initComponents(Array<UnaryOperator<Void>> fns, String[] trains, List<Route> routes){
        jFrame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame1.getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(20, 24, 27));

        jPanel2.setBackground(new java.awt.Color(30, 33, 38));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("src/main/resources/view/LogoAEResized.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        Header.setFont(new java.awt.Font("DINBEK", 0, 24)); // NOI18N
        Header.setForeground(new java.awt.Color(204, 204, 204));
        Header.setText("ROUTES MANAGEMENT");

        jTable1.setBackground(new java.awt.Color(62, 60, 60));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "Time", "Start", "End", "Distance", "Train", "Arrival"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        AddButton.setBackground(new java.awt.Color(137, 255, 196));
        AddButton.setText("ADD ROUTE");
        AddButton.addActionListener(e -> fns.get(0).apply(null));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        EstacionesLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EstacionesLabel.setForeground(new java.awt.Color(204, 204, 204));
        EstacionesLabel.setText("Stations");

        NoseLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NoseLabel.setForeground(new java.awt.Color(204, 204, 204));
        NoseLabel.setText("DepartureTime");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(trains));

        TrainLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TrainLabel.setForeground(new java.awt.Color(204, 204, 204));
        TrainLabel.setText("Train");

        DeleteButton.setBackground(new java.awt.Color(255, 102, 102));
        DeleteButton.setText("DELETE ROUTE");
        DeleteButton.addActionListener(e -> fns.get(1).apply(null));

        jFormattedTextField1.setText("jFormattedTextField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(Header))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(EstacionesLabel)
                                                                .addGap(72, 72, 72)
                                                                .addComponent(TrainLabel))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(41, 41, 41)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jComboBox1, 0, 120, Short.MAX_VALUE)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(DeleteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(NoseLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                                                .addGap(12, 12, 12)
                                                .addComponent(LabelParaelGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Header)
                                                .addGap(46, 46, 46)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(EstacionesLabel)
                                                        .addComponent(TrainLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(NoseLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(91, 91, 91)
                                                                .addComponent(AddButton))))
                                        .addComponent(LabelParaelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DeleteButton)
                                .addContainerGap(52, Short.MAX_VALUE))
        );
        jFrame1.getContentPane().add(jPanel1, "card2");
        jFrame1.pack();
        setRoutes(routes);
        jFrame1.setVisible(true);
    }

    public List<String> stationsSelected() {
        int[] selectedIndices = jList1.getSelectedIndices();
        List<String> stations = new ArrayList<>(selectedIndices.length);
        for (int index : selectedIndices) {
            stations.add(jList1.getModel().getElementAt(index));
        }
        return stations;
    }

    public String getDepartureTime() {
        return jFormattedTextField1.getText();
    }

    public String getSelectedTrain() {
        return jComboBox1.getSelectedItem().toString();
    }

    public void setRoutes(List<Route> routes) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Iterator<Route> iterator = routes.iterator();
        while (iterator.hasNext()) {
            Route route = iterator.next();
            List<Rail> rails = new ArrayList<>(route.getRails());
            model.addRow(new Object[]{route.getDepartureTime(),rails.peek().getStation1().getStationName(),
                    rails.peekLast().getStation2().getStationName(), route.getTotalDistance(), route.getTrain().getIdTrain(),
                    route.getArrivalTime()});
        }
        jTable1.setModel(model);
    }

    public Array<String> getSelectedRow() {
        int row = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Array<String> data = new Array<>(new String[] {model.getValueAt(row, 0).toString(), model.getValueAt(row, 1).toString(),
                model.getValueAt(row, 2).toString(), model.getValueAt(row, 3).toString(), model.getValueAt(row, 4).toString(),
                model.getValueAt(row, 5).toString()});
        return data;
    }

}
