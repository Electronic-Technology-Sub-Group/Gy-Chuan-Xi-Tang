package com.fuze.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Writer {
    private Integer id;
    private String name;
    private String headImageUrl;
    private String simpleIntro;
    private String detailIntro;
}
