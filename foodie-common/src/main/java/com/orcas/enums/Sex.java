package com.orcas.enums;

/**
 * @author: Orcas
 * @version:1.0.0
 * @date: 2020/10/3 16:55
 */
public enum Sex {
    female(0, "女"),
    male(1, "男"),
    secret(2, "保密"),
    ;

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
