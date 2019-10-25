package com.revature.screenforce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.screenforce.beans.Weight;

import java.util.List;

/**
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 * Data Access Obj for Weight
 */
@Repository
public interface WeightRepository extends JpaRepository<Weight, Integer> {
    /**
     * Delete weights by skill type ID
     *
     * @param trackId Skill type ID
     */
    void deleteAllByTrackTrackId(int trackId);

    /**
     * Get all weights by skill type ID
     *
     * @param trackId Skill type ID
     * @return List of weights
     */
    List<Weight> getAllByTrackTrackId(int trackId);

    /**
     * Get weights by skill type ID and category ID
     *
     * @param trackId Skill type ID
     * @param categoryId Category ID
     * @return Weight
     */
    Weight getByTrackTrackIdAndCategoryCategoryId(int trackId, int categoryId);

    /**
     * Delete weights by category ID
     *
     * @param categoryId Category ID
     */
    void deleteAllByCategoryCategoryId(int categoryId);
}
