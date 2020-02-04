package com.example.lab06.core.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.neovisionaries.i18n.CurrencyCode;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Account implements Serializable {

    private static final long serialVersionUID = -6503308210888015809L;

    @JsonProperty("id")
    private int accountId;

    private double balance;

    private CurrencyCode money;

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, true);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
