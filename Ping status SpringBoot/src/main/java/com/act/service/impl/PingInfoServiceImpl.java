package com.act.service.impl;

import com.act.Model.PingInfo;
import com.act.dto.ResponseDataDto;
import com.act.dto.ResponseDataReportDto;
import com.act.dto.StatusResponseDto;
import com.act.dto.StatusResponseDto1;
import com.act.repositories.PingInfoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PingInfoServiceImpl {
    private PingInfoRepository pingInfoRepository;

    public PingInfoServiceImpl(PingInfoRepository pingInfoRepository) {
        this.pingInfoRepository = pingInfoRepository;
    }

    public StatusResponseDto pingInfoStatus(String ip) {
//        List<StatusResponseDto> statusResponseDtoArrayList = new ArrayList<>();
        StatusResponseDto statusResponseDto = new StatusResponseDto();
        List<PingInfo> pingInfo = pingInfoRepository.good(ip);
        double num2000 = 0;
        double num1024 = 0;
        double num64 = 0;
        double num512 = 0;

        double number = 0;
        AtomicInteger c = new AtomicInteger();
        for (PingInfo pingInfo1 : pingInfo) {
            System.out.println("Byte = " + pingInfo1.getBytes());

            if (pingInfo1.getBytes().equals("2000")) {
//            System.out.println("200000000000000");
                String numb = pingInfo1.getTime().toString();
                System.out.println("Time = " + pingInfo1.getTime());
                number = Double.valueOf(numb);
                num2000 = (number + num2000);
                // num2000 += number;

                //  st =num2000;
//            st=num2000;
                System.out.println("Avg of 2000 = " + num2000);
                //System.out.println("st" + st);
            } else if (pingInfo1.getBytes().equals("1024")) {
                String numb = pingInfo1.getTime().toString();
                System.out.println("Time = " + pingInfo1.getTime());

                number = Double.valueOf(numb);
                num1024 = (number + num1024);

                System.out.println("Avg of 1024 = " + num1024);

            }
//
            else if (pingInfo1.getBytes().equals("64")) {
                String numb = pingInfo1.getTime().toString();
                System.out.println("Time = " + pingInfo1.getTime());
                number = Double.valueOf(numb);
                num64 = (number + num64);
                System.out.println("Avg of 64 = " + num64);

            } else {
                String numb = pingInfo1.getTime().toString();
                System.out.println("Time = " + pingInfo1.getTime());
                number = Double.valueOf(numb);
                num512 = (number + num512);
                System.out.println("Avg of 512 = " + num512);
                // int a = c.getAndIncrement();
                // System.out.println(a);
            }
        }
        num2000 = num2000 / 3;
        num64 = num64 / 3;
        num1024 = num1024 / 3;
        num512 = num512 / 3;
        statusResponseDto.setNum2000(num2000);
        statusResponseDto.setNum1024(num1024);
        statusResponseDto.setNum64(num64);
        statusResponseDto.setNum512(num512);


//        statusResponseDtoArrayList.add(statusResponseDto);

        return statusResponseDto;
    }


    public ResponseDataReportDto returnResponse(String ip) {
        StatusResponseDto statusResponseDto = pingInfoStatus(ip);
        System.out.println("111111111111111");
        List<ResponseDataDto> list = new ArrayList<>();
        HashMap<String, String> statusList = new HashMap<>();
        statusList.put("64", "" + statusResponseDto.getNum64());
        statusList.put("512", "" + statusResponseDto.getNum512());
        statusList.put("1024", "" + statusResponseDto.getNum1024());
        statusList.put("2000", "" + statusResponseDto.getNum2000());
        System.out.println(statusList+"statusList");
        System.out.println(Double.parseDouble(statusList.get("64"))+"kkkkkkkkkkkkk");
        list.add(new ResponseDataDto("64", statusList.get("64"), returnCategory(Double.parseDouble(statusList.get("64")))));
        list.add(new ResponseDataDto("512", statusList.get("512"), returnCategory(Double.parseDouble(statusList.get("512")))));
        list.add(new ResponseDataDto("1024", statusList.get("1024"),  returnCategory(Double.parseDouble(statusList.get("1024")))));
        list.add(new ResponseDataDto("2000", statusList.get("2000"),  returnCategory(Double.parseDouble(statusList.get("2000")))));
        System.out.println(list+"Listttt");
        return new ResponseDataReportDto(ip, list);
    }

    public String returnCategory(Double input) {
        String status = "";
        if (input < 20 && input > 0) {
            status = "good";
        }

        else if (input < 100 && input > 20) {
            status = "medium";
        }

        else if (input > 100) {
            status = "bad";
        }
        return status;
    }

}



