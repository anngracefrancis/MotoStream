package cm.aptoide.pt.store.view.featured;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.view.recycler.widget.Widget;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class AppBrickListWidget extends Widget<AppBrickListDisplayable> {
    private ImageView appIcon;
    private ImageView graphic;
    private TextView name;
    private DecimalFormat oneDecimalFormatter;
    private TextView rating;

    public AppBrickListWidget(View view) {
        super(view);
        this.oneDecimalFormatter = new DecimalFormat("0.0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(App app, AppBrickListDisplayable appBrickListDisplayable, Void r11) {
        getFragmentNavigator().navigateTo(AptoideApplication.getFragmentProvider().newAppViewFragment(app.getId(), app.getPackageName(), app.getStore().getAppearance().getTheme(), app.getStore().getName(), appBrickListDisplayable.getTag(), String.valueOf(getAdapterPosition())), true);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.appIcon = (ImageView) view.findViewById(R.id.app_icon);
        this.name = (TextView) view.findViewById(R.id.app_name);
        this.graphic = (ImageView) view.findViewById(R.id.featured_graphic);
        this.rating = (TextView) view.findViewById(R.id.rating_label);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final AppBrickListDisplayable appBrickListDisplayable, int i2) {
        final App pojo = appBrickListDisplayable.getPojo();
        ImageLoader.with(getContext()).load(pojo.getIcon(), R.attr.placeholder_square, this.appIcon);
        ImageLoader.with(getContext()).load(pojo.getGraphic(), R.attr.placeholder_brick, this.graphic);
        this.name.setText(pojo.getName());
        float avg = pojo.getStats().getRating().getAvg();
        if (avg == 0.0f) {
            this.rating.setText(R.string.appcardview_title_no_stars);
        } else {
            this.rating.setText(this.oneDecimalFormatter.format(avg));
        }
        this.compositeSubscription.a(e.g.a.c.a.a(this.itemView).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.featured.a
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7607f.a(pojo, appBrickListDisplayable, (Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.featured.b
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }
}
