package com.recalot.common.interfaces.template;


import com.recalot.common.builder.RecommenderBuilder;
import com.recalot.common.communication.RecommendationResult;
import com.recalot.common.communication.TemplateResult;
import com.recalot.common.interfaces.model.rec.Recommender;
import com.recalot.common.interfaces.model.rec.RecommenderInformation;

/**
 * @author Matthaeus.schmedding
 */
public interface RecommenderTemplate extends BaseTemplate {

    public String getKey();
    public TemplateResult transform(RecommenderInformation[] recommenders);
    public TemplateResult transform(Recommender recommender);
    public TemplateResult transform(RecommenderBuilder builder);
    public TemplateResult transform(RecommendationResult recommend);
}
