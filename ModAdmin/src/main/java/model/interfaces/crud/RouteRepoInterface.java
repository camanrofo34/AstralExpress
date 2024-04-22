package model.interfaces.crud;

import dataStructures.Interfaces.List;
import model.domain.mapRoute.Route;

public interface RouteRepoInterface {
    /**
     * Insert a Route in the repository
     * @return true if the Route was inserted, false if not
     */
    Boolean insert(Route route);

    /**
     * Delete a Route in the repository
     * @param idTrain Route to be deleted
     * @return true if the Route was deleted, false if not
     */
    Boolean delete(String idTrain);
    /**
     * Update a Route in the repository
     * @param route Route to be updated
     * @return true if the Route was updated, false if not
     */
    Boolean update(Route route);
    /**
     * Get a Route from the repository
     * @param idTrain Route to be obtained
     * @return Route if the Route was found, null if not
     */
    Route getRoute(String idTrain);
    /**
     * Get all Routes from the repository
     * @return List of Routes
     */
    List<Route> getRoutes() throws Exception;
}
