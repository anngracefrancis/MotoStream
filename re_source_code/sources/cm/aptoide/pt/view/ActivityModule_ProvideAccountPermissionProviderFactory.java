package cm.aptoide.pt.view;

import cm.aptoide.pt.permission.AccountPermissionProvider;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvideAccountPermissionProviderFactory implements Provider {
    private final ActivityModule module;

    public ActivityModule_ProvideAccountPermissionProviderFactory(ActivityModule activityModule) {
        this.module = activityModule;
    }

    public static ActivityModule_ProvideAccountPermissionProviderFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvideAccountPermissionProviderFactory(activityModule);
    }

    public static AccountPermissionProvider provideAccountPermissionProvider(ActivityModule activityModule) {
        return (AccountPermissionProvider) f.b.b.c(activityModule.provideAccountPermissionProvider());
    }

    @Override // javax.inject.Provider
    public AccountPermissionProvider get() {
        return provideAccountPermissionProvider(this.module);
    }
}
