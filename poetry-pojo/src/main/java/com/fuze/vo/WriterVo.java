package com.fuze.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WriterVo {

    private String name;
    private String headImageUrl;
    private String simpleIntro;
    private String detailIntro;
}
