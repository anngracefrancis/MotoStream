package cm.aptoide.pt.app.view.similar.bundles;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.view.AppViewSimilarAppsAdapter;
import cm.aptoide.pt.app.view.similar.SimilarAppClickEvent;
import cm.aptoide.pt.app.view.similar.SimilarAppsBundle;
import cm.aptoide.pt.app.view.similar.SimilarBundleViewHolder;
import cm.aptoide.pt.home.SnapToStartHelper;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.custom.HorizontalHeaderItemDecoration;
import java.text.DecimalFormat;
import java.util.Collections;
import rx.s.b;

/* JADX INFO: loaded from: classes.dex */
public class SimilarAppcAppsViewHolder extends SimilarBundleViewHolder {
    private AppViewSimilarAppsAdapter adapter;
    private final DecimalFormat oneDecimalFormat;
    private final b<SimilarAppClickEvent> similarAppClick;
    private final RecyclerView similarAppcApps;

    public SimilarAppcAppsViewHolder(View view, DecimalFormat decimalFormat, b<SimilarAppClickEvent> bVar) {
        super(view);
        this.oneDecimalFormat = decimalFormat;
        this.similarAppClick = bVar;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.similar_appc_list);
        this.similarAppcApps = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new HorizontalHeaderItemDecoration(view.getContext(), recyclerView, R.layout.appview_appc_similar_header, AptoideUtils.ScreenU.getPixelsForDip(112, view.getResources()), AptoideUtils.ScreenU.getPixelsForDip(5, view.getResources())));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
        new SnapToStartHelper().attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(getSimilarAdapter());
    }

    private RecyclerView.g getSimilarAdapter() {
        AppViewSimilarAppsAdapter appViewSimilarAppsAdapter = new AppViewSimilarAppsAdapter(Collections.emptyList(), this.oneDecimalFormat, this.similarAppClick, AppViewSimilarAppsAdapter.SimilarAppType.APPC_SIMILAR_APPS);
        this.adapter = appViewSimilarAppsAdapter;
        return appViewSimilarAppsAdapter;
    }

    @Override // cm.aptoide.pt.app.view.similar.SimilarBundleViewHolder
    public void setBundle(SimilarAppsBundle similarAppsBundle, int i2) {
        this.adapter.update(mapToSimilar(similarAppsBundle.getContent(), false));
    }
}
