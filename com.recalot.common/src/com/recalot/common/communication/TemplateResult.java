package com.recalot.common.communication;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author Matthäus Schmedding (info@recalot.com)
 */
public class TemplateResult {
    private int status;
    private String contentType;
    private InputStream inputStream;
    private Charset charset;

    public TemplateResult(int status, String contentType, InputStream inputStream, Charset charset) {
        this.status = status;
        this.contentType = contentType;
        this.inputStream = inputStream;
        this.charset = charset;
    }

    public int getStatus() {
        return status;
    }

    public String getContentType() {
        return contentType;
    }

    public InputStream getResult() {
        return inputStream;
    }

    public Charset getCharset() {
        return charset;
    }
}
