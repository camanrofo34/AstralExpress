/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.vista;

import org.astralexpress.modelo.messenger.Messenger;
import org.astralexpress.modelo.observer.Observer;

import javax.swing.*;
import java.util.function.UnaryOperator;

/**
 * @author PC 4060TI
 */
public class ServerView extends Observer<Messenger> {

    private JButton BotonArranque;
    private JLabel Estado;
    private JLabel Presentacion;
    private JPanel jPanel1;
    private JFrame jFrame1;

    public ServerView(Messenger subject) {
        super(subject);
        subject.attach(this);
        jPanel1 = new JPanel();
        Presentacion = new JLabel();
        Estado = new JLabel();
        BotonArranque = new JButton();
        jFrame1 = new JFrame();
    }


    public void initComponents(UnaryOperator<Void> fn) {

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Presentacion.setText("INICIO DEL SISTEMA");

        Estado.setText("Estado: Desactivado");

        BotonArranque.setText("Activar");
        BotonArranque.addActionListener(event -> fn.apply(null));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonArranque)
                                .addGap(261, 261, 261))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Presentacion)
                                        .addComponent(Estado))
                                .addContainerGap(233, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(Presentacion)
                                .addGap(90, 90, 90)
                                .addComponent(Estado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addComponent(BotonArranque)
                                .addGap(76, 76, 76))
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
    }// </editor-fold>       

    @Override
    public void update() {
        Estado.setText(subject.getMessage());
    }

    public void showServerStatus(String server_started) {
        BotonArranque.setText(server_started);
        BotonArranque.setEnabled(false);
    }
}
