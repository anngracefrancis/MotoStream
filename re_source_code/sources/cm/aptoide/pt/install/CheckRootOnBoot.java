package cm.aptoide.pt.install;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.crashreports.CrashReport;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class CheckRootOnBoot extends BroadcastReceiver {
    private static final String HTC_BOOT_COMPLETED = "android.intent.action.QUICKBOOT_POWERON";
    private CrashReport crashReport;

    static /* synthetic */ void lambda$onReceive$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onReceive$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Throwable th) {
        this.crashReport.log(th);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.crashReport = CrashReport.getInstance();
        if (intent != null) {
            if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED") || intent.getAction().equals("android.intent.action.REBOOT") || intent.getAction().equals(HTC_BOOT_COMPLETED)) {
                ((AptoideApplication) context.getApplicationContext()).getRootAvailabilityManager().updateRootAvailability().K(Schedulers.computation()).I(new rx.m.a() { // from class: cm.aptoide.pt.install.p
                    @Override // rx.m.a
                    public final void call() {
                        CheckRootOnBoot.lambda$onReceive$0();
                    }
                }, new rx.m.b() { // from class: cm.aptoide.pt.install.q
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        this.f6568f.a((Throwable) obj);
                    }
                });
            }
        }
    }
}
