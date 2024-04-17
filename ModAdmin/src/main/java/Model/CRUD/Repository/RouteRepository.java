package Model.CRUD.Repository;

import Model.CRUD.Repository.Entities.RouteEntity;
import Model.CRUD.Shared.FileJsonAdapter;
import Model.CRUD.Shared.FileJsonInterface;
import Model.Domain.Train;
import Model.Domain.mapRoute.Route;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

public class RouteRepository {
    private final FileJsonInterface<RouteEntity> fileJson;
    private final String pathFile;

    public RouteRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Boolean insert(Route route){
        RouteEntity routeEntity = new RouteEntity(route.getTrain().getIdTrain(), route.getRails());
        List<RouteEntity> routes = fileJson.getObjects(pathFile, RouteEntity[].class);
        routes.add(routeEntity);
        return fileJson.writeObjects(pathFile, routes);
    }

    public Boolean delete(Route route){
        RouteEntity routeEntity = new RouteEntity(route.getTrain().getIdTrain(), route.getRails());
        List<RouteEntity> routes = fileJson.getObjects(pathFile, RouteEntity[].class);
        routes.remove(routeEntity);
        return fileJson.writeObjects(pathFile, routes);
    }

    public Boolean update(Route route){
        RouteEntity routeEntity = new RouteEntity(route.getTrain().getIdTrain(), route.getRails());
        ArrayList<RouteEntity> routes = (ArrayList<RouteEntity>) fileJson.getObjects(pathFile, RouteEntity[].class);
        for (int i=0; i<routes.size(); i++){
            if (routes.get(i).getIdTrain().equals(route.getTrain().getIdTrain())){
                routes.set(i, routeEntity);
                return fileJson.writeObjects(pathFile, routes);
            }
        }
        return false;
    }

    public Route getRoute(String idTrain){
        List<RouteEntity> routes = fileJson.getObjects(pathFile, RouteEntity[].class);
        Iterator<RouteEntity> it = routes.iterator();
        while (it.hasNext()){
            RouteEntity routeEntity = it.next();
            if (routeEntity.getIdTrain().equals(idTrain)){
                TrainRepository trainRepository = new TrainRepository("src/main/resources/Model/JSONFiles/trains.json");
                Train train = trainRepository.getTrain(routeEntity.getIdTrain());
                return new Route(routeEntity.getRails(), train);
            }
        }
        return null;
    }

    public List<Route> getRoutes() throws Exception {
        ArrayList<RouteEntity> routes = (ArrayList<RouteEntity>) fileJson.getObjects(pathFile, RouteEntity[].class);
        List<Route> routesList = new ArrayList<>();
        for (int i=0; i<routes.size(); i++){
            RouteEntity routeEntity = routes.get(i);
            TrainRepository trainRepository = new TrainRepository("src/main/resources/Model/JSONFiles/trains.json");
            Train train = trainRepository.getTrain(routeEntity.getIdTrain());
            routesList.add(new Route(routeEntity.getRails(), train));
        }
        return routesList;
    }
}