package com.prestoncoldwell.JavaProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String name;
    private String quantity;
    private String unit;
    private boolean optional;
    private String preparation;
}