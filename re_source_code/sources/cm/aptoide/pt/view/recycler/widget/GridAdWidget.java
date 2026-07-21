package cm.aptoide.pt.view.recycler.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.ads.MinimalAd;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.search.model.SearchAdResult;
import cm.aptoide.pt.view.recycler.displayable.GridAdDisplayable;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class GridAdWidget extends Widget<GridAdDisplayable> {
    private ImageView icon;
    private TextView name;
    private TextView rating;

    public GridAdWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(MinimalAd minimalAd, GridAdDisplayable gridAdDisplayable, Void r5) {
        getFragmentNavigator().navigateTo(AptoideApplication.getFragmentProvider().newAppViewFragment(new SearchAdResult(minimalAd), gridAdDisplayable.getTag()), true);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.name = (TextView) view.findViewById(R.id.name);
        this.icon = (ImageView) view.findViewById(R.id.icon);
        this.rating = (TextView) view.findViewById(R.id.rating_label);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final GridAdDisplayable gridAdDisplayable, int i2) {
        final MinimalAd pojo = gridAdDisplayable.getPojo();
        this.name.setText(pojo.getName());
        ImageLoader.with(getContext()).load(pojo.getIconPath(), this.icon);
        this.compositeSubscription.a(e.g.a.c.a.a(this.itemView).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.recycler.widget.a
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8116f.a(pojo, gridAdDisplayable, (Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.recycler.widget.b
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
        try {
            this.rating.setText(new DecimalFormat("0.0").format(pojo.getStars()));
        } catch (Exception unused) {
            this.rating.setText(R.string.appcardview_title_no_stars);
        }
    }
}
