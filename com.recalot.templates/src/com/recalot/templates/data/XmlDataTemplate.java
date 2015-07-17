package com.recalot.templates.data;

import com.recalot.common.builder.DataSourceBuilder;
import com.recalot.common.communication.*;
import com.recalot.common.exceptions.BaseException;
import com.recalot.common.interfaces.model.data.DataInformation;
import com.recalot.common.interfaces.model.data.DataSource;
import com.recalot.common.interfaces.template.DataTemplate;
import com.recalot.templates.base.XmlBaseTemplate;

import java.io.IOException;
import java.util.List;

/**
 * @author matthaeus.schmedding
 */
public class XmlDataTemplate extends XmlBaseTemplate implements DataTemplate {
    @Override
    public TemplateResult transform(DataSet dataSet) {
        return null;
    }

    @Override
    public TemplateResult transform(Interaction[] interactions) {
        return null;
    }

    @Override
    public TemplateResult transform(Interaction interaction) {
        return null;
    }

    @Override
    public TemplateResult transform(Item[] items) {
        return null;
    }

    @Override
    public TemplateResult transform(Item item) {
        return null;
    }

    @Override
    public TemplateResult transform(User[] users) {
        return null;
    }

    @Override
    public TemplateResult transform(User user) {
        return null;
    }

    @Override
    public TemplateResult transform(List<DataInformation> sources) {
        return null;
    }

    @Override
    public TemplateResult transform(DataSource source) {
        return null;
    }

    @Override
    public TemplateResult transform(DataInformation info) throws BaseException {
        return null;
    }

    @Override
    public TemplateResult transform(DataSourceBuilder source) throws BaseException {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
