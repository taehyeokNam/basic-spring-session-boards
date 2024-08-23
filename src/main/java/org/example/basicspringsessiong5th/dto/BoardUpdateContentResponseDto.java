package org.example.basicspringsessiong5th.dto;

import lombok.Getter;

@Getter
public class BoardUpdateContentResponseDto {

    private final Long id;
    private final String title;
    private final String content;


    public BoardUpdateContentResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
