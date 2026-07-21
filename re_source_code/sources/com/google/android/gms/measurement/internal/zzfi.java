package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfi {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ r3 f18125e;

    public zzfi(r3 r3Var, String str, boolean z) {
        this.f18125e = r3Var;
        Preconditions.g(str);
        this.a = str;
        this.f18122b = z;
    }

    public final void a(boolean z) {
        SharedPreferences.Editor editorEdit = this.f18125e.N().edit();
        editorEdit.putBoolean(this.a, z);
        editorEdit.apply();
        this.f18124d = z;
    }

    public final boolean b() {
        if (!this.f18123c) {
            this.f18123c = true;
            this.f18124d = this.f18125e.N().getBoolean(this.a, this.f18122b);
        }
        return this.f18124d;
    }
}
