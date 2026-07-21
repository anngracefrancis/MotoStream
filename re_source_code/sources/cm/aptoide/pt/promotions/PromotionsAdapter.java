package cm.aptoide.pt.promotions;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.app.DownloadModel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PromotionsAdapter extends RecyclerView.g<RecyclerView.c0> {
    static final int CLAIM = 4;
    static final int CLAIMED = 5;
    static final int DOWNGRADE = 6;
    static final int DOWNLOAD = 1;
    static final int DOWNLOADING = 2;
    static final int INSTALL = 3;
    static final int UPDATE = 0;
    private List<PromotionViewApp> appsList;
    private boolean isWalletInstalled;
    private PromotionsViewHolderFactory viewHolderFactory;

    /* JADX INFO: renamed from: cm.aptoide.pt.promotions.PromotionsAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action;

        static {
            int[] iArr = new int[DownloadModel.Action.values().length];
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = iArr;
            try {
                iArr[DownloadModel.Action.DOWNGRADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.INSTALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public PromotionsAdapter(List<PromotionViewApp> list, PromotionsViewHolderFactory promotionsViewHolderFactory) {
        this.appsList = list;
        this.viewHolderFactory = promotionsViewHolderFactory;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.appsList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        PromotionViewApp promotionViewApp = this.appsList.get(i2);
        if (promotionViewApp.isClaimed()) {
            return 5;
        }
        DownloadModel downloadModel = promotionViewApp.getDownloadModel();
        if (downloadModel.isDownloading()) {
            return 2;
        }
        int i3 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[downloadModel.getAction().ordinal()];
        if (i3 == 1) {
            return 6;
        }
        if (i3 == 2) {
            return 3;
        }
        if (i3 == 3) {
            return 4;
        }
        if (i3 == 4) {
            return 0;
        }
        throw new IllegalArgumentException("Invalid type of download action");
    }

    public void isWalletInstalled(boolean z) {
        this.isWalletInstalled = z;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.c0 c0Var, int i2) {
        if (c0Var instanceof PromotionAppDownloadingViewHolder) {
            ((PromotionAppDownloadingViewHolder) c0Var).setApp(this.appsList.get(i2));
        } else {
            if (!(c0Var instanceof PromotionAppViewHolder)) {
                throw new IllegalStateException("Invalid type of ViewHolder");
            }
            ((PromotionAppViewHolder) c0Var).setApp(this.appsList.get(i2), this.isWalletInstalled);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.c0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return this.viewHolderFactory.createViewHolder(viewGroup, i2);
    }

    public void setPromotionApp(PromotionViewApp promotionViewApp) {
        int iIndexOf = this.appsList.indexOf(promotionViewApp);
        if (iIndexOf != -1) {
            this.appsList.set(iIndexOf, promotionViewApp);
            notifyItemChanged(iIndexOf);
        } else {
            this.appsList.add(promotionViewApp);
            notifyDataSetChanged();
        }
    }

    public void updateClaimStatus(String str) {
        for (PromotionViewApp promotionViewApp : this.appsList) {
            if (promotionViewApp.getPackageName().equals(str)) {
                promotionViewApp.setClaimed();
                notifyDataSetChanged();
            }
        }
    }
}
