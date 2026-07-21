package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;

/* JADX INFO: loaded from: classes.dex */
class FragmentStateAdapter$5 implements i {
    final /* synthetic */ Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f2263b;

    @Override // androidx.lifecycle.i
    public void a(k kVar, g.b bVar) {
        if (bVar == g.b.ON_DESTROY) {
            this.a.removeCallbacks(this.f2263b);
            kVar.getLifecycle().c(this);
        }
    }
}
