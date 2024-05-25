package controller;

import model.DischargeModel;
import view.DischargeView;

import javax.swing.*;

public class DischargeController {
    DischargeModel dischargeModel;
    DischargeView dischargeView;

    public DischargeController(DischargeModel dischargeModel, DischargeView dischargeView) {
        this.dischargeModel = dischargeModel;
        this.dischargeView = dischargeView;
    }
    /**
     * This method is used to initialize the view
     */
    public void init() {
        dischargeView.init(event -> {
            String id = dischargeView.getDischarge();
            try {
                if(dischargeModel.discharge(id)){
                    JOptionPane.showMessageDialog(null, "Luggage and passenger discharged successfully");
                } else{
                    JOptionPane.showMessageDialog(null, "Luggage and passenger not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}
