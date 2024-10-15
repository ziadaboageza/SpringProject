package com.fawry.springproject.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class StatusMessage {
    private int code;
    private String status;
    private String timestamp;
}
