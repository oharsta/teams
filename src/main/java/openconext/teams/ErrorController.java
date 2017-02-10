package openconext.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {

    @Autowired
    private Environment environment;

    private final ErrorAttributes errorAttributes;

    @Autowired
    public ErrorController(ErrorAttributes errorAttributes) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest aRequest) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(aRequest);
        Map<String, Object> result = this.errorAttributes.getErrorAttributes(requestAttributes, false);

        HttpStatus statusCode = INTERNAL_SERVER_ERROR;
        Object status = result.get("status");
        if (status != null && status instanceof Integer && ((Integer) status != 999)) {
            statusCode = HttpStatus.valueOf(Integer.class.cast(status).intValue());
        }
        return new ResponseEntity<>(result, statusCode);

    }
}
