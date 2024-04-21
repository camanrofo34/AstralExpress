package Model.Interfaces.Communication.SendToClient;

import Model.Domain.Brand;
import Model.Domain.Train;
import Model.Interfaces.Communication.SendToServer.TrainManagerServerInterface;
import Model.Services.TrainManagerService;
import dataStructures.Interfaces.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrainManagerInterfaceTest {

    @Test
    void getTrains() throws Exception {
        TrainManagerClientInterface trainManagerClientInterface = new TrainManagerService();
        List<Train> trains = trainManagerClientInterface.getTrains();
        assertEquals(4, trains.size());
    }

    @Test
    void removeTrain() throws Exception {
        Train train = new Train("T4", "4", 20, 21.2, Brand.Arnold);
        TrainManagerServerInterface trainManagerClientInterface = new TrainManagerService();
        assertTrue(trainManagerClientInterface.removeTrain(train));
    }

    @Test
    void updateTrain() throws Exception {
        Train train = new Train("T4", "4", 20, 21.2, Brand.Mercedez_Benz);
        TrainManagerServerInterface trainManagerClientInterface = new TrainManagerService();
        assertTrue(trainManagerClientInterface.updateTrain(train));
    }
}