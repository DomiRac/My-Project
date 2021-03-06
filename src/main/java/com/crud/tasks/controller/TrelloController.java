package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        List<TrelloBoardDto> result = trelloBoards.stream()
                .filter(trelloBoard -> trelloBoard.getId() != null)
                .filter(trelloBoard -> trelloBoard.getName() != null)
                .filter(trelloBoard -> trelloBoard.getName().contains("Kodilla"))
                .collect(Collectors.toList());

        result.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));

    }
}