package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class zzbqy {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcxv f14705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f14707d;

    public static class zza {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private zzcxv f14708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bundle f14709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f14710d;

        public final zza b(zzcxv zzcxvVar) {
            this.f14708b = zzcxvVar;
            return this;
        }

        public final zzbqy c() {
            return new zzbqy(this);
        }

        public final zza e(Context context) {
            this.a = context;
            return this;
        }

        public final zza h(Bundle bundle) {
            this.f14709c = bundle;
            return this;
        }

        public final zza i(String str) {
            this.f14710d = str;
            return this;
        }
    }

    private zzbqy(zza zzaVar) {
        this.a = zzaVar.a;
        this.f14705b = zzaVar.f14708b;
        this.f14707d = zzaVar.f14709c;
        this.f14706c = zzaVar.f14710d;
    }

    final zza a() {
        return new zza().e(this.a).b(this.f14705b).i(this.f14706c).h(this.f14707d);
    }

    final zzcxv b() {
        return this.f14705b;
    }

    final Bundle c() {
        return this.f14707d;
    }

    final String d() {
        return this.f14706c;
    }

    final Context e(Context context) {
        return this.f14706c != null ? context : this.a;
    }
}
