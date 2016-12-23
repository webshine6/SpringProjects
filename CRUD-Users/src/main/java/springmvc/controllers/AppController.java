package springmvc.controllers;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springmvc.model.User;
import springmvc.services.UserService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * declares that this class is default handler for all requests of type '/'
 */
@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    /**
     * Select allUsers view
     * Default GET handler
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listUsers(Locale locale, Model model) throws JsonGenerationException, JsonMappingException, IOException {
        logger.info("Welcome home! The client locale is {}", locale);

        ObjectMapper mapper = new ObjectMapper();
        List<User> users = userService.findAllUsers();

        model.addAttribute("users", mapper.writeValueAsString(userService.findAllUsers()));
        return "allUsers";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);

        return "registration";
    }


    /*
    * This method will be called on form submission, handling POST request
    * It also validates the user input
    *
    * - @Valid User user -  spring to validate the associated object(user)
    * - BindingResult result - contains the outcome of this validation
    * and any error that might have occurred during this validation
    */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        // check for unique email
        if (!userService.isUserEmailUnique(user.getId(), user.getEmail())) {
            FieldError emailError = new FieldError("user", "email",
                    messageSource.getMessage("non.unique.email", new String[]{user.getEmail()}, Locale.getDefault()));
            result.addError(emailError);
            return "registration";
        }

        // check for unique phone number
        if (!userService.isUserPhoneNumberUnique(user.getId(), user.getPhoneNumber())) {
            FieldError phoneNumberError = new FieldError("user", "phoneNumber",
                    messageSource.getMessage("non.unique.phoneNumber", new String[]{user.getPhoneNumber()}, Locale.getDefault()));

            result.addError(phoneNumberError);
            return "registration";
        }

        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getFirstName() +
                " registered successfully");

        return "success";
    }


    /**
     * Updating existing user in database
     *
     * @param firstName - to find user by firstName
     * @param model
     * @return
     */
    @RequestMapping(value = {"/edit-user-{firstName}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String firstName, ModelMap model) {
        User foundUser = userService.findUserByFirstName(firstName);
        model.addAttribute("edit", true);
        model.addAttribute("user", foundUser);
        return "registration";
    }

    /**
     * Handling POST request for
     * updating employee in database.
     * <p>
     * It also validates the user input
     *
     * @param user
     * @param result
     * @param model
     * @param firstName
     * @return
     */
    @RequestMapping(value = {"/edit-user-{firstName}"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable String firstName) {

        if (result.hasErrors()) {
            return "registration";
        }

        User dbUser = userService.findUserByFirstName(firstName);
        String dbUserEmail = dbUser.getEmail();
        String dbUserPhoneNumber = dbUser.getPhoneNumber();

        // ******************************************************* //
        String changedUserEmail = user.getEmail();
        String changedUserPhoneNumber = user.getPhoneNumber();


        // check for unique email
        if (!dbUserEmail.equals(changedUserEmail)) {
            if (!userService.isUserEmailUnique(user.getId(), user.getEmail())) {
                FieldError emailError = new FieldError("user", "email",
                        messageSource.getMessage("non.unique.email", new String[]{user.getEmail()}, Locale.getDefault()));
                result.addError(emailError);
                return "registration";
            }
        }

        // check for unique phoneNumber
        if (!dbUserPhoneNumber.equals(changedUserPhoneNumber)) {
            if (!userService.isUserPhoneNumberUnique(user.getId(), user.getPhoneNumber())) {
                FieldError phoneNumberError = new FieldError("user", "phoneNumber",
                        messageSource.getMessage("non.unique.phoneNumber", new String[]{user.getPhoneNumber()}, Locale.getDefault()));

                result.addError(phoneNumberError);
                return "registration";
            }
        }

        userService.updateUser(user);

        model.addAttribute("success", "User " + user.getFirstName() + " updated successfully");
        return "success";
    }

    @RequestMapping(value = {"/delete-user-{id}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);

        return "redirect: /list";
    }

    @Override
    public String toString() {
        return "AppController [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
}
