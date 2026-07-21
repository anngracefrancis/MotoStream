package cm.aptoide.pt.home;

import cm.aptoide.pt.database.room.RoomAppComingSoonRegistration;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AppComingSoonRegistrationManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcm/aptoide/pt/home/AppComingSoonRegistrationManager;", HttpUrl.FRAGMENT_ENCODE_SET, "appComingSoonRegistrationPersistence", "Lcm/aptoide/pt/home/AppComingSoonRegistrationPersistence;", "(Lcm/aptoide/pt/home/AppComingSoonRegistrationPersistence;)V", "cancelScheduledNotification", "Lrx/Completable;", "packageName", HttpUrl.FRAGMENT_ENCODE_SET, "isNotificationScheduled", "Lrx/Observable;", HttpUrl.FRAGMENT_ENCODE_SET, "registerUserNotification", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppComingSoonRegistrationManager {
    private final AppComingSoonRegistrationPersistence appComingSoonRegistrationPersistence;

    public AppComingSoonRegistrationManager(AppComingSoonRegistrationPersistence appComingSoonRegistrationPersistence) {
        kotlin.jvm.internal.m.f(appComingSoonRegistrationPersistence, "appComingSoonRegistrationPersistence");
        this.appComingSoonRegistrationPersistence = appComingSoonRegistrationPersistence;
    }

    public final rx.b cancelScheduledNotification(String str) {
        kotlin.jvm.internal.m.f(str, "packageName");
        rx.b bVarUnregisterForAppNotification = this.appComingSoonRegistrationPersistence.unregisterForAppNotification(new RoomAppComingSoonRegistration(str));
        kotlin.jvm.internal.m.e(bVarUnregisterForAppNotification, "appComingSoonRegistratio…egistration(packageName))");
        return bVarUnregisterForAppNotification;
    }

    public final rx.e<Boolean> isNotificationScheduled(String str) {
        kotlin.jvm.internal.m.f(str, "packageName");
        rx.e<Boolean> eVarIsRegisteredForApp = this.appComingSoonRegistrationPersistence.isRegisteredForApp(str);
        kotlin.jvm.internal.m.e(eVarIsRegisteredForApp, "appComingSoonRegistratio…steredForApp(packageName)");
        return eVarIsRegisteredForApp;
    }

    public final rx.b registerUserNotification(String str) {
        kotlin.jvm.internal.m.f(str, "packageName");
        rx.b bVarRegisterForAppNotification = this.appComingSoonRegistrationPersistence.registerForAppNotification(new RoomAppComingSoonRegistration(str));
        kotlin.jvm.internal.m.e(bVarRegisterForAppNotification, "appComingSoonRegistratio…egistration(packageName))");
        return bVarRegisterForAppNotification;
    }
}
