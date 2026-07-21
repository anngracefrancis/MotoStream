package cm.aptoide.pt.comments;

import cm.aptoide.pt.dataprovider.model.v7.Comment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommentNode {
    private final List<CommentNode> childComments;
    private Comment comment;
    private int level;

    public CommentNode() {
        this(null);
    }

    public void addChild(CommentNode commentNode) {
        this.childComments.add(commentNode);
    }

    public List<CommentNode> getChildComments() {
        return this.childComments;
    }

    public Comment getComment() {
        return this.comment;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean hasChild() {
        return this.childComments.size() > 0;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setLevel(int i2) {
        this.level = i2;
    }

    public CommentNode(Comment comment) {
        this.level = 1;
        this.comment = comment;
        this.childComments = new ArrayList();
    }
}
