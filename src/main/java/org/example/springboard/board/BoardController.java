package org.example.springboard.board;

import org.example.springboard.UserUtils;
import org.example.springboard.board.model.BoardEntity;
import org.example.springboard.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService service;


    @GetMapping("/list")
    public void list(Model model) {
        List<BoardVO> list = service.selBoardList();
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
    public String writeProc(BoardEntity entity, RedirectAttributes reAttr, HttpServletRequest req){
        int result = service.insBoard(entity);
        if(result == 0){
            reAttr.addFlashAttribute("msg","글 등록에 실패하였습니다");
            reAttr.addFlashAttribute("data", entity);
            return "redirect:/board/write";
        }
        return "redirect:/board/list";
    }

    @GetMapping("/del")
    public String del(BoardEntity entity, RedirectAttributes reAttr){
        int result = service.delBoard(entity);
        if(result == 0){
            reAttr.addFlashAttribute("msg", "글 삭제에 실패하셨습니다");
            reAttr.addAttribute("iboard",entity.getIboard()); //쿼리스트링 iboard=pk값
            return "redirect:/board/detail";
        }
        return "redirect:/board/list";
    }

    @GetMapping("/mod")
    public void modBoard(Model model, BoardEntity entity){
        if(model.containsAttribute("msg") == false) {
            model.addAttribute("data", service.selBoard(entity));
        }
    }
    @PostMapping("/mod")
    public String modProc(BoardEntity entity, RedirectAttributes reAttr){
        int result = service.updBoard(entity);
        if(result == 0){
            reAttr.addFlashAttribute("msg", "글 수정에 실패하였습니다.");
            reAttr.addFlashAttribute("data", entity);
            return "redirect:/board/mod?iboard=" + entity.getIboard();
        }
        return "redirect:/board/detail?iboard=" + entity.getIboard();
    }

//    public String list() {
//        return "board/list";
//    }
}