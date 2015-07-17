package com.recalot.templates.rec;

import com.recalot.common.builder.RecommenderBuilder;
import com.recalot.common.communication.RecommendationResult;
import com.recalot.common.communication.TemplateResult;
import com.recalot.common.interfaces.model.rec.Recommender;
import com.recalot.common.interfaces.model.rec.RecommenderInformation;
import com.recalot.common.interfaces.template.RecommenderTemplate;
import com.recalot.templates.base.XmlBaseTemplate;

import java.io.IOException;

/**
 * @author matthaeus.schmedding
 */
public class XmlRecommenderTemplate extends XmlBaseTemplate implements RecommenderTemplate  {

    @Override
    public TemplateResult transform(RecommenderInformation[] recommenders) {
        return null;
    }

    @Override
    public TemplateResult transform(Recommender recommender) {
        return null;
    }

    @Override
    public TemplateResult transform(RecommenderBuilder builder) {
        return null;
    }

    @Override
    public TemplateResult transform(RecommendationResult recommend) {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
