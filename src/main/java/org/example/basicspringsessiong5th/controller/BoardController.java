package org.example.basicspringsessiong5th.controller;

import lombok.RequiredArgsConstructor;
import org.example.basicspringsessiong5th.dto.*;
import org.example.basicspringsessiong5th.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public ResponseEntity<BoardSaveResponseDto> saveBoard(@RequestBody BoardSaveRequestDto requestDto) {
        return ResponseEntity.ok(boardService.saveBoard(requestDto));
    }

    @GetMapping("/boards")
    public ResponseEntity<List<BoardSimpleResponseDto>> getboards() {
        return ResponseEntity.ok(boardService.getBoards());
    }

    @GetMapping("/boards/{boardId}")
    public ResponseEntity<BoardDetailResponseDto> getBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    @PutMapping("/boards/{boardId}")
    public ResponseEntity<BoardUpdateContentResponseDto> updateContent(@PathVariable Long boardId, @RequestBody BoardUpdateContentRequestDto requestDto) {
        return ResponseEntity.ok(boardService.updateBoardContent(boardId, requestDto));
    }

    @PutMapping("/boards/{boardId}")
    public ResponseEntity<BoardUpdateTitleResponseDto> updateTitle(@PathVariable Long boardId, @RequestBody BoardUpdateTitleRequestDto requestDto) {
        return ResponseEntity.ok(boardService.updateBoardTitle(boardId, requestDto));
    }

    @DeleteMapping
    public void deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
    }
}
