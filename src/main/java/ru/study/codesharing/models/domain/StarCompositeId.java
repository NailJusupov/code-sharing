package ru.study.codesharing.models.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StarCompositeId implements Serializable {

    private long userId;
    private long gistId;

    StarCompositeId() {

    }

    StarCompositeId(long userId, long gistId) {
        this.userId = userId;
        this.gistId = gistId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGistId() {
        return gistId;
    }

    public void setGistId(long gistId) {
        this.gistId = gistId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, gistId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        StarCompositeId that = (StarCompositeId) obj;

        return Objects.equals(userId, that.userId) && Objects.equals(gistId, that.gistId);
    }
}
