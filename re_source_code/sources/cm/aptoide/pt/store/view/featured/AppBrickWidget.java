package cm.aptoide.pt.store.view.featured;

import android.view.View;
import android.widget.ImageView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.view.recycler.widget.Widget;

/* JADX INFO: loaded from: classes.dex */
public class AppBrickWidget extends Widget<AppBrickDisplayable> {
    private ImageView graphic;

    public AppBrickWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(AppBrickDisplayable appBrickDisplayable, Void r10) {
        getFragmentNavigator().navigateTo(AptoideApplication.getFragmentProvider().newAppViewFragment(appBrickDisplayable.getPojo().getId(), appBrickDisplayable.getPojo().getPackageName(), appBrickDisplayable.getPojo().getStore().getAppearance().getTheme(), appBrickDisplayable.getPojo().getStore().getName(), appBrickDisplayable.getTag(), String.valueOf(getAdapterPosition())), true);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.graphic = (ImageView) view.findViewById(R.id.featured_graphic);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final AppBrickDisplayable appBrickDisplayable, int i2) {
        ImageLoader.with(getContext()).load(appBrickDisplayable.getPojo().getGraphic(), R.attr.placeholder_brick, this.graphic);
        this.compositeSubscription.a(e.g.a.c.a.a(this.itemView).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.featured.c
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7611f.a(appBrickDisplayable, (Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.featured.d
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }
}
