package androidx.work.impl.m.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.n;

/* JADX INFO: compiled from: BroadcastReceiverConstraintTracker.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> extends d<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f2493g = n.f("BrdcstRcvrCnstrntTrckr");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BroadcastReceiver f2494h;

    /* JADX INFO: compiled from: BroadcastReceiverConstraintTracker.java */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.h(context, intent);
            }
        }
    }

    public c(Context context, androidx.work.impl.utils.p.a aVar) {
        super(context, aVar);
        this.f2494h = new a();
    }

    @Override // androidx.work.impl.m.f.d
    public void e() {
        n.c().a(f2493g, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f2496c.registerReceiver(this.f2494h, g());
    }

    @Override // androidx.work.impl.m.f.d
    public void f() {
        n.c().a(f2493g, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f2496c.unregisterReceiver(this.f2494h);
    }

    public abstract IntentFilter g();

    public abstract void h(Context context, Intent intent);
}
