package model.interfaces.crud;

import dataStructures.Interfaces.List;
import model.domain.Station;
import model.domain.mapRoute.Rail;

public interface RailRepoInterface {
    /**
     * Get Rails from the repository
     * @return List<Rail> of Rails
     */
    List<Rail> getRails() throws Exception;
    /**
     * Get a Rail from the repository
     * @param station1 Station to be obtained
     * @param station2 Station to be obtained
     * @return Rail if the Rail was found, null if not
     */
    Rail getRail(Station station1, Station station2) throws Exception;
}
