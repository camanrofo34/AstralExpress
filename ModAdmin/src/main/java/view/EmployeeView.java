package view;

import model.domain.User;
import model.messenger.Messenger;
import model.observer.Observer;
import dataStructures.Array;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.function.UnaryOperator;

public class EmployeeView extends Observer<Messenger> {
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JLabel Header;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JLabel Logo;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NumberField;
    private javax.swing.JLabel NumerLabel;
    private javax.swing.JTextField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JTextField UserField;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JFrame jFrame1;

    public EmployeeView(Messenger subject) {
        super(subject);
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Header = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        UserLabel = new javax.swing.JLabel();
        UserField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JTextField();
        NameLabel = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        LastNameLabel = new javax.swing.JLabel();
        LastNameField = new javax.swing.JTextField();
        NumerLabel = new javax.swing.JLabel();
        NumberField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SearchField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jFrame1 = new javax.swing.JFrame();
        subject.attach(this);
    }

    public void initComponents(Array<UnaryOperator<Void>> fns, List<User> users) {
        jFrame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame1.getContentPane().setLayout(new java.awt.CardLayout());
        jPanel1.setBackground(new java.awt.Color(20, 24, 27));

        jPanel2.setBackground(new java.awt.Color(30, 33, 38));

        Logo.setIcon(new javax.swing.ImageIcon("src/main/resources/view/LogoAEResized.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        Header.setFont(new java.awt.Font("DINBEK", 0, 24)); // NOI18N
        Header.setForeground(new java.awt.Color(204, 204, 204));
        Header.setText("EMPLOYEE MANAGER");

        jTable1.setBackground(new java.awt.Color(62, 60, 60));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "ID", "USER", "PASSWORD", "NAMES", "LAST NAMES", "C. NUMBER"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        UserLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UserLabel.setForeground(new java.awt.Color(255, 255, 255));
        UserLabel.setText("USER");

        UserField.setBackground(new java.awt.Color(30, 33, 38));
        UserField.setForeground(new java.awt.Color(255, 255, 255));

        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel.setText("PASSWORD");

        PasswordField.setBackground(new java.awt.Color(30, 33, 38));
        PasswordField.setForeground(new java.awt.Color(255, 255, 255));

        NameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NameLabel.setForeground(new java.awt.Color(255, 255, 255));
        NameLabel.setText("NAMES");

        NameField.setBackground(new java.awt.Color(30, 33, 38));
        NameField.setForeground(new java.awt.Color(255, 255, 255));

        LastNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LastNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        LastNameLabel.setText("LAST NAMES");

        LastNameField.setBackground(new java.awt.Color(30, 33, 38));
        LastNameField.setForeground(new java.awt.Color(255, 255, 255));

        NumerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NumerLabel.setForeground(new java.awt.Color(255, 255, 255));
        NumerLabel.setText("CONTACT NUMBER");

        NumberField.setBackground(new java.awt.Color(30, 33, 38));
        NumberField.setForeground(new java.awt.Color(255, 255, 255));

        AddButton.setText("ADD");

        EditButton.setText("EDIT");

        DeleteButton.setBackground(new java.awt.Color(220, 27, 27));
        DeleteButton.setText("DELETE");

        SearchButton.setText("SEARCH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NumerLabel)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(NumberField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(UserLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(NameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(NameField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(AddButton)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                                                        .addComponent(EditButton))
                                                                .addComponent(UserField, javax.swing.GroupLayout.Alignment.LEADING))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(94, 94, 94)
                                                                .addComponent(DeleteButton)))
                                                .addGap(80, 80, 80)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(SearchButton)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(LastNameLabel)
                                                                .addComponent(PasswordLabel)
                                                                .addComponent(PasswordField)
                                                                .addComponent(LastNameField)
                                                                .addComponent(SearchField, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
                                        .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(UserLabel)
                                                                        .addComponent(PasswordLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(UserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(NameLabel))
                                                        .addComponent(LastNameLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(NumerLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(NumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(AddButton)
                                                        .addComponent(EditButton)
                                                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(DeleteButton)
                                                        .addComponent(SearchButton)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 68, Short.MAX_VALUE))
        );

        jFrame1.getContentPane().add(jPanel1, "card2");
        chargeTable(users);
        jFrame1.pack();
        jFrame1.setVisible(true);
    }

    @Override
    public void update() {
        JOptionPane.showMessageDialog(null, subject.getMessage());
    }

    public String getNames() {
        return NameField.getText();
    }

    public String getLastNames() {
        return LastNameField.getText();
    }

    public String getContactNumber() {
        return NumberField.getText();
    }

    public String getUser() {
        return UserField.getText();
    }

    public String getPassword() {
        return PasswordField.getText();
    }

    public String getSearched() {
        return SearchField.getText();
    }
    /**
     * Method to charge the table
     * @param users
     */
    public void chargeTable(List<User> users) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User user = it.next();
            model.addRow(new Object[]{user.getPerson().getIdPerson(), user.getUsername(), user.getPassword(), user.getPerson().getNames(), user.getPerson().getLastNames(), user.getPerson().getPhoneNumbersString()});
        }
        jTable1.setModel(model);
    }
    /**
     * Method to get the selected row
     * @return
     */
    public Array<String> getSelectedRow() {
        int row = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Array<String> data = new Array<>(6);
        if (row != -1) {
            for (int i = 0; i < model.getColumnCount(); i++) {
                data.add((String) model.getValueAt(row, i));
            }
        }
        return data;
    }
}
