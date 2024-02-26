package br.com.aei.api.resources.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StandartError {
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;
}
