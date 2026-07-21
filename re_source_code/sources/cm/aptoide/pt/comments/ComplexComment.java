package cm.aptoide.pt.comments;

import cm.aptoide.pt.dataprovider.model.v7.Comment;

/* JADX INFO: loaded from: classes.dex */
public class ComplexComment extends Comment {
    private final int level;
    private final rx.b onClickReplyAction;

    public ComplexComment(CommentNode commentNode, rx.b bVar) {
        this.level = commentNode.getLevel();
        Comment comment = commentNode.getComment();
        setAdded(comment.getAdded());
        setBody(comment.getBody());
        setId(comment.getId());
        if (comment.getParent() != null) {
            setParent(comment.getParent());
        }
        setParentReview(comment.getParentReview());
        setUser(comment.getUser());
        this.onClickReplyAction = bVar;
    }

    public int getLevel() {
        return this.level;
    }

    public rx.b observeReplySubmission() {
        return this.onClickReplyAction;
    }
}
