package com.bumptech.glide.m;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: RequestManagerFragment.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class k extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.m.a f9455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m f9456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set<k> f9457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.i f9458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private k f9459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Fragment f9460k;

    /* JADX INFO: compiled from: RequestManagerFragment.java */
    private class a implements m {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }

    public k() {
        this(new com.bumptech.glide.m.a());
    }

    private void a(k kVar) {
        this.f9457h.add(kVar);
    }

    @TargetApi(17)
    private Fragment c() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f9460k;
    }

    private void f(Activity activity) {
        j();
        k kVarH = com.bumptech.glide.c.c(activity).k().h(activity);
        this.f9459j = kVarH;
        if (equals(kVarH)) {
            return;
        }
        this.f9459j.a(this);
    }

    private void g(k kVar) {
        this.f9457h.remove(kVar);
    }

    private void j() {
        k kVar = this.f9459j;
        if (kVar != null) {
            kVar.g(this);
            this.f9459j = null;
        }
    }

    com.bumptech.glide.m.a b() {
        return this.f9455f;
    }

    public com.bumptech.glide.i d() {
        return this.f9458i;
    }

    public m e() {
        return this.f9456g;
    }

    void h(Fragment fragment) {
        this.f9460k = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        f(fragment.getActivity());
    }

    public void i(com.bumptech.glide.i iVar) {
        this.f9458i = iVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            f(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f9455f.c();
        j();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        j();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f9455f.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f9455f.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + c() + "}";
    }

    @SuppressLint({"ValidFragment"})
    k(com.bumptech.glide.m.a aVar) {
        this.f9456g = new a();
        this.f9457h = new HashSet();
        this.f9455f = aVar;
    }
}
