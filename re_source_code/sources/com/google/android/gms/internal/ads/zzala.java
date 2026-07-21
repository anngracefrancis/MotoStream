package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public final class zzala extends zzbbw<zzajw> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzayp<zzajw> f13947d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f13946c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13948e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13949f = 0;

    public zzala(zzayp<zzajw> zzaypVar) {
        this.f13947d = zzaypVar;
    }

    private final void j() {
        synchronized (this.f13946c) {
            Preconditions.n(this.f13949f >= 0);
            if (this.f13948e && this.f13949f == 0) {
                zzawz.m("No reference is left (including root). Cleaning up engine.");
                d(new a2(this), new zzbbu());
            } else {
                zzawz.m("There are still references to the engine. Not destroying.");
            }
        }
    }

    public final zzakw g() {
        zzakw zzakwVar = new zzakw(this);
        synchronized (this.f13946c) {
            d(new y1(this, zzakwVar), new z1(this, zzakwVar));
            Preconditions.n(this.f13949f >= 0);
            this.f13949f++;
        }
        return zzakwVar;
    }

    protected final void h() {
        synchronized (this.f13946c) {
            Preconditions.n(this.f13949f > 0);
            zzawz.m("Releasing 1 reference for JS Engine");
            this.f13949f--;
            j();
        }
    }

    public final void i() {
        synchronized (this.f13946c) {
            Preconditions.n(this.f13949f >= 0);
            zzawz.m("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.f13948e = true;
            j();
        }
    }
}
