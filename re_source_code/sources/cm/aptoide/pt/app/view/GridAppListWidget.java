package cm.aptoide.pt.app.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.recycler.widget.Widget;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class GridAppListWidget extends Widget<GridAppListDisplayable> {
    public ImageView icon;
    public TextView name;
    private TextView tvStoreName;
    private TextView tvTimeSinceModified;

    public GridAppListWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(App app, GridAppListDisplayable gridAppListDisplayable, Void r6) {
        getFragmentNavigator().navigateTo(AptoideApplication.getFragmentProvider().newAppViewFragment(app.getId(), app.getPackageName(), gridAppListDisplayable.getTag()), true);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.name = (TextView) view.findViewById(R.id.name);
        this.icon = (ImageView) view.findViewById(R.id.icon);
        this.tvTimeSinceModified = (TextView) view.findViewById(R.id.timeSinceModified);
        this.tvStoreName = (TextView) view.findViewById(R.id.storeName);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final GridAppListDisplayable gridAppListDisplayable, int i2) {
        final App pojo = gridAppListDisplayable.getPojo();
        this.name.setText(pojo.getName());
        Date updated = pojo.getUpdated();
        if (updated != null) {
            this.tvTimeSinceModified.setText(AptoideUtils.DateTimeU.getInstance(this.itemView.getContext()).getTimeDiffString(this.itemView.getContext(), updated.getTime(), getContext().getResources()));
        }
        this.name.setText(pojo.getName());
        this.name.setTypeface(null, 1);
        this.tvStoreName.setText(pojo.getStore().getName());
        this.tvStoreName.setTypeface(null, 1);
        androidx.fragment.app.d context = getContext();
        this.compositeSubscription.a(e.g.a.c.a.a(this.itemView).H0(new rx.m.b() { // from class: cm.aptoide.pt.app.view.kd
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4414f.a(pojo, gridAppListDisplayable, (Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.app.view.ld
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
        ImageLoader.with(context).load(pojo.getIcon(), this.icon);
    }
}
