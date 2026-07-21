package cm.aptoide.pt.timeline.view.follow;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import cm.aptoide.pt.R;
import cm.aptoide.pt.store.view.AddStoreDialog;
import cm.aptoide.pt.timeline.view.displayable.FollowStoreDisplayable;
import cm.aptoide.pt.view.recycler.widget.Widget;

/* JADX INFO: loaded from: classes.dex */
public class FollowStoreWidget extends Widget<FollowStoreDisplayable> {
    private View storeLayout;

    public FollowStoreWidget(View view) {
        super(view);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.storeLayout = view.findViewById(R.id.store_tab_follow_store_layout);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(FollowStoreDisplayable followStoreDisplayable, int i2) {
        final FragmentManager supportFragmentManager = getContext().getSupportFragmentManager();
        this.compositeSubscription.a(e.g.a.c.a.a(this.storeLayout).G0(new rx.m.b() { // from class: cm.aptoide.pt.timeline.view.follow.a
            @Override // rx.m.b
            public final void call(Object obj) {
                new AddStoreDialog().show(supportFragmentManager, "addStoreDialog");
            }
        }));
    }
}
