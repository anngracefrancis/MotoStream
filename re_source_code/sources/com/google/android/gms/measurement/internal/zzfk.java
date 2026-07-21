package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfk {

    @VisibleForTesting
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f18132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ r3 f18133e;

    private zzfk(r3 r3Var, String str, long j2) {
        this.f18133e = r3Var;
        Preconditions.g(str);
        Preconditions.a(j2 > 0);
        this.a = String.valueOf(str).concat(":start");
        this.f18130b = String.valueOf(str).concat(":count");
        this.f18131c = String.valueOf(str).concat(":value");
        this.f18132d = j2;
    }

    private final void c() {
        this.f18133e.d();
        long jA = this.f18133e.j().a();
        SharedPreferences.Editor editorEdit = this.f18133e.N().edit();
        editorEdit.remove(this.f18130b);
        editorEdit.remove(this.f18131c);
        editorEdit.putLong(this.a, jA);
        editorEdit.apply();
    }

    private final long d() {
        return this.f18133e.N().getLong(this.a, 0L);
    }

    public final Pair<String, Long> a() {
        long jAbs;
        this.f18133e.d();
        this.f18133e.d();
        long jD = d();
        if (jD == 0) {
            c();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jD - this.f18133e.j().a());
        }
        long j2 = this.f18132d;
        if (jAbs < j2) {
            return null;
        }
        if (jAbs > (j2 << 1)) {
            c();
            return null;
        }
        String string = this.f18133e.N().getString(this.f18131c, null);
        long j3 = this.f18133e.N().getLong(this.f18130b, 0L);
        c();
        return (string == null || j3 <= 0) ? r3.f17919c : new Pair<>(string, Long.valueOf(j3));
    }

    public final void b(String str, long j2) {
        this.f18133e.d();
        if (d() == 0) {
            c();
        }
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        long j3 = this.f18133e.N().getLong(this.f18130b, 0L);
        if (j3 <= 0) {
            SharedPreferences.Editor editorEdit = this.f18133e.N().edit();
            editorEdit.putString(this.f18131c, str);
            editorEdit.putLong(this.f18130b, 1L);
            editorEdit.apply();
            return;
        }
        long j4 = j3 + 1;
        boolean z = (this.f18133e.l().z0().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j4;
        SharedPreferences.Editor editorEdit2 = this.f18133e.N().edit();
        if (z) {
            editorEdit2.putString(this.f18131c, str);
        }
        editorEdit2.putLong(this.f18130b, j4);
        editorEdit2.apply();
    }
}
