package com.prestoncoldwell.JavaProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutritionInfo {
    private Number calories;
    private Number fat;
    private Number protein;
    private Number carbohydrates;
}