package cm.aptoide.pt.view;

import cm.aptoide.pt.promotions.ClaimPromotionsManager;
import cm.aptoide.pt.promotions.PromotionsManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesClaimPromotionsManagerFactory implements Provider {
    private final FragmentModule module;
    private final Provider<PromotionsManager> promotionsManagerProvider;

    public FragmentModule_ProvidesClaimPromotionsManagerFactory(FragmentModule fragmentModule, Provider<PromotionsManager> provider) {
        this.module = fragmentModule;
        this.promotionsManagerProvider = provider;
    }

    public static FragmentModule_ProvidesClaimPromotionsManagerFactory create(FragmentModule fragmentModule, Provider<PromotionsManager> provider) {
        return new FragmentModule_ProvidesClaimPromotionsManagerFactory(fragmentModule, provider);
    }

    public static ClaimPromotionsManager providesClaimPromotionsManager(FragmentModule fragmentModule, PromotionsManager promotionsManager) {
        return (ClaimPromotionsManager) f.b.b.c(fragmentModule.providesClaimPromotionsManager(promotionsManager));
    }

    @Override // javax.inject.Provider
    public ClaimPromotionsManager get() {
        return providesClaimPromotionsManager(this.module, this.promotionsManagerProvider.get());
    }
}
