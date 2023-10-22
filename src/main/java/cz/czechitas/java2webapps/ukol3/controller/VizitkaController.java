package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {

    private final List<Vizitka> seznamVizitek = List.of(
            new Vizitka("Adam Bernau", "Navstevnici s.r.o", "Vesmirna 36", "356 07", "bernau@google.com", 777000222, "vesmirnilide.cz"),
            new Vizitka("Juzan", "syrarny", "", "null", "", 888888888, "syrarny"),
            new Vizitka("Valentino Rossi", "Mooney", "Vitezna 9", "946 46", "uznejezdim@mooney.com",46464646, "")
    );

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView value = new ModelAndView("/seznam");
        value.addObject("detail", seznamVizitek);
        return value;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView value = new ModelAndView("/detail");
        value.addObject("vizitka", seznamVizitek.get(id));
        return value;
    }
}

