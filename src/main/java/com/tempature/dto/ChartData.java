package com.tempature.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ChartData {
	private List<String> labels;
	private List<Double> data;
}
