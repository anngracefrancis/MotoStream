package cm.aptoide.pt.comments;

import cm.aptoide.pt.dataprovider.model.v7.Comment;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class CommentAdder {
    protected final int itemIndex;

    public CommentAdder(int i2) {
        this.itemIndex = i2;
    }

    public abstract void addComment(List<Comment> list);

    public void collapseComments() {
    }
}
