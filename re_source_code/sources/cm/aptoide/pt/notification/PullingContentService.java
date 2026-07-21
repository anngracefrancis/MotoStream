package cm.aptoide.pt.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.BaseService;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.room.RoomUpdate;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.updates.UpdateRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class PullingContentService extends BaseService {
    public static final String BOOT_COMPLETED_ACTION = "BOOT_COMPLETED_ACTION";
    public static final String PUSH_NOTIFICATIONS_ACTION = "PUSH_NOTIFICATIONS_ACTION";
    public static final String UPDATES_ACTION = "UPDATES_ACTION";
    public static final long UPDATES_INTERVAL = 86400000;
    private AptoideApplication application;

    @Inject
    DownloadFactory downloadFactory;
    private InstallManager installManager;

    @Inject
    @Named
    String marketName;
    private SharedPreferences sharedPreferences;
    private rx.t.b subscriptions;

    @Inject
    UpdateRepository updateRepository;

    private rx.e<Boolean> autoUpdate(final List<RoomUpdate> list) {
        return rx.e.S(Boolean.valueOf(ManagerPreferences.isAutoUpdateEnable(this.sharedPreferences) && ManagerPreferences.allowRootInstallation(this.sharedPreferences))).G(new rx.m.e() { // from class: cm.aptoide.pt.notification.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6778f.c(list, (Boolean) obj);
            }
        });
    }

    private long getElapsedRealtimeTrigger(long j2) {
        return SystemClock.elapsedRealtime() + j2;
    }

    private boolean isAlarmUp(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) PullingContentService.class);
        intent.setAction(str);
        return PendingIntent.getService(context, 0, intent, 67108864) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$autoUpdate$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ArrayList a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.downloadFactory.create((RoomUpdate) it.next(), false, Collections.emptyList()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$autoUpdate$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(ArrayList arrayList) {
        return this.installManager.startInstalls(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$autoUpdate$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(List list, Boolean bool) {
        return bool.booleanValue() ? rx.e.S(list).j0(Schedulers.io()).X(new rx.m.e() { // from class: cm.aptoide.pt.notification.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6812f.a((List) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.notification.y0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6820f.b((ArrayList) obj);
            }
        }) : rx.e.S(Boolean.FALSE);
    }

    static /* synthetic */ rx.e lambda$setUpdatesAction$0(List list, Boolean bool) {
        return bool.booleanValue() ? rx.e.B() : rx.e.S(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setUpdatesAction$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(final List list) {
        return autoUpdate(list).G(new rx.m.e() { // from class: cm.aptoide.pt.notification.v0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return PullingContentService.lambda$setUpdatesAction$0(list, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setUpdatesAction$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean e(List list) {
        return Boolean.valueOf(ManagerPreferences.isUpdateNotificationEnable(this.sharedPreferences));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setUpdatesAction$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(int i2, List list) {
        stopSelf(i2);
    }

    static /* synthetic */ void lambda$setUpdatesAction$4(List list) {
    }

    static /* synthetic */ void lambda$setUpdatesAction$5(Throwable th) {
        th.printStackTrace();
        CrashReport.getInstance().log(th);
    }

    private void setUpdatesAction(final int i2) {
        this.subscriptions.a(this.updateRepository.getAll(false).E().j0(Schedulers.computation()).G(new rx.m.e() { // from class: cm.aptoide.pt.notification.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6789f.d((List) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.notification.z0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6826f.e((List) obj);
            }
        }).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.notification.x0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6816f.f(i2, (List) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.notification.t0
            @Override // rx.m.b
            public final void call(Object obj) {
                PullingContentService.lambda$setUpdatesAction$4((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.notification.s0
            @Override // rx.m.b
            public final void call(Object obj) {
                PullingContentService.lambda$setUpdatesAction$5((Throwable) obj);
            }
        }));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        getApplicationComponent().inject(this);
        AptoideApplication aptoideApplication = (AptoideApplication) getApplicationContext();
        this.application = aptoideApplication;
        this.sharedPreferences = aptoideApplication.getDefaultSharedPreferences();
        this.installManager = this.application.getInstallManager();
        this.subscriptions = new rx.t.b();
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        if (isAlarmUp(this, UPDATES_ACTION)) {
            return;
        }
        setAlarm(alarmManager, this, UPDATES_ACTION, UPDATES_INTERVAL);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.subscriptions.b();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        String action = intent == null ? null : intent.getAction();
        if (action == null) {
            return 2;
        }
        if (!action.equals(BOOT_COMPLETED_ACTION) && !action.equals(UPDATES_ACTION)) {
            return 2;
        }
        setUpdatesAction(i3);
        return 2;
    }

    public void setAlarm(AlarmManager alarmManager, Context context, String str, long j2) {
        Intent intent = new Intent(context, (Class<?>) PullingContentService.class);
        intent.setAction(str);
        alarmManager.setInexactRepeating(3, getElapsedRealtimeTrigger(j2), getElapsedRealtimeTrigger(j2), PendingIntent.getService(context, 0, intent, 67108864));
    }
}
