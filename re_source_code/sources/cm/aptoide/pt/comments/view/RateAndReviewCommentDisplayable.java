package cm.aptoide.pt.comments.view;

import cm.aptoide.pt.R;
import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.comments.CommentAdder;
import cm.aptoide.pt.comments.ReviewWithAppName;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablePojo;

/* JADX INFO: loaded from: classes.dex */
public class RateAndReviewCommentDisplayable extends DisplayablePojo<ReviewWithAppName> {
    private CommentAdder commentAdder;
    private int numberComments;
    private UserFeedbackAnalytics userFeedbackAnalytics;

    public RateAndReviewCommentDisplayable() {
    }

    public CommentAdder getCommentAdder() {
        return this.commentAdder;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    public int getNumberComments() {
        return this.numberComments;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.displayable_rate_and_review;
    }

    public void sendVoteDownEvent() {
        this.userFeedbackAnalytics.sendVoteDownEvent();
    }

    public void sendVoteUpEvent() {
        this.userFeedbackAnalytics.sendVoteUpEvent();
    }

    public RateAndReviewCommentDisplayable(ReviewWithAppName reviewWithAppName, CommentAdder commentAdder, int i2, UserFeedbackAnalytics userFeedbackAnalytics) {
        super(reviewWithAppName);
        this.commentAdder = commentAdder;
        this.numberComments = i2;
        this.userFeedbackAnalytics = userFeedbackAnalytics;
    }
}
