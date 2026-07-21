package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzawj {
    private final Clock a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzawu f14200b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f14204f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f14202d = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f14205g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f14206h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14207i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f14208j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f14209k = 0;
    private long l = -1;
    private long m = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedList<u4> f14201c = new LinkedList<>();

    zzawj(Clock clock, zzawu zzawuVar, String str, String str2) {
        this.a = clock;
        this.f14200b = zzawuVar;
        this.f14203e = str;
        this.f14204f = str2;
    }

    public final Bundle a() {
        Bundle bundle;
        synchronized (this.f14202d) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.f14203e);
            bundle.putString("slotid", this.f14204f);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.l);
            bundle.putLong("tresponse", this.m);
            bundle.putLong("timp", this.f14206h);
            bundle.putLong("tload", this.f14208j);
            bundle.putLong("pcc", this.f14209k);
            bundle.putLong("tfetch", this.f14205g);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<u4> it = this.f14201c.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final void c(boolean z) {
        synchronized (this.f14202d) {
            if (this.m != -1) {
                this.f14208j = this.a.b();
            }
        }
    }

    public final void d(zzxz zzxzVar) {
        synchronized (this.f14202d) {
            long jB = this.a.b();
            this.l = jB;
            this.f14200b.d(zzxzVar, jB);
        }
    }

    public final void e(long j2) {
        synchronized (this.f14202d) {
            this.m = j2;
            if (j2 != -1) {
                this.f14200b.e(this);
            }
        }
    }

    public final void f() {
        synchronized (this.f14202d) {
            if (this.m != -1 && this.f14206h == -1) {
                this.f14206h = this.a.b();
                this.f14200b.e(this);
            }
            this.f14200b.g();
        }
    }

    public final void g() {
        synchronized (this.f14202d) {
            if (this.m != -1) {
                u4 u4Var = new u4(this);
                u4Var.d();
                this.f14201c.add(u4Var);
                this.f14209k++;
                this.f14200b.h();
                this.f14200b.e(this);
            }
        }
    }

    public final void h() {
        synchronized (this.f14202d) {
            if (this.m != -1 && !this.f14201c.isEmpty()) {
                u4 last = this.f14201c.getLast();
                if (last.b() == -1) {
                    last.c();
                    this.f14200b.e(this);
                }
            }
        }
    }

    public final String i() {
        return this.f14203e;
    }
}
