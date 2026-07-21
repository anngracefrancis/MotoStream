package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: compiled from: FragmentViewLifecycleOwner.java */
/* JADX INFO: loaded from: classes.dex */
class y implements androidx.savedstate.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private androidx.lifecycle.l f1712f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private androidx.savedstate.b f1713g = null;

    y() {
    }

    void a(androidx.lifecycle.g.b bVar) {
        this.f1712f.h(bVar);
    }

    void b() {
        if (this.f1712f == null) {
            this.f1712f = new androidx.lifecycle.l(this);
            this.f1713g = androidx.savedstate.b.a(this);
        }
    }

    boolean c() {
        return this.f1712f != null;
    }

    void d(Bundle bundle) {
        this.f1713g.c(bundle);
    }

    void e(Bundle bundle) {
        this.f1713g.d(bundle);
    }

    void f(androidx.lifecycle.g.c cVar) {
        this.f1712f.o(cVar);
    }

    @Override // androidx.lifecycle.k
    public androidx.lifecycle.g getLifecycle() {
        b();
        return this.f1712f;
    }

    @Override // androidx.savedstate.c
    public SavedStateRegistry getSavedStateRegistry() {
        return this.f1713g.b();
    }
}
