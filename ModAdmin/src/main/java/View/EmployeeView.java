package View;

import Model.Domain.Train;
import Model.Domain.User;
import Model.Messenger.Messenger;
import Model.Observer.Observer;
import dataStructures.Array;
import dataStructures.Interfaces.List;
import dataStructures.Interfaces.Iterator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.function.UnaryOperator;

public class EmployeeView extends Observer<Messenger> {
    private javax.swing.JButton jAdd;
    private javax.swing.JButton jButton5;
    private javax.swing.JTextField jContactNumber;
    private javax.swing.JButton jDelete;
    private javax.swing.JButton jEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jLastNames;
    private javax.swing.JTextField jNames;
    private javax.swing.JTextField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSearch;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jUser;
    private javax.swing.JFrame jFrame1;

    public EmployeeView(Messenger subject) {
        super(subject);
        jAdd = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jContactNumber = new javax.swing.JTextField();
        jDelete = new javax.swing.JButton();
        jEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLastNames = new javax.swing.JTextField();
        jNames = new javax.swing.JTextField();
        jPassword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSearch = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jUser = new javax.swing.JTextField();
        jFrame1 = new javax.swing.JFrame();
        subject.attach(this);
    }

    public void initComponents(Array<UnaryOperator<Void>> fns, List<User> users){
        jFrame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "ID", "USER", "PASSWORD", "NAMES", "LAST NAMES", " C. NUMBERS"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("DINBEK", 0, 24)); // NOI18N
        jLabel1.setText("EMPLOYEE MANAGER");

        jLabel2.setText("USER");

        jLabel3.setText("PASSWORD");

        jLabel4.setText("NAMES");

        jLabel5.setText("LAST NAMES");

        jLabel6.setText("CONTACT NUMBER");

        jAdd.setText("ADD");
        jAdd.addActionListener(event -> fns.get(0).apply(null));

        jDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jDelete.setForeground(new java.awt.Color(255, 51, 51));
        jDelete.setText("DELETE");
        jDelete.addActionListener(event -> fns.get(1).apply(null));

        jEdit.setText("EDIT");
        jEdit.addActionListener(event -> fns.get(2).apply(null));


        jSearch.setText("SEARCH");
        jSearch.addActionListener(event -> fns.get(3).apply(null));


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jUser, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jPassword)
                                                        .addComponent(jNames)
                                                        .addComponent(jLastNames)
                                                        .addComponent(jContactNumber)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jAdd)
                                                                .addGap(130, 130, 130)
                                                                .addComponent(jEdit))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(99, 99, 99)
                                                                .addComponent(jDelete)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jSearch))
                                                .addGap(209, 209, 209))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(17, 17, 17))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton5)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(jLabel1)
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLastNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSearch))
                                        .addComponent(jButton5)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jAdd)
                                                        .addComponent(jEdit))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jDelete)))
                                .addContainerGap(65, Short.MAX_VALUE))
        );

        jFrame1.pack();
        chargeTable(users);
        jFrame1.setVisible(true);
    }

    @Override
    public void update() {
        JOptionPane.showMessageDialog(null, subject.getMessage());
    }

    public String getNames(){
        return jNames.getText();
    }

    public String getLastNames(){
        return jLastNames.getText();
    }

    public String getContactNumber(){
        return jContactNumber.getText();
    }

    public String getUser(){
        return jUser.getText();
    }

    public String getPassword(){
        return jPassword.getText();
    }

    public String getSearched(){
        return jTextField6.getText();
    }

    public void chargeTable(List<User> users){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Iterator<User> it = users.iterator();
        while(it.hasNext()){
            User user = it.next();
            model.addRow(new Object[]{user.getPerson().getIdPerson(), user.getUsername(), user.getPassword(), user.getPerson().getNames(), user.getPerson().getLastNames(), user.getPerson().getPhoneNumbersString()});
        }
        jTable1.setModel(model);
    }

    public Array<String> getSelectedRow(){
        int row = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Array<String> data = new Array<>(6);
        if (row!=-1){
            for (int i = 0; i < model.getColumnCount(); i++) {
                data.add((String) model.getValueAt(row, i));
            }
        }
        return data;
    }
}
