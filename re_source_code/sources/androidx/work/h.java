package androidx.work;

import android.app.Notification;

/* JADX INFO: compiled from: ForegroundInfo.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Notification f2338c;

    public h(int i2, Notification notification, int i3) {
        this.a = i2;
        this.f2338c = notification;
        this.f2337b = i3;
    }

    public int a() {
        return this.f2337b;
    }

    public Notification b() {
        return this.f2338c;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.a == hVar.a && this.f2337b == hVar.f2337b) {
            return this.f2338c.equals(hVar.f2338c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.a * 31) + this.f2337b) * 31) + this.f2338c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.a + ", mForegroundServiceType=" + this.f2337b + ", mNotification=" + this.f2338c + '}';
    }
}
