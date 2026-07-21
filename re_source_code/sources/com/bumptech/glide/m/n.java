package com.bumptech.glide.m;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: RequestTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class n {
    private final Set<com.bumptech.glide.p.d> a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.p.d> f9467b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9468c;

    private boolean a(com.bumptech.glide.p.d dVar, boolean z) {
        boolean z2 = true;
        if (dVar == null) {
            return true;
        }
        boolean zRemove = this.a.remove(dVar);
        if (!this.f9467b.remove(dVar) && !zRemove) {
            z2 = false;
        }
        if (z2) {
            dVar.clear();
            if (z) {
                dVar.c();
            }
        }
        return z2;
    }

    public boolean b(com.bumptech.glide.p.d dVar) {
        return a(dVar, true);
    }

    public void c() {
        Iterator it = com.bumptech.glide.r.k.j(this.a).iterator();
        while (it.hasNext()) {
            a((com.bumptech.glide.p.d) it.next(), false);
        }
        this.f9467b.clear();
    }

    public void d() {
        this.f9468c = true;
        for (com.bumptech.glide.p.d dVar : com.bumptech.glide.r.k.j(this.a)) {
            if (dVar.isRunning()) {
                dVar.clear();
                this.f9467b.add(dVar);
            }
        }
    }

    public void e() {
        for (com.bumptech.glide.p.d dVar : com.bumptech.glide.r.k.j(this.a)) {
            if (!dVar.l() && !dVar.i()) {
                dVar.clear();
                if (this.f9468c) {
                    this.f9467b.add(dVar);
                } else {
                    dVar.d();
                }
            }
        }
    }

    public void f() {
        this.f9468c = false;
        for (com.bumptech.glide.p.d dVar : com.bumptech.glide.r.k.j(this.a)) {
            if (!dVar.l() && !dVar.isRunning()) {
                dVar.d();
            }
        }
        this.f9467b.clear();
    }

    public void g(com.bumptech.glide.p.d dVar) {
        this.a.add(dVar);
        if (!this.f9468c) {
            dVar.d();
            return;
        }
        dVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f9467b.add(dVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.f9468c + "}";
    }
}
