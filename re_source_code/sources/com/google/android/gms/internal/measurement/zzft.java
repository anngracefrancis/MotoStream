package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzft {
    private static final zzeq a = zzeq.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzdu f17418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile zzgo f17419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile zzdu f17420d;

    private final zzgo c(zzgo zzgoVar) {
        if (this.f17419c == null) {
            synchronized (this) {
                if (this.f17419c == null) {
                    try {
                        this.f17419c = zzgoVar;
                        this.f17420d = zzdu.f17368f;
                    } catch (zzfo unused) {
                        this.f17419c = zzgoVar;
                        this.f17420d = zzdu.f17368f;
                    }
                }
            }
        }
        return this.f17419c;
    }

    public final zzgo a(zzgo zzgoVar) {
        zzgo zzgoVar2 = this.f17419c;
        this.f17418b = null;
        this.f17420d = null;
        this.f17419c = zzgoVar;
        return zzgoVar2;
    }

    public final int b() {
        if (this.f17420d != null) {
            return this.f17420d.f();
        }
        if (this.f17419c != null) {
            return this.f17419c.i();
        }
        return 0;
    }

    public final zzdu d() {
        if (this.f17420d != null) {
            return this.f17420d;
        }
        synchronized (this) {
            if (this.f17420d != null) {
                return this.f17420d;
            }
            if (this.f17419c == null) {
                this.f17420d = zzdu.f17368f;
            } else {
                this.f17420d = this.f17419c.h();
            }
            return this.f17420d;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzftVar = (zzft) obj;
        zzgo zzgoVar = this.f17419c;
        zzgo zzgoVar2 = zzftVar.f17419c;
        if (zzgoVar == null && zzgoVar2 == null) {
            return d().equals(zzftVar.d());
        }
        if (zzgoVar == null || zzgoVar2 == null) {
            return zzgoVar != null ? zzgoVar.equals(zzftVar.c(zzgoVar.d())) : c(zzgoVar2.d()).equals(zzgoVar2);
        }
        return zzgoVar.equals(zzgoVar2);
    }

    public int hashCode() {
        return 1;
    }
}
