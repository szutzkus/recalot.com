package com.recalot.common.communication;

import java.util.List;

/**
 * @author Matthäus Schmedding (info@recalot.com)
 */
public class RecommendationResult {
    private String recommenderKey;
    private List<RecommendedItem> items;

    public RecommendationResult(String recommenderKey, List<RecommendedItem> items) {
        this.recommenderKey = recommenderKey;
        this.items = items;

    }

    public String getRecommender() {
        return recommenderKey;
    }

    public List<RecommendedItem> getItems() {
        return items;
    }
}
