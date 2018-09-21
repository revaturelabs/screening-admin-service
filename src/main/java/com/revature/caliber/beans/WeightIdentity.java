package com.revature.caliber.beans;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Omar Guzman | 1807-QC | Emily Higgins
 *
 * Model to represent the composite primary key of weight
 */
@Embeddable
public class WeightIdentity implements Serializable {
    @NotNull
    private int SkillTypeID;

    @NotNull
    private int BucketID;

    public WeightIdentity() {
    }

    public WeightIdentity(int skillTypeID, int bucketID) {
        SkillTypeID = skillTypeID;
        BucketID = bucketID;
    }

    public int getSkillTypeID() {
        return SkillTypeID;
    }

    public void setSkillTypeID(int skillTypeID) {
        SkillTypeID = skillTypeID;
    }

    public int getBucketID() {
        return BucketID;
    }

    public void setBucketID(int bucketID) {
        BucketID = bucketID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightIdentity that = (WeightIdentity) o;
        return getSkillTypeID() == that.getSkillTypeID() &&
                getBucketID() == that.getBucketID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkillTypeID(), getBucketID());
    }
}
