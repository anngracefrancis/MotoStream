package cm.aptoide.pt.install.installer;

import android.content.Context;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.notification.SystemNotificationShower;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RootInstallationRetryHandler {
    private static final String TAG = "RootInstallationRetryHandler";
    private Context context;
    private int count;
    private final e.g.b.c<List<Install>> handler;
    private final InstallManager installManager;
    private final int notificationId;
    private RootInstallErrorNotificationFactory rootInstallErrorNotificationFactory;
    private rx.k subscription;
    private final SystemNotificationShower systemNotificationShower;

    public RootInstallationRetryHandler(int i2, SystemNotificationShower systemNotificationShower, InstallManager installManager, e.g.b.c<List<Install>> cVar, int i3, Context context, RootInstallErrorNotificationFactory rootInstallErrorNotificationFactory) {
        this.notificationId = i2;
        this.systemNotificationShower = systemNotificationShower;
        this.installManager = installManager;
        this.handler = cVar;
        this.count = i3;
        this.context = context;
        this.rootInstallErrorNotificationFactory = rootInstallErrorNotificationFactory;
    }

    private void dismissNotifications() {
        this.systemNotificationShower.dismissNotification(this.notificationId);
        this.handler.call(Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$retries$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a() {
        this.count++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$retries$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.count--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$start$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(List list) {
        if (list.isEmpty()) {
            dismissNotifications();
        } else {
            showNotification(list);
        }
    }

    static /* synthetic */ void lambda$start$1(List list) {
    }

    private void showNotification(List<Install> list) {
        if (this.count == 0) {
            showSystemNotification(list);
        } else {
            this.handler.call(list);
        }
    }

    private void showSystemNotification(List<Install> list) {
        SystemNotificationShower systemNotificationShower = this.systemNotificationShower;
        Context context = this.context;
        systemNotificationShower.showNotification(context, this.rootInstallErrorNotificationFactory.create(context, list));
    }

    public rx.e<List<Install>> retries() {
        return this.handler.y(new rx.m.a() { // from class: cm.aptoide.pt.install.installer.r0
            @Override // rx.m.a
            public final void call() {
                this.f6504f.a();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.install.installer.s0
            @Override // rx.m.a
            public final void call() {
                this.f6506f.b();
            }
        });
    }

    public void start() {
        this.subscription = this.installManager.getTimedOutInstallations().j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.p0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6499f.c((List) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.install.installer.o0
            @Override // rx.m.b
            public final void call(Object obj) {
                RootInstallationRetryHandler.lambda$start$1((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.installer.q0
            @Override // rx.m.b
            public final void call(Object obj) {
                Logger.getInstance().e(RootInstallationRetryHandler.TAG, "start: " + ((Throwable) obj));
            }
        });
    }

    public void stop() {
        if (this.subscription.isUnsubscribed()) {
            return;
        }
        this.subscription.unsubscribe();
    }
}
