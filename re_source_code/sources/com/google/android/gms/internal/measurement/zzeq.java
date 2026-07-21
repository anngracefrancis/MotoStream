package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzeq {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile zzeq f17382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile zzeq f17383c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<a, zzfd.zzf<?, ?>> f17385e;
    private static final Class<?> a = d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzeq f17384d = new zzeq(true);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
    static final class a {
        private final Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f17386b;

        a(Object obj, int i2) {
            this.a = obj;
            this.f17386b = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f17386b == aVar.f17386b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f17386b;
        }
    }

    zzeq() {
        this.f17385e = new HashMap();
    }

    public static zzeq a() {
        zzeq zzeqVar = f17382b;
        if (zzeqVar == null) {
            synchronized (zzeq.class) {
                zzeqVar = f17382b;
                if (zzeqVar == null) {
                    zzeqVar = f17384d;
                    f17382b = zzeqVar;
                }
            }
        }
        return zzeqVar;
    }

    public static zzeq c() {
        zzeq zzeqVarB = f17383c;
        if (zzeqVarB == null) {
            synchronized (zzeq.class) {
                zzeqVarB = f17383c;
                if (zzeqVarB == null) {
                    zzeqVarB = k2.b(zzeq.class);
                    f17383c = zzeqVarB;
                }
            }
        }
        return zzeqVarB;
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final <ContainingType extends zzgo> zzfd.zzf<ContainingType, ?> b(ContainingType containingtype, int i2) {
        return (zzfd.zzf) this.f17385e.get(new a(containingtype, i2));
    }

    private zzeq(boolean z) {
        this.f17385e = Collections.emptyMap();
    }
}
