package com.act.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StatusResponseDto {

    private Double num64 ;
    private Double num512 ;
    private Double num1024 ;
    private Double num2000 ;
}
