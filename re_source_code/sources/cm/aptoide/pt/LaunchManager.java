package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.preferences.secure.SecurePreferences;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: LaunchManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcm/aptoide/pt/LaunchManager;", HttpUrl.FRAGMENT_ENCODE_SET, "firstLaunchManager", "Lcm/aptoide/pt/FirstLaunchManager;", "updateLaunchManager", "Lcm/aptoide/pt/UpdateLaunchManager;", "secureSharedPreferences", "Landroid/content/SharedPreferences;", "(Lcm/aptoide/pt/FirstLaunchManager;Lcm/aptoide/pt/UpdateLaunchManager;Landroid/content/SharedPreferences;)V", "launch", "Lrx/Completable;", "runFirstLaunch", "runUpdateLaunch", "updateLaunchSettings", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LaunchManager {
    private final FirstLaunchManager firstLaunchManager;
    private final SharedPreferences secureSharedPreferences;
    private final UpdateLaunchManager updateLaunchManager;

    public LaunchManager(FirstLaunchManager firstLaunchManager, UpdateLaunchManager updateLaunchManager, SharedPreferences sharedPreferences) {
        kotlin.jvm.internal.m.f(firstLaunchManager, "firstLaunchManager");
        kotlin.jvm.internal.m.f(updateLaunchManager, "updateLaunchManager");
        kotlin.jvm.internal.m.f(sharedPreferences, "secureSharedPreferences");
        this.firstLaunchManager = firstLaunchManager;
        this.updateLaunchManager = updateLaunchManager;
        this.secureSharedPreferences = sharedPreferences;
    }

    private final rx.b runFirstLaunch() {
        if (SecurePreferences.isFirstRun(this.secureSharedPreferences)) {
            rx.b bVarG = this.firstLaunchManager.runFirstLaunch().G(updateLaunchSettings());
            kotlin.jvm.internal.m.e(bVarG, "firstLaunchManager.runFi…h(updateLaunchSettings())");
            return bVarG;
        }
        rx.b bVarE = rx.b.e();
        kotlin.jvm.internal.m.e(bVarE, "complete()");
        return bVarE;
    }

    private final rx.b runUpdateLaunch() {
        boolean zIsFirstRun = SecurePreferences.isFirstRun(this.secureSharedPreferences);
        int latestVersionCode = SecurePreferences.getLatestVersionCode(this.secureSharedPreferences);
        if (!zIsFirstRun && 12060 > latestVersionCode) {
            return this.updateLaunchManager.runUpdateLaunch(latestVersionCode, BuildConfig.VERSION_CODE);
        }
        rx.b bVarE = rx.b.e();
        kotlin.jvm.internal.m.e(bVarE, "complete()");
        return bVarE;
    }

    private final rx.b updateLaunchSettings() {
        rx.b bVarT = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.l0
            @Override // rx.m.a
            public final void call() {
                LaunchManager.m21updateLaunchSettings$lambda0(this.f6617f);
            }
        });
        kotlin.jvm.internal.m.e(bVarT, "fromAction {\n      Secur…eSharedPreferences)\n    }");
        return bVarT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateLaunchSettings$lambda-0, reason: not valid java name */
    public static final void m21updateLaunchSettings$lambda0(LaunchManager launchManager) {
        kotlin.jvm.internal.m.f(launchManager, "this$0");
        SecurePreferences.setFirstRun(false, launchManager.secureSharedPreferences);
        SecurePreferences.setCurrentVersionCode(BuildConfig.VERSION_CODE, launchManager.secureSharedPreferences);
    }

    public final rx.b launch() {
        rx.b bVarX = rx.b.x(runFirstLaunch(), runUpdateLaunch());
        kotlin.jvm.internal.m.e(bVarX, "mergeDelayError(runFirst…nch(), runUpdateLaunch())");
        return bVarX;
    }
}
