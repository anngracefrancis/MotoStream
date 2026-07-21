package cm.aptoide.pt.app.view.similar.bundles;

import android.graphics.Rect;
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
import java.text.DecimalFormat;
import java.util.Collections;
import rx.s.b;

/* JADX INFO: loaded from: classes.dex */
public class SimilarAppsViewHolder extends SimilarBundleViewHolder {
    private AppViewSimilarAppsAdapter adapter;
    private final DecimalFormat oneDecimalFormat;
    private final b<SimilarAppClickEvent> similarAppClick;
    private final RecyclerView similarApps;

    public SimilarAppsViewHolder(View view, DecimalFormat decimalFormat, b<SimilarAppClickEvent> bVar) {
        super(view);
        this.oneDecimalFormat = decimalFormat;
        this.similarAppClick = bVar;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.similar_list);
        this.similarApps = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new RecyclerView.n() { // from class: cm.aptoide.pt.app.view.similar.bundles.SimilarAppsViewHolder.1
            @Override // androidx.recyclerview.widget.RecyclerView.n
            public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView2, RecyclerView.z zVar) {
                int pixelsForDip = AptoideUtils.ScreenU.getPixelsForDip(5, view2.getResources());
                rect.set(pixelsForDip, pixelsForDip, 0, pixelsForDip);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
        new SnapToStartHelper().attachToRecyclerView(recyclerView);
    }

    private void setSimilarAdapter() {
        AppViewSimilarAppsAdapter appViewSimilarAppsAdapter = new AppViewSimilarAppsAdapter(Collections.emptyList(), this.oneDecimalFormat, this.similarAppClick, AppViewSimilarAppsAdapter.SimilarAppType.SIMILAR_APPS);
        this.adapter = appViewSimilarAppsAdapter;
        this.similarApps.setAdapter(appViewSimilarAppsAdapter);
    }

    @Override // cm.aptoide.pt.app.view.similar.SimilarBundleViewHolder
    public void setBundle(SimilarAppsBundle similarAppsBundle, int i2) {
        if (this.adapter == null) {
            setSimilarAdapter();
        }
        this.adapter.update(mapToSimilar(similarAppsBundle.getContent(), similarAppsBundle.getContent().hasAd()));
    }
}
