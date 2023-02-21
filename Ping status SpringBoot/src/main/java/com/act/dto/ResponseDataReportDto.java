package com.act.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDataReportDto {
    private String ip;
    private List<ResponseDataDto> responseDataDto;
}
