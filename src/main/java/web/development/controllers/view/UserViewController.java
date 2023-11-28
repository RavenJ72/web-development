package web.development.controllers.view;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.development.services.dto.input.OfferDto;
import web.development.services.dto.input.UserDto;
import web.development.services.interfaces.publicApi.BrandService;
import web.development.services.interfaces.publicApi.ModelService;
import web.development.services.interfaces.publicApi.OfferService;
import web.development.services.interfaces.publicApi.UserService;

@Controller
@RequestMapping("/user")
public class UserViewController {

    private OfferService offerService;
    private BrandService brandService;
    private ModelService modelService;
    private UserService userService;

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String usersAll(Model model){

        model.addAttribute("title","Car Service - All users");
        model.addAttribute("users",userService.findAll());

        return "user-all";
    }

    @GetMapping("/{id}")
    public String offerDetails(@PathVariable("id") String id, Model model){

        model.addAttribute("title","Car Service - User details page");
        model.addAttribute("user",userService.findUserDetailsById(id));

        return "user-details";
    }

    @GetMapping("/add/")
    public String addUser(Model model){

        return "user-add";
    }
    @ModelAttribute("userDto")
    public UserDto initUserDtoModel() {
        return new UserDto();
    }

    @PostMapping("/add/")
    public String addUser(@Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        userDto.setIsActive(false);
        userDto.setRole("USER");

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userDto", userDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userDto", bindingResult);

            return "redirect:/user/add/";
        }
        userService.save(userDto);
        return "redirect:/user/";
    }




    @GetMapping("/user/edit/{id}")
    public String editOffer(@PathVariable("id") String id,Model model){
        model.addAttribute("offerDto",offerService.findOfferForEdit(id));
        model.addAttribute("models",modelService.findAll());
        model.addAttribute("users",userService.findAll());

        return "offer-edit";
    }
    @PostMapping("/user/edit/{id}")
    public String editOffer(@Valid OfferDto offerDto, @PathVariable("id") String id, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerDto", offerDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerDto", bindingResult);
            return "redirect:/offer/edit/" + id;
        }

        offerService.save(offerDto);
        return "redirect:/offer/" + id;
    }

}