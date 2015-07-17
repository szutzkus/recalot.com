package com.recalot.templates.experiments;

import com.recalot.common.builder.MetricBuilder;
import com.recalot.common.communication.TemplateResult;
import com.recalot.common.exceptions.BaseException;
import com.recalot.common.interfaces.model.experiment.DataSplitter;
import com.recalot.common.interfaces.model.experiment.Experiment;
import com.recalot.common.interfaces.template.ExperimentTemplate;
import com.recalot.templates.base.JsonBaseTemplate;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by matthaeus.schmedding on 01.04.2015.
 */
public class JsonExperimentTemplate extends JsonBaseTemplate implements ExperimentTemplate {
    @Override
    public TemplateResult transform(Experiment experiment) throws BaseException {
        String result = getSerializer().include("id", "state", "percentage", "results", "results.*", "recommenderIds", "dataSourceId").exclude("*").serialize(experiment);
        return new TemplateResult(200, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }

    @Override
    public TemplateResult transform(List<Experiment> experiments) throws BaseException {
        String result = getSerializer().include("state", "id").exclude("*").serialize(experiments);
        return new TemplateResult(200, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }

    @Override
    public TemplateResult transformMetrics(List<MetricBuilder> metrics) throws BaseException {
        String result = getSerializer().serialize(metrics);
        return new TemplateResult(200, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }

    @Override
    public TemplateResult transform(MetricBuilder metric) throws BaseException {
        String result = getSerializer().include("configuration").serialize(metric);
        return new TemplateResult(200, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }

    @Override
        public TemplateResult transformSplitters(List<DataSplitter> splitters) throws BaseException {
        String result = getSerializer().serialize(splitters);
        return new TemplateResult(200, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }

    @Override
    public TemplateResult transform(DataSplitter splitter) throws BaseException {

        String result = getSerializer().include("configuration").serialize(splitter);
        return new TemplateResult(200, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }
}
