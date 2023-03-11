package com.muravev.samokatimhandbook.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class PageableReactAdmin {
    @JsonProperty("_end")
    private int end;

    @JsonProperty("_start")
    private int start;
    private String sort;
    private String order;

    public Pageable toPageable() {
        int pageSize = start - end;
        int pageNum = start / pageSize;
        return PageRequest.of(pageNum, pageSize);
    }
}
