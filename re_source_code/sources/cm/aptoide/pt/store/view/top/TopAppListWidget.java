package cm.aptoide.pt.store.view.top;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.home.AppSecondaryInfoViewHolder;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.recycler.widget.Widget;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class TopAppListWidget extends Widget<TopAppListDisplayable> {
    private ImageView appIcon;
    private AppSecondaryInfoViewHolder appInfoViewHolder;
    private TextView downloadNumber;
    private TextView name;
    private DecimalFormat oneDecimalFormatter;
    private TextView topNumber;

    public TopAppListWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(App app, TopAppListDisplayable topAppListDisplayable, Void r11) {
        getFragmentNavigator().navigateTo(AptoideApplication.getFragmentProvider().newAppViewFragment(app.getId(), app.getPackageName(), app.getStore().getAppearance().getTheme(), app.getStore().getName(), topAppListDisplayable.getTag(), String.valueOf(getAdapterPosition())), true);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.topNumber = (TextView) view.findViewById(R.id.top_number);
        this.appIcon = (ImageView) view.findViewById(R.id.icon);
        this.name = (TextView) view.findViewById(R.id.name_label);
        this.downloadNumber = (TextView) view.findViewById(R.id.download_number_label);
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        this.oneDecimalFormatter = decimalFormat;
        this.appInfoViewHolder = new AppSecondaryInfoViewHolder(view, decimalFormat);
        ((TextView) view.findViewById(R.id.rating_label)).setTextAppearance(view.getContext(), R.style.Aptoide_TextView_Medium_XXS_Black);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final TopAppListDisplayable topAppListDisplayable, int i2) {
        final App pojo = topAppListDisplayable.getPojo();
        ImageLoader.with(this.itemView.getContext()).loadWithRoundCorners(pojo.getIcon(), 8, this.appIcon, R.attr.placeholder_square);
        this.name.setText(pojo.getName());
        this.topNumber.setText(String.valueOf(i2 + 1));
        this.appInfoViewHolder.setInfo(pojo.getAppcoins().hasBilling(), pojo.getStats().getRating().getAvg(), true, true);
        this.downloadNumber.setText(String.format("%s %s", AptoideUtils.StringU.withSuffix(pojo.getStats().getDownloads()), this.itemView.getContext().getResources().getString(R.string.downloads)));
        this.compositeSubscription.a(e.g.a.c.a.a(this.itemView).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.top.a
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7737f.a(pojo, topAppListDisplayable, (Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.top.b
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }
}
