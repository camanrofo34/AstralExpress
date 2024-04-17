package View;

import Model.Messenger.Messenger;
import Model.Observer.Observer;
import dataStructures.Array;

import java.util.function.UnaryOperator;

public class HubView extends Observer<Messenger> {
    private javax.swing.JButton employees;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton routes;
    private javax.swing.JButton signoff;
    private javax.swing.JButton trains;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;

    public HubView(Messenger subject) {
        super(subject);
        employees = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        routes = new javax.swing.JButton();
        signoff = new javax.swing.JButton();
        trains = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        subject.attach(this);
    }

    public void initComponents(Array<UnaryOperator<Void>> fns) {

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DINBEK", 0, 24)); // NOI18N
        jLabel1.setText("Welcome to the AE Passenger Transport Train Management System (PTTMS)");

        trains.setText("TRAIN MANAGEMENT");
        trains.addActionListener(event -> fns.get(0).apply(null));

        employees.setText("EMPLOYEE MANAGEMENT");
        employees.addActionListener(event -> fns.get(1).apply(null));

        routes.setText("ROUTES MANAGEMENT");
        routes.addActionListener(event -> fns.get(2).apply(null));

        signoff.setText("SIGN OFF");
        signoff.addActionListener(event -> fns.get(3).apply(null));


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(444, 444, 444)
                                                                                .addComponent(signoff, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(jLabel1)))
                                                                .addGap(0, 78, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(82, 82, 82)
                                                                .addComponent(trains, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(employees, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(98, 98, 98)
                                                                .addComponent(routes, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel2)
                                                .addGap(427, 427, 427)))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel2)
                                                .addGap(49, 49, 49)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(trains, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(employees, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(routes, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(signoff, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(155, 155, 155))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(136, Short.MAX_VALUE))))
        );
        jFrame1.pack();
        jFrame1.setVisible(true);
    }

    @Override
    public void update() {
        jLabel2.setText(subject.getMessage());
    }

    public void close() {
        jFrame1.dispose();
    }
}
