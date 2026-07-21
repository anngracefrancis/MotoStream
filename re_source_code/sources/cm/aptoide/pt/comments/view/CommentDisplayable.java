package cm.aptoide.pt.comments.view;

import android.view.View;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.Comment;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.store.view.StoreFragment;
import cm.aptoide.pt.view.FragmentProvider;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import com.google.android.material.snackbar.Snackbar;

/* JADX INFO: loaded from: classes.dex */
public class CommentDisplayable extends Displayable {
    private final Comment comment;
    private FragmentNavigator fragmentNavigator;
    private FragmentProvider fragmentProvider;

    public CommentDisplayable(Comment comment, FragmentNavigator fragmentNavigator, FragmentProvider fragmentProvider) {
        this.comment = comment;
        this.fragmentNavigator = fragmentNavigator;
        this.fragmentProvider = fragmentProvider;
    }

    public Comment getComment() {
        return this.comment;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.comment_layout;
    }

    public void itemClicked(View view) {
        if (this.comment.getUser().getAccess() == Comment.Access.PUBLIC) {
            this.fragmentNavigator.navigateTo(this.fragmentProvider.newStoreFragment(this.comment.getUser().getId(), "DEFAULT", StoreFragment.OpenType.GetHome), true);
        } else {
            Snackbar.Z(view, R.string.stores_message_private_user, -1).P();
        }
    }

    public CommentDisplayable() {
        this.comment = null;
    }
}
