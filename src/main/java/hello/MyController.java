package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by stannisbaratheon on 02/09/16.
 */
@Controller
public class MyController {


    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/David")
    //@ResponseBody
    String David () {

        //return "<html><head><body>Must Write a loooooong text </body></head></html>";

        return "foo";
    }

}
