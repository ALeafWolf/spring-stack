package sheridan.qina.quiz1.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class StackObj implements Serializable {
    private Logger logger = LoggerFactory.getLogger(StackObj.class);

    private Stack<String> stack;
    @NotBlank
    private String input;
    private ArrayList<String> displayStack;

    public StackObj() {
        stack = new Stack<String>();
        displayStack = new ArrayList<String>();

    }

    public Stack<String> getStack() {
        return stack;
    }

//    public void setStack(Stack<String> stack) {
//        this.stack = stack;
//    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
        if(input == ""){
            this.stack.pop();
        }else{
            this.stack.push(input);
        }
        this.displayStack = new ArrayList(this.stack);
        Collections.reverse(displayStack);
    }

    public ArrayList<String> getDisplayStack() {
        return displayStack;
    }

//    public void setDisplayStack(ArrayList<String> displayStack) {
//        this.displayStack = displayStack;
//    }
}
