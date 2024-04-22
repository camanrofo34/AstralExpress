package model.interfaces.crud;

import dataStructures.Interfaces.List;
import model.domain.ChargeVagon;

public interface ChargeVagonRepoInterface {
    /**
     * Insert a ChargeVagon in the repository
     * @param chargeVagon ChargeVagon to be inserted
     * @return true if the ChargeVagon was inserted, false if not
     */
    Boolean insert(ChargeVagon chargeVagon);

    /**
     * Delete a ChargeVagon in the repository
     * @param chargeVagon ChargeVagon to be deleted
     * @return true if the ChargeVagon was deleted, false if not
     */

    Boolean delete(ChargeVagon chargeVagon);

    /**
     * Update a ChargeVagon in the repository
     * @param chargeVagon ChargeVagon to be updated
     * @return true if the ChargeVagon was updated, false if not
     */
    Boolean update(ChargeVagon chargeVagon);
    /**
     * Get a ChargeVagon from the repository
     * @param idVagon ChargeVagon to be obtained
     * @return ChargeVagon if the ChargeVagon was found, null if not
     */
    ChargeVagon getChargeVagon(String idVagon);

    /**
     * Get all ChargeVagons from the repository
     * @return List of ChargeVagons
     */
    List<ChargeVagon> getChargeVagons();
}
