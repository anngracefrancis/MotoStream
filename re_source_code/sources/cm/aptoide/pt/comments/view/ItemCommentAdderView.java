package cm.aptoide.pt.comments.view;

import cm.aptoide.pt.comments.view.CommentsAdapter;
import cm.aptoide.pt.view.recycler.displayable.Displayable;

/* JADX INFO: loaded from: classes.dex */
public interface ItemCommentAdderView<Titem, Tadapter extends CommentsAdapter> extends CommentAdderView<Tadapter> {
    Displayable createReadMoreDisplayable(int i2, Titem titem);
}
