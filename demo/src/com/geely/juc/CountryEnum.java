package com.geely.juc;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CountryEnum {
    One(1, "qi"),
    Two(2, "chu"),
    Three(3, "qin"),
    Four(4, "zhao"),
    Five(5, "yan"),
    Six(6, "han");

    private Integer code;
    private String country;

    public static CountryEnum getEnum(int i) {
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum c : values) {
            if (i == c.getCode()) {
                return c;
            }
        }
        return null;
    }
}
