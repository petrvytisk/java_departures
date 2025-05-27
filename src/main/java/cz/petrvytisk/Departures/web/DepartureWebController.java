package cz.petrvytisk.Departures.web;

import cz.petrvytisk.Departures.dto.DepartureSearchForm;
import cz.petrvytisk.Departures.dto.DepartureDto;
import cz.petrvytisk.Departures.service.DepartureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/odletyapp")
public class DepartureWebController {

    private final DepartureService departureService;

    public DepartureWebController(DepartureService departureService) {
        this.departureService = departureService;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("searchForm", new DepartureSearchForm());
        return "odlety_form";   // Thymeleaf šablona
    }

    @PostMapping
    public String processForm(
            @ModelAttribute("searchForm") @Valid DepartureSearchForm form,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "odlety_form";
        }

        List<DepartureDto> seznam = departureService.findDepartures(form.getAirport(), form.getFrom(), form.getTo());

        model.addAttribute("seznamOdletu", seznam);
        // Pro případ, že chceš zachovat zobrazení vyhledaného letiště v hlavičce:
        model.addAttribute("searchForm", form.getAirport());
        return "odlety_list";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDateTime.parse(text, formatter));
            }
        });
    }
}
