package view;

import model.messenger.Messenger;
import model.observer.Observer;

import javax.swing.*;
import java.util.function.UnaryOperator;

public class LoginView extends Observer<Messenger> {
    private javax.swing.JButton LogInButton;
    private javax.swing.JPanel PanelDark;
    private javax.swing.JPanel PanelLight;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JTextField UserField;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFrame jFrame1;

    public LoginView(Messenger subject) {
        super(subject);
        PanelDark = new javax.swing.JPanel();
        PanelLight = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        UserField = new javax.swing.JTextField();
        UserLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        LogInButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        subject.attach(this);
    }

    @Override
    public void update() {
        JOptionPane.showMessageDialog(null, subject.getMessage());
    }

    public void initComponents(UnaryOperator<Void> fns) {

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setBackground(new java.awt.Color(20, 24, 27));

        PanelDark.setBackground(new java.awt.Color(20, 24, 27));

        PanelLight.setBackground(new java.awt.Color(30, 33, 38));

        jLabel2.setIcon(new ImageIcon("src/main/resources/View/AstralExpressTrain.png")); // NOI18N

        javax.swing.GroupLayout PanelLightLayout = new javax.swing.GroupLayout(PanelLight);
        PanelLight.setLayout(PanelLightLayout);
        PanelLightLayout.setHorizontalGroup(
                PanelLightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLightLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(106, Short.MAX_VALUE))
        );
        PanelLightLayout.setVerticalGroup(
                PanelLightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLightLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(145, 145, 145))
        );

        UserField.setBackground(new java.awt.Color(30, 33, 38));
        UserField.setFont(new java.awt.Font("DINBEK", 0, 12)); // NOI18N
        UserField.setForeground(new java.awt.Color(255, 255, 255));

        UserLabel.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        UserLabel.setForeground(new java.awt.Color(255, 255, 255));
        UserLabel.setText("USER");

        PasswordLabel.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel.setText("PASSWORD");

        PasswordField.setBackground(new java.awt.Color(30, 33, 38));
        PasswordField.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(255, 255, 255));
        PasswordField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        LogInButton.setBackground(new java.awt.Color(102, 102, 102));
        LogInButton.setFont(new java.awt.Font("DINBEK", 0, 18)); // NOI18N
        LogInButton.setText("Log in");
        LogInButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 51, 255), null, null));
        LogInButton.setBorderPainted(false);
        LogInButton.addActionListener(event -> fns.apply(null));
        jLabel1.setIcon(new ImageIcon("src/main/resources/View/LogoAE.png")); // NOI18N

        javax.swing.GroupLayout PanelDarkLayout = new javax.swing.GroupLayout(PanelDark);
        PanelDark.setLayout(PanelDarkLayout);
        PanelDarkLayout.setHorizontalGroup(
                PanelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDarkLayout.createSequentialGroup()
                                .addGroup(PanelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDarkLayout.createSequentialGroup()
                                                .addGap(0, 119, Short.MAX_VALUE)
                                                .addGroup(PanelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDarkLayout.createSequentialGroup()
                                                                .addComponent(PasswordLabel)
                                                                .addGap(223, 223, 223))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDarkLayout.createSequentialGroup()
                                                                .addGroup(PanelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(UserField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(100, 100, 100))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDarkLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(PanelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDarkLayout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(185, 185, 185))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDarkLayout.createSequentialGroup()
                                                                .addComponent(UserLabel)
                                                                .addGap(245, 245, 245))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDarkLayout.createSequentialGroup()
                                                                .addComponent(LogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(159, 159, 159)))))
                                .addComponent(PanelLight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        PanelDarkLayout.setVerticalGroup(
                PanelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDarkLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(UserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UserField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PasswordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(114, Short.MAX_VALUE))
                        .addComponent(PanelLight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFrame1.getContentPane().add(PanelDark, java.awt.BorderLayout.CENTER);

        jFrame1.pack();
        jFrame1.setVisible(true);
    }

    /**
     * Method to get the user
     * @return
     */
    public String getUser() {
        return UserField.getText();
    }

    /**
     * Method to get the password
     * @return
     */
    public String getPassword() {
        return PasswordField.getText();
    }

    public void close() {
        jFrame1.dispose();
    }


}
