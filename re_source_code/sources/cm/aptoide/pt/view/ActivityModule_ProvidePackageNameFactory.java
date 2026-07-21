package cm.aptoide.pt.view;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidePackageNameFactory implements Provider {
    private final ActivityModule module;

    public ActivityModule_ProvidePackageNameFactory(ActivityModule activityModule) {
        this.module = activityModule;
    }

    public static ActivityModule_ProvidePackageNameFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvidePackageNameFactory(activityModule);
    }

    public static String providePackageName(ActivityModule activityModule) {
        return (String) f.b.b.c(activityModule.providePackageName());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providePackageName(this.module);
    }
}
