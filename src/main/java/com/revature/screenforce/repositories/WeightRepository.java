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
     * @param skillTypeId Skill type ID
     */
    void deleteAllBySkillTypeSkillTypeId(int skillTypeId);

    /**
     * Get all weights by skill type ID
     *
     * @param skillTypeId Skill type ID
     * @return List of weights
     */
    List<Weight> getAllBySkillTypeSkillTypeId(int skillTypeId);

    /**
     * Get weights by skill type ID and bucket ID
     *
     * @param skillTypeId Skill type ID
     * @param bucketId Bucket ID
     * @return Weight
     */
    Weight getBySkillTypeSkillTypeIdAndBucketBucketId(int skillTypeId, int bucketId);

    /**
     * Delete weights by bucket ID
     *
     * @param bucketId Bucket ID
     */
    void deleteAllByBucketBucketId(int bucketId);
}
