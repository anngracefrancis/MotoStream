package c.c.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: CustomTabsServiceConnection.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements ServiceConnection {

    /* JADX INFO: compiled from: CustomTabsServiceConnection.java */
    class a extends b {
        a(b.b.a.b bVar, ComponentName componentName) {
            super(bVar, componentName);
        }
    }

    public abstract void a(ComponentName componentName, b bVar);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a(componentName, new a(b.b.a.b.a.H(iBinder), componentName));
    }
}
