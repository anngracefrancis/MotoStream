package cm.aptoide.pt.app.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.view.GridAppDisplayable;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.home.AppSecondaryInfoViewHolder;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.view.recycler.widget.Widget;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class GridAppWidget<T extends GridAppDisplayable> extends Widget<T> {
    private AppSecondaryInfoViewHolder appInfoViewHolder;
    private ImageView icon;
    private TextView name;
    private String storeName;

    public GridAppWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$newOnClickListener$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(long j2, App app, GridAppDisplayable gridAppDisplayable, Void r12) {
        getFragmentNavigator().navigateTo(AptoideApplication.getFragmentProvider().newAppViewFragment(j2, app.getPackageName(), app.getStore().getAppearance().getTheme(), this.storeName, gridAppDisplayable.getTag()), true);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.name = (TextView) this.itemView.findViewById(R.id.name);
        this.icon = (ImageView) this.itemView.findViewById(R.id.icon);
        this.appInfoViewHolder = new AppSecondaryInfoViewHolder(this.itemView, new DecimalFormat("0.0"));
    }

    protected rx.m.b<Void> newOnClickListener(final T t, final App app, final long j2) {
        return new rx.m.b() { // from class: cm.aptoide.pt.app.view.md
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4452f.a(j2, app, t, (Void) obj);
            }
        };
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(T t, int i2) {
        App app = (App) t.getPojo();
        long id = app.getId();
        ImageLoader.with(getContext()).load(app.getIcon(), this.icon);
        this.name.setText(app.getName());
        this.appInfoViewHolder.setInfo(app.hasBilling(), app.getStats().getRating().getAvg(), true, false);
        this.storeName = app.getStore().getName();
        this.compositeSubscription.a(e.g.a.c.a.a(this.itemView).H0(newOnClickListener(t, app, id), new rx.m.b() { // from class: cm.aptoide.pt.app.view.nd
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }
}
