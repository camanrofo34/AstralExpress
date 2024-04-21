package view;

import model.messenger.Messenger;
import model.observer.Observer;
import dataStructures.Array;

import java.util.function.UnaryOperator;

public class HubView extends Observer<Messenger> {
    private javax.swing.JButton EmployeeButton;
    private javax.swing.JButton EmployeeButton1;
    private javax.swing.JButton EmployeeButton2;
    private javax.swing.JLabel EmployeeLabel;
    private javax.swing.JLabel EmployeeLabel1;
    private javax.swing.JLabel Header;
    private javax.swing.JLabel Kafka;
    private javax.swing.JLabel Logo;
    private javax.swing.JButton TrainButton;
    private javax.swing.JLabel TrainLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFrame jFrame1;

    public HubView(Messenger subject) {
        super(subject);
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Header = new javax.swing.JLabel();
        EmployeeButton = new javax.swing.JButton();
        TrainButton = new javax.swing.JButton();
        TrainLabel = new javax.swing.JLabel();
        EmployeeLabel = new javax.swing.JLabel();
        Kafka = new javax.swing.JLabel();
        EmployeeLabel1 = new javax.swing.JLabel();
        EmployeeButton1 = new javax.swing.JButton();
        EmployeeButton2 = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        subject.attach(this);
    }

    public void initComponents(Array<UnaryOperator<Void>> fns) {

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 24, 27));

        jPanel2.setBackground(new java.awt.Color(30, 33, 38));

        Header.setFont(new java.awt.Font("DINBEK", 0, 24)); // NOI18N
        Header.setForeground(new java.awt.Color(204, 204, 204));
        Header.setText("Welcome to the AE Passenger Transport Train Management System (PTTMS)");

        EmployeeButton.setBackground(new java.awt.Color(102, 102, 102));
        EmployeeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeButton.setText("Get In");
        EmployeeButton.addActionListener(event -> fns.get(1).apply(null));

        TrainButton.setBackground(new java.awt.Color(102, 102, 102));
        TrainButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TrainButton.setForeground(new java.awt.Color(255, 255, 255));
        TrainButton.setText("Get In");
        TrainButton.addActionListener(event -> fns.get(0).apply(null));

        TrainLabel.setFont(new java.awt.Font("DINBEK", 0, 14)); // NOI18N
        TrainLabel.setForeground(new java.awt.Color(255, 255, 255));
        TrainLabel.setText("Train Management");

        EmployeeLabel.setFont(new java.awt.Font("DINBEK", 0, 14)); // NOI18N
        EmployeeLabel.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeLabel.setText("Employee Management");

        Kafka.setIcon(new javax.swing.ImageIcon("src/main/resources/view/Kafka.png")); // NOI18N

        EmployeeLabel1.setFont(new java.awt.Font("DINBEK", 0, 14)); // NOI18N
        EmployeeLabel1.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeLabel1.setText("Route Management");

        EmployeeButton1.setBackground(new java.awt.Color(102, 102, 102));
        EmployeeButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EmployeeButton1.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeButton1.setText("Get In");
        EmployeeButton1.addActionListener(event -> fns.get(2).apply(null));

        EmployeeButton2.setBackground(new java.awt.Color(102, 102, 102));
        EmployeeButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EmployeeButton2.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeButton2.setText("Sign off");
        EmployeeButton2.addActionListener(event -> fns.get(3).apply(null));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(114, 114, 114)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(TrainLabel)
                                                        .addComponent(TrainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(EmployeeLabel1)
                                                        .addComponent(EmployeeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(38, 38, 38))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(EmployeeLabel)
                                                        .addComponent(EmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(266, 266, 266)))
                                .addComponent(Kafka, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Header)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EmployeeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Header)
                                .addGap(43, 43, 43)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(TrainLabel)
                                                        .addComponent(EmployeeLabel1))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(TrainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(EmployeeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(77, 77, 77)
                                                .addComponent(EmployeeLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(EmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(Kafka, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EmployeeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        Logo.setIcon(new javax.swing.ImageIcon("src/main/resources/view/LogoAEResized.png")); // NOI18N
        Logo.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame1.pack();
        jFrame1.setVisible(true);
    }

    @Override
    public void update() {
    }

    public void close() {
        jFrame1.dispose();
    }
}
