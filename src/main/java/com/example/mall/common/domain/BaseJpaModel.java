package com.example.mall.common.domain;

import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
public class BaseJpaModel implements Serializable {
    @Column(name = "CREATED_AT", updatable = false)
    protected LocalDateTime createdAt;

    @Column(name = "CREATED_BY", updatable = false)
    protected String createdBy;

    @Column(name = "UPDATED_AT")
    protected LocalDateTime updatedAt;

    @Column(name = "UPDATED_BY")
    protected String updatedBy;

    public String getCreateTime() {
        return createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getCreateDate() {
        return createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @PrePersist
    protected void onPersist() {
        this.createdAt = this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
