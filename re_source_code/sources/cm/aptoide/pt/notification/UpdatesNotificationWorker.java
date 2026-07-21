package cm.aptoide.pt.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.aptoideinstall.AptoideInstallManager;
import cm.aptoide.pt.database.room.RoomUpdate;
import cm.aptoide.pt.home.apps.AppMapper;
import cm.aptoide.pt.home.apps.model.UpdateApp;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.updates.UpdateRepository;
import cm.aptoide.pt.utils.AptoideUtils;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: compiled from: UpdatesNotificationWorker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u001eH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcm/aptoide/pt/notification/UpdatesNotificationWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "updateRepository", "Lcm/aptoide/pt/updates/UpdateRepository;", "sharedPreferences", "Landroid/content/SharedPreferences;", "aptoideInstallManager", "Lcm/aptoide/pt/app/aptoideinstall/AptoideInstallManager;", "appMapper", "Lcm/aptoide/pt/home/apps/AppMapper;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcm/aptoide/pt/updates/UpdateRepository;Landroid/content/SharedPreferences;Lcm/aptoide/pt/app/aptoideinstall/AptoideInstallManager;Lcm/aptoide/pt/home/apps/AppMapper;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "getNotificationDefaultDesign", "Landroid/app/Notification;", "updates", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/pt/home/apps/model/UpdateApp;", "resultPendingIntent", "Landroid/app/PendingIntent;", "tickerText", HttpUrl.FRAGMENT_ENCODE_SET, "handleNotification", HttpUrl.FRAGMENT_ENCODE_SET, "shouldShowNotification", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdatesNotificationWorker extends Worker {
    private final AppMapper appMapper;
    private final AptoideInstallManager aptoideInstallManager;
    private final Context context;
    private final SharedPreferences sharedPreferences;
    private final UpdateRepository updateRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdatesNotificationWorker(Context context, WorkerParameters workerParameters, UpdateRepository updateRepository, SharedPreferences sharedPreferences, AptoideInstallManager aptoideInstallManager, AppMapper appMapper) {
        super(context, workerParameters);
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(workerParameters, "workerParameters");
        kotlin.jvm.internal.m.f(updateRepository, "updateRepository");
        kotlin.jvm.internal.m.f(sharedPreferences, "sharedPreferences");
        kotlin.jvm.internal.m.f(aptoideInstallManager, "aptoideInstallManager");
        kotlin.jvm.internal.m.f(appMapper, "appMapper");
        this.context = context;
        this.updateRepository = updateRepository;
        this.sharedPreferences = sharedPreferences;
        this.aptoideInstallManager = aptoideInstallManager;
        this.appMapper = appMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doWork$lambda-4, reason: not valid java name */
    public static final rx.e m285doWork$lambda4(final UpdatesNotificationWorker updatesNotificationWorker, List list) {
        kotlin.jvm.internal.m.f(updatesNotificationWorker, "this$0");
        return rx.e.N(list).M(new rx.m.e() { // from class: cm.aptoide.pt.notification.l2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return UpdatesNotificationWorker.m286doWork$lambda4$lambda1(this.f6745f, (RoomUpdate) obj);
            }
        }, false, 1).a1(new rx.m.f() { // from class: cm.aptoide.pt.notification.o2
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return UpdatesNotificationWorker.m288doWork$lambda4$lambda2((UpdateApp) obj, (UpdateApp) obj2);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.notification.n2
            @Override // rx.m.b
            public final void call(Object obj) {
                UpdatesNotificationWorker.m289doWork$lambda4$lambda3(this.f6760f, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doWork$lambda-4$lambda-1, reason: not valid java name */
    public static final Single m286doWork$lambda4$lambda1(final UpdatesNotificationWorker updatesNotificationWorker, final RoomUpdate roomUpdate) {
        kotlin.jvm.internal.m.f(updatesNotificationWorker, "this$0");
        AptoideInstallManager aptoideInstallManager = updatesNotificationWorker.aptoideInstallManager;
        String packageName = roomUpdate.getPackageName();
        kotlin.jvm.internal.m.e(packageName, "update.packageName");
        return aptoideInstallManager.isInstalledWithAptoide(packageName).n(new rx.m.e() { // from class: cm.aptoide.pt.notification.m2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return UpdatesNotificationWorker.m287doWork$lambda4$lambda1$lambda0(this.f6754f, roomUpdate, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doWork$lambda-4$lambda-1$lambda-0, reason: not valid java name */
    public static final UpdateApp m287doWork$lambda4$lambda1$lambda0(UpdatesNotificationWorker updatesNotificationWorker, RoomUpdate roomUpdate, Boolean bool) {
        kotlin.jvm.internal.m.f(updatesNotificationWorker, "this$0");
        AppMapper appMapper = updatesNotificationWorker.appMapper;
        kotlin.jvm.internal.m.e(bool, "isAptoideInstalled");
        return appMapper.mapUpdateToUpdateApp(roomUpdate, bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doWork$lambda-4$lambda-2, reason: not valid java name */
    public static final Integer m288doWork$lambda4$lambda2(UpdateApp updateApp, UpdateApp updateApp2) {
        if (!updateApp.isInstalledWithAptoide() || updateApp2.isInstalledWithAptoide()) {
            return (updateApp.isInstalledWithAptoide() || !updateApp2.isInstalledWithAptoide()) ? 0 : 1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doWork$lambda-4$lambda-3, reason: not valid java name */
    public static final void m289doWork$lambda4$lambda3(UpdatesNotificationWorker updatesNotificationWorker, List list) {
        kotlin.jvm.internal.m.f(updatesNotificationWorker, "this$0");
        kotlin.jvm.internal.m.e(list, "updates");
        updatesNotificationWorker.handleNotification(list);
    }

    private final Notification getNotificationDefaultDesign(List<UpdateApp> updates, PendingIntent resultPendingIntent, String tickerText) {
        String string = getApplicationContext().getString(R.string.app_name);
        kotlin.jvm.internal.m.e(string, "applicationContext.getString(R.string.app_name)");
        String formattedString = AptoideUtils.StringU.getFormattedString(R.string.new_updates, getApplicationContext().getResources(), Integer.valueOf(updates.size()));
        if (updates.size() == 1) {
            formattedString = AptoideUtils.StringU.getFormattedString(R.string.one_new_update, getApplicationContext().getResources(), Integer.valueOf(updates.size()));
        }
        androidx.core.app.i.e eVarG = new androidx.core.app.i.e(this.context, UpdatesNotificationManager.CHANNEL_ID).j(resultPendingIntent).t(false).y(R.drawable.ic_stat_aptoide_notification).l(string).k(formattedString).B(tickerText).g(true);
        kotlin.jvm.internal.m.e(eVarG, "Builder(context, Updates…     .setAutoCancel(true)");
        Notification notificationC = eVarG.c();
        kotlin.jvm.internal.m.e(notificationC, "builder.build()");
        return notificationC;
    }

    private final void handleNotification(List<UpdateApp> updates) {
        if (shouldShowNotification(updates.size())) {
            Intent intent = new Intent(getApplicationContext(), AptoideApplication.getActivityProvider().getMainActivityFragmentClass());
            intent.putExtra(DeepLinkIntentReceiver.DeepLinksTargets.NEW_UPDATES, true);
            PendingIntent activity = PendingIntent.getActivity(getApplicationContext(), 0, intent, 67108864);
            String formattedString = AptoideUtils.StringU.getFormattedString(R.string.has_updates, getApplicationContext().getResources(), getApplicationContext().getString(R.string.app_name));
            kotlin.jvm.internal.m.e(activity, "resultPendingIntent");
            kotlin.jvm.internal.m.e(formattedString, "tickerText");
            androidx.core.app.l.b(this.context).d(123, getNotificationDefaultDesign(updates, activity, formattedString));
            ManagerPreferences.setLastUpdates(updates.size(), this.sharedPreferences);
        }
    }

    private final boolean shouldShowNotification(int updates) {
        return ManagerPreferences.isUpdateNotificationEnable(this.sharedPreferences) && updates > 0 && updates != ManagerPreferences.getLastUpdates(this.sharedPreferences);
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a doWork() {
        this.updateRepository.sync(true, false, false).b(this.updateRepository.getAll(false)).E().G(new rx.m.e() { // from class: cm.aptoide.pt.notification.p2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return UpdatesNotificationWorker.m285doWork$lambda4(this.f6768f, (List) obj);
            }
        }).W0().b();
        ListenableWorker.a aVarC = ListenableWorker.a.c();
        kotlin.jvm.internal.m.e(aVarC, "success()");
        return aVarC;
    }
}
