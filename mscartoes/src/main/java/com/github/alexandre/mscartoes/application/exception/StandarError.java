package com.github.alexandre.mscartoes.application.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StandarError {

    private LocalDateTime timeStamp;
    private Integer status;
    private String error;
    private String path;
}
