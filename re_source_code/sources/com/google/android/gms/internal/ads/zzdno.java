package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class zzdno {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile zzdno f16008b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<a, zzdob.zzd<?, ?>> f16010d;
    private static final Class<?> a = c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final zzdno f16009c = new zzdno(true);

    static final class a {
        private final Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f16011b;

        a(Object obj, int i2) {
            this.a = obj;
            this.f16011b = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f16011b == aVar.f16011b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f16011b;
        }
    }

    zzdno() {
        this.f16010d = new HashMap();
    }

    static zzdno b() {
        return dv.b(zzdno.class);
    }

    private static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzdno d() {
        return uu.b();
    }

    public static zzdno e() {
        zzdno zzdnoVarC = f16008b;
        if (zzdnoVarC == null) {
            synchronized (zzdno.class) {
                zzdnoVarC = f16008b;
                if (zzdnoVarC == null) {
                    zzdnoVarC = uu.c();
                    f16008b = zzdnoVarC;
                }
            }
        }
        return zzdnoVarC;
    }

    public final <ContainingType extends zzdpk> zzdob.zzd<ContainingType, ?> a(ContainingType containingtype, int i2) {
        return (zzdob.zzd) this.f16010d.get(new a(containingtype, i2));
    }

    private zzdno(boolean z) {
        this.f16010d = Collections.emptyMap();
    }
}
