package com.cxc6922.kafkadesc.po;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Message implements Serializable {
    private int id;
    private String msg;
    private String info;
}
