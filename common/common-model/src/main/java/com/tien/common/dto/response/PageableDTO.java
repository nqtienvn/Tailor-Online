package com.tien.common.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageableDTO implements Serializable {
    private int pageIndex = 0;
    private int pageSize = 0;
    private long total = 0;
}
