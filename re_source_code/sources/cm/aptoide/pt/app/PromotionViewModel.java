package cm.aptoide.pt.app;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.promotions.Promotion;
import cm.aptoide.pt.promotions.WalletApp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: PromotionViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcm/aptoide/pt/app/PromotionViewModel;", HttpUrl.FRAGMENT_ENCODE_SET, "walletApp", "Lcm/aptoide/pt/promotions/WalletApp;", DeepLinkIntentReceiver.DeepLinksTargets.PROMOTIONS_DEEPLINK, HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/pt/promotions/Promotion;", "appViewModel", "Lcm/aptoide/pt/app/AppViewModel;", "(Lcm/aptoide/pt/promotions/WalletApp;Ljava/util/List;Lcm/aptoide/pt/app/AppViewModel;)V", "getAppViewModel", "()Lcm/aptoide/pt/app/AppViewModel;", "setAppViewModel", "(Lcm/aptoide/pt/app/AppViewModel;)V", "getPromotions", "()Ljava/util/List;", "setPromotions", "(Ljava/util/List;)V", "getWalletApp", "()Lcm/aptoide/pt/promotions/WalletApp;", "setWalletApp", "(Lcm/aptoide/pt/promotions/WalletApp;)V", "component1", "component2", "component3", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class PromotionViewModel {
    private AppViewModel appViewModel;
    private List<Promotion> promotions;
    private WalletApp walletApp;

    public PromotionViewModel() {
        this(null, null, null, 7, null);
    }

    public PromotionViewModel(WalletApp walletApp, List<Promotion> list, AppViewModel appViewModel) {
        kotlin.jvm.internal.m.f(walletApp, "walletApp");
        kotlin.jvm.internal.m.f(list, DeepLinkIntentReceiver.DeepLinksTargets.PROMOTIONS_DEEPLINK);
        this.walletApp = walletApp;
        this.promotions = list;
        this.appViewModel = appViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionViewModel copy$default(PromotionViewModel promotionViewModel, WalletApp walletApp, List list, AppViewModel appViewModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            walletApp = promotionViewModel.walletApp;
        }
        if ((i2 & 2) != 0) {
            list = promotionViewModel.promotions;
        }
        if ((i2 & 4) != 0) {
            appViewModel = promotionViewModel.appViewModel;
        }
        return promotionViewModel.copy(walletApp, list, appViewModel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WalletApp getWalletApp() {
        return this.walletApp;
    }

    public final List<Promotion> component2() {
        return this.promotions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AppViewModel getAppViewModel() {
        return this.appViewModel;
    }

    public final PromotionViewModel copy(WalletApp walletApp, List<Promotion> promotions, AppViewModel appViewModel) {
        kotlin.jvm.internal.m.f(walletApp, "walletApp");
        kotlin.jvm.internal.m.f(promotions, DeepLinkIntentReceiver.DeepLinksTargets.PROMOTIONS_DEEPLINK);
        return new PromotionViewModel(walletApp, promotions, appViewModel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromotionViewModel)) {
            return false;
        }
        PromotionViewModel promotionViewModel = (PromotionViewModel) other;
        return kotlin.jvm.internal.m.a(this.walletApp, promotionViewModel.walletApp) && kotlin.jvm.internal.m.a(this.promotions, promotionViewModel.promotions) && kotlin.jvm.internal.m.a(this.appViewModel, promotionViewModel.appViewModel);
    }

    public final AppViewModel getAppViewModel() {
        return this.appViewModel;
    }

    public final List<Promotion> getPromotions() {
        return this.promotions;
    }

    public final WalletApp getWalletApp() {
        return this.walletApp;
    }

    public int hashCode() {
        int iHashCode = ((this.walletApp.hashCode() * 31) + this.promotions.hashCode()) * 31;
        AppViewModel appViewModel = this.appViewModel;
        return iHashCode + (appViewModel == null ? 0 : appViewModel.hashCode());
    }

    public final void setAppViewModel(AppViewModel appViewModel) {
        this.appViewModel = appViewModel;
    }

    public final void setPromotions(List<Promotion> list) {
        kotlin.jvm.internal.m.f(list, "<set-?>");
        this.promotions = list;
    }

    public final void setWalletApp(WalletApp walletApp) {
        kotlin.jvm.internal.m.f(walletApp, "<set-?>");
        this.walletApp = walletApp;
    }

    public String toString() {
        return "PromotionViewModel(walletApp=" + this.walletApp + ", promotions=" + this.promotions + ", appViewModel=" + this.appViewModel + ')';
    }

    public /* synthetic */ PromotionViewModel(WalletApp walletApp, List list, AppViewModel appViewModel, int i2, kotlin.jvm.internal.g gVar) {
        this((i2 & 1) != 0 ? new WalletApp(null, false, null, null, 0L, null, null, 0, null, null, null, null, 0L, null, 0.0f, null, null, null, null, 524287, null) : walletApp, (i2 & 2) != 0 ? new ArrayList() : list, (i2 & 4) != 0 ? null : appViewModel);
    }
}
