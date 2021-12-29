package org.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        List<BoardEntity> list = service.selBoardList();
        model.addAttribute("list", list);
    }

    @GetMapping("/detail")
    public void detail(Model model, BoardEntity entity){
        service.updBoardHitsUp(entity);
        model.addAttribute("data", service.selBoard(entity));
    }

    @GetMapping("/write")
    public void write() {}

    @PostMapping("/write")
    public String writeProc(BoardEntity entity){
        System.out.println(entity);
        int result = service.insBoard(entity);
        return "redirect:/board/list";
    }

    @GetMapping("/del")
    public String del(BoardEntity entity){
        int result = service.delBoard(entity);
        return "redirect:/board/list";
    }

    @GetMapping("/mod")
    public void modBoard(Model model, BoardEntity entity){
        model.addAttribute("data", service.selBoard(entity));
    }
    @PostMapping("/mod")
    public String modProc(BoardEntity entity){
        int result = service.updBoard(entity);
        return "redirect:/board/detail?iboard=" + entity.getIboard();
    }

//    public String list() {
//        return "board/list";
//    }
}