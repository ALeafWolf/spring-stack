package sheridan.qina.quiz1.stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Stack;

@Controller
public class MainController {

    @RequestMapping(value={"/", "Index"})
    public ModelAndView index(HttpSession httpSession){
        ModelAndView modelAndView;
        Stack<String> stack = (Stack<String>) httpSession.getAttribute("stack");
        if(stack == null){
            stack = new Stack<String>();
            stack.push("roast");
            stack.push("roast");
            stack.push("life");
            httpSession.setAttribute("stack", stack);
        }
        modelAndView = new ModelAndView("index", "displayStack", new ArrayList(stack));
        return modelAndView;
    }

    @RequestMapping(value = "Push", method = RequestMethod.POST)
    public String push(HttpSession httpSession){
        return "redirect:Index";
    }

    @RequestMapping(value = "Pop", method = RequestMethod.POST)
    public String pop(HttpSession httpSession){
        return "redirect:Index";
    }
}
