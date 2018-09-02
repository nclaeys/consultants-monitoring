package be.axxes.consultants;

import be.axxes.consultants.model.Consultant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("consultant")
public class ConsultantController {
    private ConsultantRepository consultantRepository;

    @Autowired
    public ConsultantController(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    @RequestMapping("/")
    public String consultants(Model model) {
        Page<Consultant> consultants = consultantRepository.findAll(PageRequest.of(0, 50));
        model.addAttribute("consultants", consultants.getContent());
        model.addAttribute("nbOfConsultants", consultants.getNumberOfElements());
        return "consultants";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String consultants(Consultant consultant) {
        consultantRepository.save(consultant);
        return "redirect:/consultant/";
    }
}
