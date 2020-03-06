package sheridan.qina.quiz1.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Stack;

@Controller
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    public MainController() {
    }

    @GetMapping(value={"/", "Index"})
    public String index(HttpSession httpSession, Model model){
        StackObj stack = (StackObj) httpSession.getAttribute("stack");
        if(stack == null){
            stack = new StackObj();
            stack.setInput("roast");
            stack.setInput("plot");
            stack.setInput("life");
            httpSession.setAttribute("stack", stack);
        }
        model.addAttribute("stack", stack);
        return "Index";
    }

    @RequestMapping(value = "Process", method = RequestMethod.POST, params = "action=push")
    public String push(@RequestParam(value = "pushInput", defaultValue = "")String pushInput, HttpSession session){
        if(pushInput != null && ! pushInput.isEmpty() ){
            StackObj stack = (StackObj) session.getAttribute("stack");
            stack.setInput(pushInput);
            session.setAttribute("stack", stack);
        }
        return "redirect:Index";
    }

    @RequestMapping(value = "Process", method = RequestMethod.POST, params = "action=pop")
    public String pop(HttpSession session){
        StackObj stack = (StackObj) session.getAttribute("stack");
        stack.setInput("");
        session.setAttribute("stack", stack);
        return "redirect:Index";
    }
}
