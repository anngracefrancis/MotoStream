package cm.aptoide.pt.store.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.view.recycler.widget.Widget;

/* JADX INFO: loaded from: classes.dex */
public class GridStoreWidget extends Widget<GridStoreDisplayable> {
    private ImageView storeAvatar;
    private View storeLayout;
    private TextView storeName;

    public GridStoreWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(GridStoreDisplayable gridStoreDisplayable, Store store, Void r6) {
        String origin = gridStoreDisplayable.getOrigin();
        if (!origin.isEmpty()) {
            gridStoreDisplayable.getStoreAnalytics().sendStoreTabInteractEvent(origin, true);
            gridStoreDisplayable.getStoreAnalytics().sendStoreOpenEvent(origin, gridStoreDisplayable.getPojo().getName(), true);
        }
        getFragmentNavigator().navigateTo(AptoideApplication.getFragmentProvider().newStoreFragment(gridStoreDisplayable.getPojo().getName(), store.getAppearance().getTheme()), true);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.storeAvatar = (ImageView) view.findViewById(R.id.store_avatar_row);
        this.storeName = (TextView) view.findViewById(R.id.store_name_row);
        this.storeLayout = view.findViewById(R.id.store_main_layout_row);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final GridStoreDisplayable gridStoreDisplayable, int i2) {
        final Store pojo = gridStoreDisplayable.getPojo();
        this.storeName.setText(pojo.getName());
        this.compositeSubscription.a(e.g.a.c.a.a(this.storeLayout).G0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.x0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7765f.a(gridStoreDisplayable, pojo, (Void) obj);
            }
        }));
        androidx.fragment.app.d context = getContext();
        if (pojo.getId() == -1 || TextUtils.isEmpty(pojo.getAvatar())) {
            ImageLoader.with(context).loadUsingCircleTransform(R.drawable.ic_avatar_apps, this.storeAvatar);
        } else {
            ImageLoader.with(context).loadUsingCircleTransform(pojo.getAvatar(), this.storeAvatar);
        }
    }
}
