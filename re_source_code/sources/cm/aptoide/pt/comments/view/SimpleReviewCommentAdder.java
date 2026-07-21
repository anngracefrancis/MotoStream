package cm.aptoide.pt.comments.view;

import cm.aptoide.pt.comments.CommentAdder;
import cm.aptoide.pt.dataprovider.model.v7.Comment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SimpleReviewCommentAdder extends CommentAdder {
    private final CommentAdderView commentAdderView;

    public SimpleReviewCommentAdder(int i2, CommentAdderView commentAdderView) {
        super(i2);
        this.commentAdderView = commentAdderView;
    }

    @Override // cm.aptoide.pt.comments.CommentAdder
    public void addComment(List<Comment> list) {
        int itemPosition = this.commentAdderView.getAdapter().getItemPosition(this.itemIndex + 1);
        if (itemPosition == -1) {
            itemPosition = this.commentAdderView.getAdapter().getItemCount();
        }
        int i2 = itemPosition - 1;
        this.commentAdderView.getAdapter().removeDisplayable(i2);
        ArrayList arrayList = new ArrayList();
        this.commentAdderView.createDisplayableComments(list, arrayList);
        this.commentAdderView.getAdapter().addDisplayables(i2, arrayList);
    }
}
