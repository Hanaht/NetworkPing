package com.act.Model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;
@Entity
@Data
public class PingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bytes;
    private String ip;
    private String icmp_seq;
    private String ttl;
    private String time;
    private Timestamp ts;

}
