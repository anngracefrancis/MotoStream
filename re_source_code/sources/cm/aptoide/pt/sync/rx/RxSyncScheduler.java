package cm.aptoide.pt.sync.rx;

import cm.aptoide.analytics.implementation.CrashLogger;
import cm.aptoide.pt.sync.Sync;
import cm.aptoide.pt.sync.SyncScheduler;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
import rx.k;

/* JADX INFO: loaded from: classes.dex */
public class RxSyncScheduler implements SyncScheduler {
    private final CrashLogger consoleLogger;
    private final Map<String, k> subscriptionStorage;

    public RxSyncScheduler(Map<String, k> map, CrashLogger crashLogger) {
        this.subscriptionStorage = map;
        this.consoleLogger = crashLogger;
    }

    private boolean isSyncScheduled(String str) {
        return this.subscriptionStorage.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$scheduleOneOffSync$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Sync sync) {
        this.subscriptionStorage.remove(sync.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$scheduleOneOffSync$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Throwable th) {
        this.consoleLogger.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$schedulePeriodicSync$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Throwable th) {
        this.consoleLogger.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$schedulePeriodicSync$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(Sync sync, Long l) {
        return sync.execute().n(new rx.m.b() { // from class: cm.aptoide.pt.sync.rx.a
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7779f.c((Throwable) obj);
            }
        }).A().M();
    }

    static /* synthetic */ void lambda$schedulePeriodicSync$4(Object obj) {
    }

    static /* synthetic */ void lambda$schedulePeriodicSync$5(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    private void scheduleOneOffSync(final Sync sync) {
        this.subscriptionStorage.put(sync.getId(), sync.execute().I(new rx.m.a() { // from class: cm.aptoide.pt.sync.rx.c
            @Override // rx.m.a
            public final void call() {
                this.f7781f.a(sync);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.sync.rx.b
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7780f.b((Throwable) obj);
            }
        }));
    }

    private void schedulePeriodicSync(final Sync sync) {
        if (isSyncScheduled(sync.getId())) {
            return;
        }
        this.subscriptionStorage.put(sync.getId(), rx.e.Q(sync.getTrigger(), sync.getInterval(), TimeUnit.MILLISECONDS).L0(new rx.m.e() { // from class: cm.aptoide.pt.sync.rx.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7785f.d(sync, (Long) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.sync.rx.d
            @Override // rx.m.b
            public final void call(Object obj) {
                RxSyncScheduler.lambda$schedulePeriodicSync$4(obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.sync.rx.e
            @Override // rx.m.b
            public final void call(Object obj) {
                RxSyncScheduler.lambda$schedulePeriodicSync$5((Throwable) obj);
                throw null;
            }
        }));
    }

    @Override // cm.aptoide.pt.sync.SyncScheduler
    public synchronized void cancel(String str) {
        k kVarRemove = this.subscriptionStorage.remove(str);
        if (kVarRemove != null) {
            kVarRemove.unsubscribe();
        }
    }

    @Override // cm.aptoide.pt.sync.SyncScheduler
    public synchronized void reschedule(Sync sync) {
        if (isSyncScheduled(sync.getId())) {
            cancel(sync.getId());
            schedule(sync);
        }
    }

    @Override // cm.aptoide.pt.sync.SyncScheduler
    public synchronized void schedule(Sync sync) {
        if (sync.isPeriodic()) {
            schedulePeriodicSync(sync);
        } else {
            scheduleOneOffSync(sync);
        }
    }
}
