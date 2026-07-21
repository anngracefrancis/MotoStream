package c.x;

import android.os.IBinder;

/* JADX INFO: compiled from: WindowIdApi14.java */
/* JADX INFO: loaded from: classes.dex */
class k0 implements m0 {
    private final IBinder a;

    k0(IBinder iBinder) {
        this.a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof k0) && ((k0) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
