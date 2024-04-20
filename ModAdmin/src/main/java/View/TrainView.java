package View;


import Model.Domain.Train;
import Model.Messenger.Messenger;
import Model.Observer.Observer;
import dataStructures.Array;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.function.UnaryOperator;

public class TrainView extends Observer<Messenger> {
    private javax.swing.JButton AddButton;
    private javax.swing.JComboBox<String> BrandBox;
    private javax.swing.JLabel BrandLabel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JLabel Header;
    private javax.swing.JPanel Logo;
    private javax.swing.JTextField MileageField;
    private javax.swing.JLabel MileageLabel;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JTextField TrainField;
    private javax.swing.JLabel TrainLabel;
    private javax.swing.JTextField WagonField;
    private javax.swing.JLabel WagonLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JFrame jFrame1;

    public TrainView(Messenger subject) {
        super(subject);
        jPanel1 = new javax.swing.JPanel();
        Logo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Header = new javax.swing.JLabel();
        TrainLabel = new javax.swing.JLabel();
        TrainField = new javax.swing.JTextField();
        MileageLabel = new javax.swing.JLabel();
        MileageField = new javax.swing.JTextField();
        BrandLabel = new javax.swing.JLabel();
        WagonLabel = new javax.swing.JLabel();
        WagonField = new javax.swing.JTextField();
        BrandBox = new javax.swing.JComboBox<>();
        AddButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SearchField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        this.jFrame1 = new javax.swing.JFrame();
        subject.attach(this);
    }

    @Override
    public void update() {

    }

    public void chargeVagons(List<Train> trains) {
        Iterator<Train> iterator = trains.iterator();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        while (iterator.hasNext()) {
            Train train = iterator.next();
            model.addRow(new String[]{train.getIdTrain(), train.getTrainName(), String.valueOf(train.getCapacity()), String.valueOf(train.getMileage()), String.valueOf(train.getBrand()), String.valueOf(train.getInRoute())});
        }
    }

    public void init(Array<UnaryOperator<Void>> fns, List<Train> trains) {
        jFrame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jFrame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame1.getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(20, 24, 27));

        Logo.setBackground(new java.awt.Color(30, 33, 38));

        jLabel1.setIcon(new javax.swing.ImageIcon("src/main/resources/View/LogoAEResized.png"));

        javax.swing.GroupLayout LogoLayout = new javax.swing.GroupLayout(Logo);
        Logo.setLayout(LogoLayout);
        LogoLayout.setHorizontalGroup(
                LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LogoLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        LogoLayout.setVerticalGroup(
                LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LogoLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        Header.setFont(new java.awt.Font("DINBEK", 0, 24)); // NOI18N
        Header.setForeground(new java.awt.Color(204, 204, 204));
        Header.setText("TRAIN MANAGEMENT");

        TrainLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TrainLabel.setForeground(new java.awt.Color(255, 255, 255));
        TrainLabel.setText("NAME");

        TrainField.setBackground(new java.awt.Color(30, 33, 38));
        TrainField.setForeground(new java.awt.Color(255, 255, 255));

        MileageLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MileageLabel.setForeground(new java.awt.Color(255, 255, 255));
        MileageLabel.setText("MILEAGE");

        MileageField.setBackground(new java.awt.Color(30, 33, 38));
        MileageField.setForeground(new java.awt.Color(255, 255, 255));

        BrandLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BrandLabel.setForeground(new java.awt.Color(255, 255, 255));
        BrandLabel.setText("BRAND");

        WagonLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        WagonLabel.setForeground(new java.awt.Color(255, 255, 255));
        WagonLabel.setText("WAGONS");

        WagonField.setBackground(new java.awt.Color(30, 33, 38));
        WagonField.setForeground(new java.awt.Color(255, 255, 255));

        BrandBox.setBackground(new java.awt.Color(20, 24, 27));
        BrandBox.setForeground(new java.awt.Color(255, 255, 255));
        BrandBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Mercedes benz", "Arnold" }));

        AddButton.setText("ADD");
        AddButton.addActionListener(event -> fns.get(1).apply(null));

        EditButton.setText("EDIT");
        EditButton.addActionListener(event -> fns.get(2).apply(null));

        DeleteButton.setBackground(new java.awt.Color(220, 27, 27));
        DeleteButton.setText("DELETE");
        DeleteButton.addActionListener(event -> fns.get(3).apply(null));

        jTable1.setBackground(new java.awt.Color(62, 60, 60));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "ID", "NAME", "WAGONS", "MILEAGE", "BRAND", "AVAIBLE"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        SearchButton.setText("SEARCH");
        SearchButton.addActionListener(event -> fns.get(0).apply(null));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Header)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(MileageLabel)
                                                                .addComponent(TrainField, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(MileageField, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(TrainLabel)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(AddButton)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(EditButton)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(93, 93, 93)
                                                                .addComponent(DeleteButton)))
                                                .addGap(60, 60, 60)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(SearchButton)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(WagonLabel)
                                                                .addComponent(WagonField, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                                                .addComponent(BrandLabel)
                                                                .addComponent(BrandBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(SearchField)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Header)
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(TrainLabel)
                                                        .addComponent(WagonLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(TrainField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(WagonField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(MileageLabel)
                                                        .addComponent(BrandLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(MileageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BrandBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(33, 33, 33)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(AddButton)
                                                        .addComponent(EditButton)
                                                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(DeleteButton))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(SearchButton))))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 160, Short.MAX_VALUE))
        );

        jFrame1.getContentPane().add(jPanel1, "card2");
        jFrame1.pack();
        chargeVagons(trains);
        jFrame1.setVisible(true);
    }

    public String getTrainSearch() {
        return SearchField.getText();
    }

    public String getTrainName() {
        return TrainField.getText();
    }

    public String getTrainWagons() {
        return WagonField.getText();
    }

    public String getTrainMilleage() {
        return MileageField.getText();
    }

    public String getTrainBrand() {
        return BrandBox.getSelectedItem().toString();
    }

    public Array<String> getTrainData() {
        int row = jTable1.getSelectedRow();
        Array<String> data = new Array<>(5);
        if (row != -1) {
            data.add((String) jTable1.getValueAt(row, 0));
            data.add((String) jTable1.getValueAt(row, 1));
            data.add((String) jTable1.getValueAt(row, 2));
            data.add((String) jTable1.getValueAt(row, 3));
            data.add((String) jTable1.getValueAt(row, 4));
            data.add((String) jTable1.getValueAt(row, 5));
            JOptionPane.showMessageDialog(null, data.get(5));
        }
        return data;
    }

}
