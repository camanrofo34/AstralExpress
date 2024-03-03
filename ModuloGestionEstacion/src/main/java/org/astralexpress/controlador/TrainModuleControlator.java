/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.controlador;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.astralexpress.modelo.TrainsModule;
import org.astralexpress.modelo.domain.Train;
import org.astralexpress.vista.TrainModuleTableView;

/**
 *
 * @author PC 4060TI
 */
public class TrainModuleControlator {
    
    TrainModuleTableView TMTV;
    TrainsModule TM;

    public TrainModuleControlator(TrainModuleTableView TMTV) {
        this.TMTV = TMTV;
        this.TM = new TrainsModule();
    }
    
    
    public void cargarDatosTrenes(){
        Object[][] trains = TM.crearTablaTrenes();
        TMTV.jTrainsTable.setModel(new DefaultTableModel(trains, new Object[]{"idTrain", "nameTrain", "capacity", "mileage", "brand"}));
        
    }
}
