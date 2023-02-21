package com.act.repositories;

import com.act.Model.PingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


public interface PingInfoRepository extends JpaRepository<PingInfo, Long>
{
    List<PingInfo> findPingInfoByIp(String ip);
    @Query(value = "SELECT * FROM ping_info WHERE ip=?1 order by id desc LIMIT 12;",nativeQuery = true)
    List<PingInfo> good(String ip);
    @Query(value = "SELECT * FROM ping_info WHERE ip=?1 order by id desc LIMIT 12;",nativeQuery = true)
    PingInfo bad(String ip);


}

