package View;


import Model.Messenger.Messenger;
import Model.Observer.Observer;
import dataStructures.Array;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import Model.Domain.Train;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.function.UnaryOperator;

public class TrainView extends Observer<Messenger> {
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JFrame jFrame1;

    public TrainView(Messenger subject) {
        super(subject);
        this.jButton1 = new javax.swing.JButton();
        this.jButton2 = new javax.swing.JButton();
        this.jButton3 = new javax.swing.JButton();
        this.jButton4 = new javax.swing.JButton();
        this.jComboBox1 = new javax.swing.JComboBox<>();
        this.jLabel1 = new javax.swing.JLabel();
        this.jLabel2 = new javax.swing.JLabel();
        this.jLabel3 = new javax.swing.JLabel();
        this.jLabel4 = new javax.swing.JLabel();
        this.jLabel5 = new javax.swing.JLabel();
        this.jScrollPane1 = new javax.swing.JScrollPane();
        this.jTable1 = new javax.swing.JTable();
        this.jTextField1 = new javax.swing.JTextField();
        this.jTextField2 = new javax.swing.JTextField();
        this.jTextField3 = new javax.swing.JTextField();
        this.jTextField4 = new javax.swing.JTextField();
        this.jFrame1 = new javax.swing.JFrame();
        subject.attach(this);
    }

    @Override
    public void update() {

    }

    public void chargeVagons (List<Train> trains) {
        Iterator<Train> iterator = trains.iterator();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        while (iterator.hasNext()) {
            Train train = iterator.next();
            model.addRow(new String[]{train.getIdTrain(), train.getTrainName(), String.valueOf(train.getCapacity()), String.valueOf(train.getMileage()), String.valueOf(train.getBrand())});
        }
    }

    public void init(Array<UnaryOperator<Void>> fns, List<Train> trains) {
        jFrame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new String[][] {
                },
                new String [] {
                        "ID", "NAME", "WAGONS", "MILEAGE", "BRAND"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("SEARCH");
        jButton1.addActionListener(event ->fns.get(0).apply(null));

        jLabel1.setFont(new java.awt.Font("DINBEK", 0, 24)); // NOI18N
        jLabel1.setText("TRAIN MANAGER");

        jLabel2.setText("NAME");

        jLabel3.setText("WAGONS");

        jLabel4.setText("MILEAGE");

        jLabel5.setText("BRAND");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mercedez_Benz", "Arnold" }));

        jButton2.setText("ADD");
        jButton2.addActionListener(event -> fns.get(1).apply(null));

        jButton3.setText("EDIT");
        jButton3.addActionListener(event -> fns.get(2).apply(null));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 51, 51));
        jButton4.setText("DELETE");
        jButton4.addActionListener(event -> fns.get(3).apply(null));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jTextField4)
                                                        .addComponent(jTextField3)
                                                        .addComponent(jTextField2)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jButton2)
                                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                                                .addComponent(jButton3)
                                                                .addGap(77, 77, 77))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(178, 178, 178)
                                                .addComponent(jButton4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(0, 48, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        chargeVagons(trains);
        jFrame1.pack();
        jFrame1.setVisible(true);
    }

    public String getTrainSearch() {
        return jTextField1.getText();
    }

    public String getTrainName() {
        return jTextField2.getText();
    }

    public String getTrainWagons() {
        return jTextField3.getText();
    }

    public String getTrainMilleage() {
        return jTextField4.getText();
    }

    public String getTrainBrand() {
        return jComboBox1.getSelectedItem().toString();
    }

    public Array<String> getTrainData (){
        int row = jTable1.getSelectedRow();
        Array<String> data = new Array<>(5);
        if (row != -1) {
            data.add((String) jTable1.getValueAt(row, 0));
            data.add((String) jTable1.getValueAt(row, 1));
            data.add((String) jTable1.getValueAt(row, 2));
            data.add((String) jTable1.getValueAt(row, 3));
            data.add((String) jTable1.getValueAt(row, 4));
        }
        return data;
    }

}
