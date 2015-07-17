package com.recalot.templates.base;

import com.recalot.common.communication.Message;
import com.recalot.common.communication.TemplateResult;
import com.recalot.common.exceptions.BaseException;
import com.recalot.common.interfaces.template.BaseTemplate;
import flexjson.JSONSerializer;
import flexjson.transformer.IterableTransformer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author matthaeus.schmedding
 */
public class JsonBaseTemplate implements BaseTemplate {
    protected static String MimeType = "application/json";
    protected static Charset charset = StandardCharsets.UTF_8;

    public JSONSerializer getSerializer() {
        return new JSONSerializer().transform(new IterableTransformer(), "Iterable.class").exclude("class", "*.class");
    }

    @Override
    public String getKey() {
        return "json";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public TemplateResult transform(BaseException ex) {
        String result = getSerializer().serialize(ex);

        return new TemplateResult(404, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }

    @Override
    public TemplateResult transform(Message message) {
        String result = getSerializer().serialize(message);
        int status = 200;
        switch (message.getStatus()) {
            case DEBUG:
                status = 200;
                break;
            case INFO:
                status = 200;
                break;
            case ERROR:
                status = 404;
                break;
            case FATAL:
                status = 500;
                break;
            case WARN:
                status = 200;
                break;
        }
        return new TemplateResult(status, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }

    @Override
    public void close() throws IOException {

    }
}
