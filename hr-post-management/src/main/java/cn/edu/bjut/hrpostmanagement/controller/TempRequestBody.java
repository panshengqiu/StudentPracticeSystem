package cn.edu.bjut.hrpostmanagement.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempRequestBody{
    List<String> workCities;
    List<String> postTypes;
    String status;
}
