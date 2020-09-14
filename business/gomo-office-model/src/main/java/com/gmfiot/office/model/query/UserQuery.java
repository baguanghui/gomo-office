package com.gmfiot.office.model.query;

import com.gmfiot.core.data.Query;

import java.util.Date;

public class UserQuery extends Query {
    private String name;
    private Long id;
    private Integer status;
    private Long[] ids;
    private String[] names;
    private Boolean nameIsNull;
    private Boolean referenceIdIsNull;
    private String nameContains;
    private Long[] idsNotIn;
    private Long idNotEquals;
    private String nameNotEquals;
    private String nameStartsWith;
    private String nameEndsWith;
    private String nameNotContains;

    private Long idEquals;
    // and createdAt >= '2020-9-8'
    private Long idFrom;
    // and createdAt <= '2020-9-9'
    private Long idTo;
    // and createdAt > '2020-9-8'
    private Long idGreaterThan;
    // and createdAt < '2020-9-8'
    private Long idLessThan;

    private Long orId;
    private String orName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public Boolean getNameIsNull() {
        return nameIsNull;
    }

    public void setNameIsNull(Boolean nameIsNull) {
        this.nameIsNull = nameIsNull;
    }

    public Boolean getReferenceIdIsNull() {
        return referenceIdIsNull;
    }

    public void setReferenceIdIsNull(Boolean referenceIdIsNull) {
        this.referenceIdIsNull = referenceIdIsNull;
    }

    public String getNameContains() {
        return nameContains;
    }

    public void setNameContains(String nameContains) {
        this.nameContains = nameContains;
    }

    public Long[] getIdsNotIn() {
        return idsNotIn;
    }

    public void setIdsNotIn(Long[] idsNotIn) {
        this.idsNotIn = idsNotIn;
    }

    public Long getIdNotEquals() {
        return idNotEquals;
    }

    public void setIdNotEquals(Long idNotEquals) {
        this.idNotEquals = idNotEquals;
    }

    public String getNameNotEquals() {
        return nameNotEquals;
    }

    public void setNameNotEquals(String nameNotEquals) {
        this.nameNotEquals = nameNotEquals;
    }

    public String getNameStartsWith() {
        return nameStartsWith;
    }

    public void setNameStartsWith(String nameStartsWith) {
        this.nameStartsWith = nameStartsWith;
    }

    public String getNameEndsWith() {
        return nameEndsWith;
    }

    public void setNameEndsWith(String nameEndsWith) {
        this.nameEndsWith = nameEndsWith;
    }

    public String getNameNotContains() {
        return nameNotContains;
    }

    public void setNameNotContains(String nameNotContains) {
        this.nameNotContains = nameNotContains;
    }

    public Long getIdEquals() {
        return idEquals;
    }

    public void setIdEquals(Long idEquals) {
        this.idEquals = idEquals;
    }

    public Long getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(Long idFrom) {
        this.idFrom = idFrom;
    }

    public Long getIdTo() {
        return idTo;
    }

    public void setIdTo(Long idTo) {
        this.idTo = idTo;
    }

    public Long getIdGreaterThan() {
        return idGreaterThan;
    }

    public void setIdGreaterThan(Long idGreaterThan) {
        this.idGreaterThan = idGreaterThan;
    }

    public Long getIdLessThan() {
        return idLessThan;
    }

    public void setIdLessThan(Long idLessThan) {
        this.idLessThan = idLessThan;
    }

    public Long getOrId() {
        return orId;
    }

    public void setOrId(Long orId) {
        this.orId = orId;
    }

    public String getOrName() {
        return orName;
    }

    public void setOrName(String orName) {
        this.orName = orName;
    }
}
