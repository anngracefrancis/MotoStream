package cm.aptoide.pt.comments.view;

import cm.aptoide.pt.comments.view.CommentsAdapter;
import cm.aptoide.pt.dataprovider.model.v7.Comment;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CommentAdderView<Tadapter extends CommentsAdapter> {
    void createDisplayableComments(List<Comment> list, List<Displayable> list2);

    Tadapter getAdapter();
}
