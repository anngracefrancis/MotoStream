package cm.aptoide.pt.comments;

import cm.aptoide.pt.dataprovider.model.v7.Review;

/* JADX INFO: loaded from: classes.dex */
public final class ReviewWithAppName {
    private final String appName;
    private final Review review;

    public ReviewWithAppName(String str, Review review) {
        this.appName = str;
        this.review = review;
    }

    public String getAppName() {
        return this.appName;
    }

    public Review getReview() {
        return this.review;
    }
}
