package com.recalot.common.interfaces.controller;

/**
 * @author Matthaeus.schmedding
 */
public interface RecommenderController extends Controller {
    public enum RecommenderRequestAction implements RequestAction {
        Recommend (0),
        CreateRecommender (1),
        GetRecommender (2),
        GetRecommenders (3),
        UpdateRecommender (4),
        DeleteRecommender(5),
        GetRecommenderBuilder(6);

        private final int value;

        @Override
        public int getValue() {
            return this.value;
        }

        RecommenderRequestAction(int value) {
            this.value = value;
        }
    }
}
