package cm.aptoide.pt.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastRegisterOnSubscribe implements rx.e.a<Intent> {
    private final String broadcastPermission;
    private final Context context;
    private final IntentFilter intentFilter;
    private final Handler schedulerHandler;

    public BroadcastRegisterOnSubscribe(Context context, IntentFilter intentFilter, String str, Handler handler) {
        this.context = context;
        this.intentFilter = intentFilter;
        this.broadcastPermission = str;
        this.schedulerHandler = handler;
    }

    @Override // rx.m.b
    public void call(final rx.j<? super Intent> jVar) {
        final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: cm.aptoide.pt.utils.BroadcastRegisterOnSubscribe.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onNext(intent);
            }
        };
        jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.utils.BroadcastRegisterOnSubscribe.2
            @Override // rx.m.a
            public void call() {
                BroadcastRegisterOnSubscribe.this.context.unregisterReceiver(broadcastReceiver);
            }
        }));
        this.context.registerReceiver(broadcastReceiver, this.intentFilter, this.broadcastPermission, this.schedulerHandler);
    }
}
