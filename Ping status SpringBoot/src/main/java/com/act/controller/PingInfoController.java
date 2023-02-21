package com.act.controller;
import com.act.Model.PingInfo;
import com.act.dto.ResponseDataReportDto;
import com.act.dto.StatusResponseDto;
import com.act.service.impl.PingInfoServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pingInfo")
public class PingInfoController {

    private PingInfoServiceImpl pingInfoService;

    public PingInfoController(PingInfoServiceImpl pingInfoService) {
        this.pingInfoService = pingInfoService;
    }
//    @GetMapping("{ip}")
//    public List<PingInfo> ListPingInfoByIp(@PathVariable("ip") String ip){
//      return  pingInfoService.findPingInfo(ip);
//    }


//    @GetMapping("status/{ip}")
//
//    public List<PingInfo> PingInfoStatus(@PathVariable("ip") String ip){
//        return  pingInfoService.pingInfoStatus(ip);
//    }

@GetMapping("statu/{ip}")
public StatusResponseDto PingInfoStatuss(@PathVariable("ip") String ip){
    return  pingInfoService.pingInfoStatus(ip);

 }

@GetMapping("status/{ip}")
public ResponseDataReportDto PingInfoStatus(@PathVariable("ip") String ip){
    return  pingInfoService.returnResponse(ip);

 }
}
