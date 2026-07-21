package cm.aptoide.pt.view;

import cm.aptoide.pt.notification.AppcPromotionNotificationStringProvider;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesAppcPromotionNotificationStringProviderFactory implements Provider {
    private final FragmentModule module;

    public FragmentModule_ProvidesAppcPromotionNotificationStringProviderFactory(FragmentModule fragmentModule) {
        this.module = fragmentModule;
    }

    public static FragmentModule_ProvidesAppcPromotionNotificationStringProviderFactory create(FragmentModule fragmentModule) {
        return new FragmentModule_ProvidesAppcPromotionNotificationStringProviderFactory(fragmentModule);
    }

    public static AppcPromotionNotificationStringProvider providesAppcPromotionNotificationStringProvider(FragmentModule fragmentModule) {
        return (AppcPromotionNotificationStringProvider) f.b.b.c(fragmentModule.providesAppcPromotionNotificationStringProvider());
    }

    @Override // javax.inject.Provider
    public AppcPromotionNotificationStringProvider get() {
        return providesAppcPromotionNotificationStringProvider(this.module);
    }
}
