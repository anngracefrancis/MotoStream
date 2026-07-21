package cm.aptoide.pt.app.view.similar;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.view.similar.bundles.SimilarAppcAppsViewHolder;
import cm.aptoide.pt.app.view.similar.bundles.SimilarAppsViewHolder;
import java.text.DecimalFormat;
import java.util.List;
import rx.s.b;

/* JADX INFO: loaded from: classes.dex */
public class SimilarAppsBundleAdapter extends RecyclerView.g<SimilarBundleViewHolder> {
    private static final int APPC_APPS = 2131492921;
    private static final int APPS = 2131492922;
    private List<SimilarAppsBundle> bundles;
    private final DecimalFormat decimalFormat;
    private final b<SimilarAppClickEvent> similarAppClick;

    /* JADX INFO: renamed from: cm.aptoide.pt.app.view.similar.SimilarAppsBundleAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$view$similar$SimilarAppsBundle$BundleType;

        static {
            int[] iArr = new int[SimilarAppsBundle.BundleType.values().length];
            $SwitchMap$cm$aptoide$pt$app$view$similar$SimilarAppsBundle$BundleType = iArr;
            try {
                iArr[SimilarAppsBundle.BundleType.APPS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$view$similar$SimilarAppsBundle$BundleType[SimilarAppsBundle.BundleType.APPC_APPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SimilarAppsBundleAdapter(List<SimilarAppsBundle> list, DecimalFormat decimalFormat, b<SimilarAppClickEvent> bVar) {
        this.bundles = list;
        this.decimalFormat = decimalFormat;
        this.similarAppClick = bVar;
    }

    public void add(SimilarAppsBundle similarAppsBundle) {
        this.bundles.add(similarAppsBundle);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.bundles.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        int i3 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$app$view$similar$SimilarAppsBundle$BundleType[this.bundles.get(i2).getType().ordinal()];
        if (i3 == 1) {
            return R.layout.appview_similar_layout;
        }
        if (i3 == 2) {
            return R.layout.appview_similar_appc_layout;
        }
        throw new IllegalStateException("Bundle type not supported by the adapter: " + this.bundles.get(i2).getType().name());
    }

    public void update(List<SimilarAppsBundle> list) {
        this.bundles = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(SimilarBundleViewHolder similarBundleViewHolder, int i2) {
        similarBundleViewHolder.setBundle(this.bundles.get(i2), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public SimilarBundleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        switch (i2) {
            case R.layout.appview_similar_appc_layout /* 2131492921 */:
                return new SimilarAppcAppsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.appview_similar_appc_layout, viewGroup, false), this.decimalFormat, this.similarAppClick);
            case R.layout.appview_similar_layout /* 2131492922 */:
                return new SimilarAppsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.appview_similar_layout, viewGroup, false), this.decimalFormat, this.similarAppClick);
            default:
                throw new IllegalStateException("Invalid bundle view type");
        }
    }

    public void add(List<SimilarAppsBundle> list) {
        this.bundles.addAll(list);
        notifyItemInserted(list.size() - 1);
    }
}
