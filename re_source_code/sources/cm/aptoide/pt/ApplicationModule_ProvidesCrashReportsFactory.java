package cm.aptoide.pt;

import cm.aptoide.pt.crashreports.CrashReport;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesCrashReportsFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesCrashReportsFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesCrashReportsFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesCrashReportsFactory(applicationModule);
    }

    public static CrashReport providesCrashReports(ApplicationModule applicationModule) {
        return (CrashReport) f.b.b.c(applicationModule.providesCrashReports());
    }

    @Override // javax.inject.Provider
    public CrashReport get() {
        return providesCrashReports(this.module);
    }
}
