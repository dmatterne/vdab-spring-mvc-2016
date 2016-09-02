package be.vdab.spring.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class MyController {
    @Autowired
    FilmRepository fr;

    /**
     * A controller that renders directly without a view
     */
    @RequestMapping("/direct")
    @ResponseBody
    String directExample() {
        return "Hello World!";
    }

    /**
     * A controller that uses an explicit view name
     */
    @RequestMapping("/bar")
    String anyMethodName() {
        return "foo";
    }

    @RequestMapping("/filmlist")
    public String ex(Model model) {
        model.addAttribute("filmList", fr.findAll());
        return "films";
    }

    @RequestMapping(value = "/addfilm")
    public String addFilm(Model model) {
        model.addAttribute("film", new Film());
        return "addfilm";
    }


    @RequestMapping(value = "/processfilm", method = RequestMethod.POST)
    public String processFilm(@Valid Film film, BindingResult br) {
        if(br.hasErrors()) {
            return "addfilm";
        } else {
            fr.save(film);
            return "redirect:/filmlist";
        }

    }


}
