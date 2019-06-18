package com.tridevmc.habitus.blocks;

import net.minecraft.util.IStringSerializable;

public enum ButcherTableSide implements IStringSerializable {
    LEFT("left"),
    RIGHT("right");

    private final String name;

    ButcherTableSide(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
