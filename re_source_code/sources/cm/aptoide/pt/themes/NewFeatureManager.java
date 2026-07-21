package cm.aptoide.pt.themes;

import android.content.SharedPreferences;
import cm.aptoide.pt.notification.sync.LocalNotificationSync;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: NewFeatureManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcm/aptoide/pt/themes/NewFeatureManager;", HttpUrl.FRAGMENT_ENCODE_SET, "preferences", "Landroid/content/SharedPreferences;", "localNotificationSyncManager", "Lcm/aptoide/pt/notification/sync/LocalNotificationSyncManager;", "newFeature", "Lcm/aptoide/pt/themes/NewFeature;", "(Landroid/content/SharedPreferences;Lcm/aptoide/pt/notification/sync/LocalNotificationSyncManager;Lcm/aptoide/pt/themes/NewFeature;)V", "getLocalNotificationSyncManager", "()Lcm/aptoide/pt/notification/sync/LocalNotificationSyncManager;", "getNewFeature", "()Lcm/aptoide/pt/themes/NewFeature;", "getPreferences", "()Landroid/content/SharedPreferences;", "hasShownFeature", HttpUrl.FRAGMENT_ENCODE_SET, "scheduleNotification", HttpUrl.FRAGMENT_ENCODE_SET, "setFeatureAsShown", "unscheduleNotification", "Companion", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewFeatureManager {
    public static final String HAS_SHOWN_FEATURE = "12060_has_shown_new_feature_";
    private final LocalNotificationSyncManager localNotificationSyncManager;
    private final NewFeature newFeature;
    private final SharedPreferences preferences;

    public NewFeatureManager(SharedPreferences sharedPreferences, LocalNotificationSyncManager localNotificationSyncManager, NewFeature newFeature) {
        m.f(sharedPreferences, "preferences");
        m.f(localNotificationSyncManager, "localNotificationSyncManager");
        m.f(newFeature, "newFeature");
        this.preferences = sharedPreferences;
        this.localNotificationSyncManager = localNotificationSyncManager;
        this.newFeature = newFeature;
    }

    public final LocalNotificationSyncManager getLocalNotificationSyncManager() {
        return this.localNotificationSyncManager;
    }

    public final NewFeature getNewFeature() {
        return this.newFeature;
    }

    public final SharedPreferences getPreferences() {
        return this.preferences;
    }

    public final boolean hasShownFeature() {
        return this.preferences.getBoolean(HAS_SHOWN_FEATURE + this.newFeature.getId(), false);
    }

    public final void scheduleNotification() {
        this.localNotificationSyncManager.schedule(this.newFeature.getTitle(), this.newFeature.getDescription(), HttpUrl.FRAGMENT_ENCODE_SET, this.newFeature.getActionStringRes(), "aptoidefeature://id=" + this.newFeature.getId() + "&action=" + this.newFeature.getActionId(), LocalNotificationSync.NEW_FEATURE, 8, LocalNotificationSyncManager.TWO_MINUTES);
    }

    public final void setFeatureAsShown() {
        this.preferences.edit().putBoolean(HAS_SHOWN_FEATURE + this.newFeature.getId(), true).apply();
    }

    public final void unscheduleNotification() {
        this.localNotificationSyncManager.unschedule(LocalNotificationSync.NEW_FEATURE);
    }
}
