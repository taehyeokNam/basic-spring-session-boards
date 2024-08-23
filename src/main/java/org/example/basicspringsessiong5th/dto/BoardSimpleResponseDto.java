package org.example.basicspringsessiong5th.dto;

import lombok.Getter;

@Getter
public class BoardSimpleResponseDto {
    private final String title;
    private final String content;

    public BoardSimpleResponseDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
