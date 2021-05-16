package cn.liaocp.amireux.core.domain;

import cn.liaocp.amireux.core.util.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseDomain implements Serializable {

    @Column(nullable = false, length = 36, updatable = false)
    @CreatedBy
    @JsonIgnore
    private String createUser;

    @Column(nullable = false)
    @JsonIgnore
    private Instant createTime;

    @JsonIgnore
    private Instant updateTime;

    @Column(nullable = false, length = 36, updatable = true)
    @JsonIgnore
    private String updateUser;

    @PrePersist
    protected void PrePersist() {
        Instant now = DateTimeUtil.now();
        this.createTime = now;
        this.updateTime = now;
        this.createUser = "temp user";
        this.updateUser = "temp user";
        // TODO Assign values to createUser and updateUser
    }

    @PreUpdate
    protected void preUpdate() {
        this.updateTime = DateTimeUtil.now();
        this.updateUser = "temp user";
        // TODO Assign values and updateUser
    }

    @PreRemove
    protected void preRemove() {
        this.updateTime = DateTimeUtil.now();
        this.updateUser = "temp user";
        // TODO Assign values and updateUser
    }

}
