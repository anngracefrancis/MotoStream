package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzawu implements zzut {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzaxb f14237b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    private final zzawr f14239d;
    private final Object a = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private final HashSet<zzawj> f14240e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    private final HashSet<Object> f14241f = new HashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzawt f14238c = new zzawt();

    public zzawu(String str, zzaxb zzaxbVar) {
        this.f14239d = new zzawr(str, zzaxbVar);
        this.f14237b = zzaxbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final void a(boolean z) {
        long jA = zzk.zzln().a();
        if (!z) {
            this.f14237b.h(jA);
            this.f14237b.v(this.f14239d.f14229d);
            return;
        }
        if (jA - this.f14237b.m() > ((Long) zzyt.e().c(zzacu.f1)).longValue()) {
            this.f14239d.f14229d = -1;
        } else {
            this.f14239d.f14229d = this.f14237b.i();
        }
    }

    public final Bundle b(Context context, zzaws zzawsVar) {
        HashSet<zzawj> hashSet = new HashSet<>();
        synchronized (this.a) {
            hashSet.addAll(this.f14240e);
            this.f14240e.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.f14239d.c(context, this.f14238c.b()));
        Bundle bundle2 = new Bundle();
        Iterator<Object> it = this.f14241f.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
        bundle.putBundle("slots", bundle2);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<zzawj> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().a());
        }
        bundle.putParcelableArrayList("ads", arrayList);
        zzawsVar.a(hashSet);
        return bundle;
    }

    public final zzawj c(Clock clock, String str) {
        return new zzawj(clock, this, this.f14238c.a(), str);
    }

    public final void d(zzxz zzxzVar, long j2) {
        synchronized (this.a) {
            this.f14239d.a(zzxzVar, j2);
        }
    }

    public final void e(zzawj zzawjVar) {
        synchronized (this.a) {
            this.f14240e.add(zzawjVar);
        }
    }

    public final void f(HashSet<zzawj> hashSet) {
        synchronized (this.a) {
            this.f14240e.addAll(hashSet);
        }
    }

    public final void g() {
        synchronized (this.a) {
            this.f14239d.d();
        }
    }

    public final void h() {
        synchronized (this.a) {
            this.f14239d.e();
        }
    }
}
