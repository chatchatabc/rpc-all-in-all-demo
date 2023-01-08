package com.chatchatabc.rpc.application.trpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import java.beans.PropertyEditorSupport;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linux_china
 */
@RestController
public abstract class TrpcBaseController {
    @Autowired
    ObjectMapper objectMapper;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(JsonNode.class, new JsonNodeEditor(objectMapper));
    }

    public static class JsonNodeEditor extends PropertyEditorSupport {
        private final ObjectMapper objectMapper;

        public JsonNodeEditor(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (StringUtils.hasLength(text)) {
                try {
                    setValue(objectMapper.readValue(text, JsonNode.class));
                    return;
                } catch (JsonProcessingException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            setValue(null);
        }
    }
}
