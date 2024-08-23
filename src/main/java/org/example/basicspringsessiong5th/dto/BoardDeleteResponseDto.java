package org.example.basicspringsessiong5th.dto;

import lombok.Getter;

@Getter
public class BoardDeleteResponseDto {
    private final Long id;
    private final String title;
    private final String content;

    public BoardDeleteResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
