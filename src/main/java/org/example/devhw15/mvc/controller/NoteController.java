package org.example.devhw15.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;
    private  static final String LIST_NOTES = "listnotes";
    private  static final String EXEPTION = "exeption";

    @GetMapping(value = "/list")
    public ModelAndView getNote() {
        ModelAndView result = new ModelAndView(LIST_NOTES);
        result.addObject("note", noteService.listAll());
        return result;
    }

    @PostMapping(value = "/delete")
    public ModelAndView getTest(@RequestParam(value = "id", defaultValue = "0", required = false) Integer id) {
        ModelAndView result = new ModelAndView(LIST_NOTES);
        result.addObject("note", noteService.deleteNote(id));
        return new ModelAndView("redirect:list");
    }

    @GetMapping(value = "/edit")
    public ModelAndView getUpdateNote(@RequestParam(value = "id", defaultValue = "0", required = false) Integer id) {
        try {
            ModelAndView result = new ModelAndView("editnote");
            result.addObject("note", noteService.editNoteById(id));
            return result;
        }catch (IndexOutOfBoundsException exception){
            return new ModelAndView("redirect:exeption");
        }

    }


    @GetMapping(value = "/create")
    public ModelAndView crearteNote(@RequestParam(required = false) String title, String content) {
        ModelAndView result = new ModelAndView(LIST_NOTES);
        result.addObject("note", noteService.createNote(title, content));
        return result;
    }

    @PostMapping(value = "/update")
    public ModelAndView updateNote(@RequestParam(required = false) Integer id, Long updateId, String title, String content) {
        try {
            ModelAndView result = new ModelAndView(LIST_NOTES);
            result.addObject("note", noteService.updateNote(id, updateId, title, content));
            return new ModelAndView("redirect:list");
        }catch (IndexOutOfBoundsException exception){
            return new ModelAndView("redirect:exeption");
        }
    }

    @GetMapping(value = "/exeption")
    public ModelAndView getExeption() {
        return new ModelAndView(EXEPTION);
    }


}
