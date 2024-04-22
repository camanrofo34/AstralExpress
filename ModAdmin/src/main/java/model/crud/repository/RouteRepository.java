package model.crud.repository;

import model.crud.repository.entities.RouteEntity;
import model.crud.shared.FileJsonAdapter;
import model.crud.shared.FileJsonInterface;
import model.domain.Train;
import model.domain.mapRoute.Route;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

public class RouteRepository implements model.interfaces.crud.RouteRepoInterface {
    private final FileJsonInterface<RouteEntity> fileJson;
    private final String pathFile;

    public RouteRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    @Override
    public Boolean insert(Route route) {
        RouteEntity routeEntity = new RouteEntity(route.getDepartureTime(), route.getArrivalTime(), route.getTrain().getIdTrain(), route.getRails(), route.getTotalDistance());
        List<RouteEntity> routes = fileJson.getObjects(pathFile, RouteEntity[].class);
        routes.add(routeEntity);
        return fileJson.writeObjects(pathFile, routes);
    }

    @Override
    public Boolean delete(String idTrain) {
        List<RouteEntity> routes = fileJson.getObjects(pathFile, RouteEntity[].class);
        routes.remove(e->e.getIdTrain().equals(idTrain));
        return fileJson.writeObjects(pathFile, routes);
    }

    @Override
    public Boolean update(Route route) {
        RouteEntity routeEntity = new RouteEntity(route.getDepartureTime(), route.getArrivalTime(), route.getTrain().getIdTrain(), route.getRails(), route.getTotalDistance());
        ArrayList<RouteEntity> routes = (ArrayList<RouteEntity>) fileJson.getObjects(pathFile, RouteEntity[].class);
        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i).getIdTrain().equals(route.getTrain().getIdTrain())) {
                routes.set(i, routeEntity);
                return fileJson.writeObjects(pathFile, routes);
            }
        }
        return false;
    }

    @Override
    public Route getRoute(String idTrain) {
        List<RouteEntity> routes = fileJson.getObjects(pathFile, RouteEntity[].class);
        Iterator<RouteEntity> it = routes.iterator();
        while (it.hasNext()) {
            RouteEntity routeEntity = it.next();
            if (routeEntity.getIdTrain().equals(idTrain)) {
                TrainRepository trainRepository = new TrainRepository("src/main/resources/Model/JSONFiles/trains.json");
                Train train = trainRepository.getTrain(routeEntity.getIdTrain());
                return new Route(routeEntity.getDepartureHour(), routeEntity.getArrivalHour(), routeEntity.getRails(), train, routeEntity.getDistance());
            }
        }
        return null;
    }

    @Override
    public List<Route> getRoutes() throws Exception {
        ArrayList<RouteEntity> routes = (ArrayList<RouteEntity>) fileJson.getObjects(pathFile, RouteEntity[].class);
        List<Route> routesList = new ArrayList<>();
        for (int i = 0; i < routes.size(); i++) {
            RouteEntity routeEntity = routes.get(i);
            TrainRepository trainRepository = new TrainRepository("src/main/resources/Model/JSONFiles/trains.json");
            Train train = trainRepository.getTrain(routeEntity.getIdTrain());
            routesList.add(new Route(routeEntity.getDepartureHour(), routeEntity.getArrivalHour(), routeEntity.getRails(), train, routeEntity.getDistance()));
        }
        return routesList;
    }
}
