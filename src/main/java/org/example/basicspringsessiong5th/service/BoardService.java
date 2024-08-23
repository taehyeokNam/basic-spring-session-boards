package org.example.basicspringsessiong5th.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.basicspringsessiong5th.dto.*;
import org.example.basicspringsessiong5th.entity.Board;
import org.example.basicspringsessiong5th.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public BoardSaveResponseDto saveBoard(BoardSaveRequestDto requestDto) {
        Board board = new Board(requestDto.getTitle(), requestDto.getContent());
        Board savedBoard = boardRepository.save(board);

        return new BoardSaveResponseDto(savedBoard.getId(), savedBoard.getContent(), savedBoard.getTitle());
    }

    public List<BoardSimpleResponseDto> getBoards() {
        List<Board> boards = boardRepository.findAll();
        List<BoardSimpleResponseDto> dtoList = new ArrayList<>();

        for (Board board : boards) {
            BoardSimpleResponseDto dto = new BoardSimpleResponseDto(board.getTitle(), board.getContent());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional
    public BoardUpdateContentResponseDto updateBoardContent(Long boardId, BoardUpdateContentRequestDto requestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("존재하지 않는 게시물입니다") );

        board.updateContent(requestDto.getContent());

        return new BoardUpdateContentResponseDto(board.getId(), board.getTitle(), board.getContent());
    }

    @Transactional
    public BoardUpdateTitleResponseDto updateBoardTitle(Long boardId, BoardUpdateTitleRequestDto requestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("존재하지 않는 게시판입니다.") );

        board.updateTitle(requestDto.getTitle());

        return new BoardUpdateTitleResponseDto(board.getId(), board.getTitle(), board.getContent());
    }

    public BoardDetailResponseDto getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new NullPointerException("존재하지 않는 게시판입니다."));

        return new BoardDetailResponseDto(board.getId(), board.getTitle(), board.getContent());
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
