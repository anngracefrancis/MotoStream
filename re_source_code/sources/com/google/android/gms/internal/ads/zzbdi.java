package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(14)
public final class zzbdi implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g8 f14383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f14387f = 1.0f;

    public zzbdi(Context context, g8 g8Var) {
        this.a = (AudioManager) context.getSystemService("audio");
        this.f14383b = g8Var;
    }

    private final void f() {
        boolean z;
        boolean z2;
        boolean z3 = this.f14385d && !this.f14386e && this.f14387f > 0.0f;
        if (z3 && !(z2 = this.f14384c)) {
            AudioManager audioManager = this.a;
            if (audioManager != null && !z2) {
                this.f14384c = audioManager.requestAudioFocus(this, 3, 2) == 1;
            }
            this.f14383b.b();
            return;
        }
        if (z3 || !(z = this.f14384c)) {
            return;
        }
        AudioManager audioManager2 = this.a;
        if (audioManager2 != null && z) {
            this.f14384c = audioManager2.abandonAudioFocus(this) == 0;
        }
        this.f14383b.b();
    }

    public final float a() {
        float f2 = this.f14386e ? 0.0f : this.f14387f;
        if (this.f14384c) {
            return f2;
        }
        return 0.0f;
    }

    public final void b(boolean z) {
        this.f14386e = z;
        f();
    }

    public final void c(float f2) {
        this.f14387f = f2;
        f();
    }

    public final void d() {
        this.f14385d = true;
        f();
    }

    public final void e() {
        this.f14385d = false;
        f();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i2) {
        this.f14384c = i2 > 0;
        this.f14383b.b();
    }
}
