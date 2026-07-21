package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideAccountTypeFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideAccountTypeFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideAccountTypeFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideAccountTypeFactory(applicationModule);
    }

    public static String provideAccountType(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.provideAccountType());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideAccountType(this.module);
    }
}
