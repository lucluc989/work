package com.example.Payphone;

import java.util.HashMap;
import java.util.Map;

public enum Coin {
    ONEPENCE("One Pence", 1),
    TWOPENCE("Two Pence", 2),
    FIVEPENCE("Five Pence", 5),
    TENPENCE("Ten Pence", 10),
    TWENTYPENCE("Twenty Pence", 20),
    FIFTYPENCE("Fifty Pence", 50),
    ONEPound("One Pound", 100),
    TWOPOUND("Two Pound", 200);

    private static final Map<String, Coin> BY_LABEL = new HashMap<>();
    private static final Map<Integer, Coin> BY_VALES = new HashMap<>();

    public final String label;
    public final int value;

    static {
        for (Coin e : values()) {
            BY_LABEL.put(e.label, e);
            BY_VALES.put(e.value, e);
        }
    }

    private Coin(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public static Coin valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    public static Coin valueOfValue(int number) {
        return BY_VALES.get(number);
    }

}
