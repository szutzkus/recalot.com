package com.recalot.templates.rec;

import com.recalot.common.builder.RecommenderBuilder;
import com.recalot.common.communication.RecommendationResult;
import com.recalot.common.communication.TemplateResult;
import com.recalot.common.interfaces.model.rec.Recommender;
import com.recalot.common.interfaces.model.rec.RecommenderInformation;
import com.recalot.common.interfaces.template.RecommenderTemplate;
import com.recalot.templates.base.JsonBaseTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author matthaeus.schmedding
 */
public class JsonRecommenderTemplate extends JsonBaseTemplate implements RecommenderTemplate  {
    @Override
    public TemplateResult transform(RecommenderInformation[] recommenders) {
        String result = getSerializer().include("id", "state").exclude("*").serialize(recommenders);

        return new TemplateResult(200, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }

    @Override
    public TemplateResult transform(Recommender recommender) {
        String result = getSerializer().exclude("class").include("dataSet", "key", "state", "id").exclude("*").serialize(recommender);

        return new TemplateResult(200, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }

    @Override
    public TemplateResult transform(RecommenderBuilder recommender) {
        String result = getSerializer().exclude("class").include("configuration", "configuration.*").serialize(recommender);

        return new TemplateResult(200, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }

    @Override
    public TemplateResult transform(RecommendationResult recommend) {
        String result = getSerializer().include("items").exclude("*.class", "class", "dataset").serialize(recommend);

        return new TemplateResult(200, MimeType, new ByteArrayInputStream(result.getBytes(charset)), charset);
    }

    @Override
    public void close() throws IOException {

    }
}
