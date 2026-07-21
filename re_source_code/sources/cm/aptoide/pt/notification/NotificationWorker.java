package cm.aptoide.pt.notification;

import android.content.Context;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.sync.Sync;
import cm.aptoide.pt.sync.SyncScheduler;
import cm.aptoide.pt.sync.alarm.AlarmSyncScheduler;
import cm.aptoide.pt.sync.alarm.SyncStorage;
import kotlin.Metadata;

/* JADX INFO: compiled from: NotificationWorker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcm/aptoide/pt/notification/NotificationWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "scheduler", "Lcm/aptoide/pt/sync/SyncScheduler;", "storage", "Lcm/aptoide/pt/sync/alarm/SyncStorage;", "crashReport", "Lcm/aptoide/pt/crashreports/CrashReport;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcm/aptoide/pt/sync/SyncScheduler;Lcm/aptoide/pt/sync/alarm/SyncStorage;Lcm/aptoide/pt/crashreports/CrashReport;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NotificationWorker extends Worker {
    private final CrashReport crashReport;
    private final SyncScheduler scheduler;
    private final SyncStorage storage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationWorker(Context context, WorkerParameters workerParameters, SyncScheduler syncScheduler, SyncStorage syncStorage, CrashReport crashReport) {
        super(context, workerParameters);
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(workerParameters, "workerParameters");
        kotlin.jvm.internal.m.f(syncScheduler, "scheduler");
        kotlin.jvm.internal.m.f(syncStorage, "storage");
        kotlin.jvm.internal.m.f(crashReport, "crashReport");
        this.scheduler = syncScheduler;
        this.storage = syncStorage;
        this.crashReport = crashReport;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doWork$lambda-0, reason: not valid java name */
    public static final void m279doWork$lambda0(String str, boolean z, NotificationWorker notificationWorker, Sync sync) {
        kotlin.jvm.internal.m.f(notificationWorker, "this$0");
        kotlin.jvm.internal.m.f(sync, "$sync");
        Log.d("CampaignWorker", "Got notification from " + str);
        if (z) {
            notificationWorker.scheduler.reschedule(sync);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doWork$lambda-1, reason: not valid java name */
    public static final void m280doWork$lambda1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doWork$lambda-2, reason: not valid java name */
    public static final void m281doWork$lambda2(NotificationWorker notificationWorker, Throwable th) {
        kotlin.jvm.internal.m.f(notificationWorker, "this$0");
        notificationWorker.crashReport.log(th);
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a doWork() {
        if (kotlin.jvm.internal.m.a(AlarmSyncScheduler.ACTION_SYNC, getInputData().j("action"))) {
            final String strJ = getInputData().j("sync_id");
            final Sync sync = this.storage.get(strJ);
            kotlin.jvm.internal.m.e(sync, "storage.get(syncId)");
            final boolean zH = getInputData().h(AlarmSyncScheduler.EXTRA_RESCHEDULE, false);
            sync.execute().q(new rx.m.a() { // from class: cm.aptoide.pt.notification.z
                @Override // rx.m.a
                public final void call() {
                    NotificationWorker.m279doWork$lambda0(strJ, zH, this, sync);
                }
            }).I(new rx.m.a() { // from class: cm.aptoide.pt.notification.a0
                @Override // rx.m.a
                public final void call() {
                    NotificationWorker.m280doWork$lambda1();
                }
            }, new rx.m.b() { // from class: cm.aptoide.pt.notification.y
                @Override // rx.m.b
                public final void call(Object obj) {
                    NotificationWorker.m281doWork$lambda2(this.f6819f, (Throwable) obj);
                }
            });
        }
        ListenableWorker.a aVarC = ListenableWorker.a.c();
        kotlin.jvm.internal.m.e(aVarC, "success()");
        return aVarC;
    }
}
