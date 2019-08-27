package be.axxes.pmt.yearbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("checkin")
public class CheckinController {
    private CheckinRepository checkinRepository;

    @Autowired
    public CheckinController(CheckinRepository checkinRepository) {
        this.checkinRepository = checkinRepository;
    }

    @RequestMapping("/")
    public String checkins(Model model) {
        Page<Checkin> checkins = checkinRepository.findAll(PageRequest.of(0, 50));
        model.addAttribute("checkins", checkins.getContent());
        model.addAttribute("nbOfCheckins", checkins.getNumberOfElements());
        return "checkins";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String checkins(Checkin checkin) {
        checkinRepository.save(checkin);
        return "redirect:/checkin/";
    }
}
