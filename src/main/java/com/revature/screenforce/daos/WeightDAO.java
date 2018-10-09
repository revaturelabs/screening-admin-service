package com.revature.screenforce.daos;

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
public interface WeightDAO extends JpaRepository<Weight, Long> {
    void deleteAllBySkillTypeSkillTypeId(int skillTypeId);

    List<Weight> getAllBySkillTypeSkillTypeId(int skillTypeId);

    Weight getBySkillTypeSkillTypeIdAndBucketBucketId(int skillTypeId, int bucketId);

    void deleteAllByBucketBucketId(int bucketId);
}
