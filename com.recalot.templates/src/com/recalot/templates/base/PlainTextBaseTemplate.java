package com.recalot.templates.base;

import com.recalot.common.communication.Message;
import com.recalot.common.communication.TemplateResult;
import com.recalot.common.exceptions.BaseException;
import com.recalot.common.interfaces.template.BaseTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author matthaeus.schmedding
 */
public class PlainTextBaseTemplate implements BaseTemplate {
    protected static String MimeType = "text/plain";
    protected static Charset charset = StandardCharsets.UTF_8;

    @Override
    public String getKey() {
        return "text";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public TemplateResult transform(BaseException ex) {
        return new TemplateResult(404, MimeType, new ByteArrayInputStream(ex.getMessage().getBytes(charset)), charset);
    }

    @Override
    public TemplateResult transform(Message message) {
        int status = 200;
        switch (message.getStatus()) {
            case DEBUG:
            case INFO:
            case WARN:
                status = 200;
                break;
            case ERROR:
                status = 404;
                break;
            case FATAL:
                status = 500;
                break;
        }

        return new TemplateResult(status, MimeType, new ByteArrayInputStream(message.getBody().getBytes(charset)), charset);
    }

    @Override
    public void close() throws IOException {

    }
}
