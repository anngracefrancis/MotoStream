package com.bumptech.glide.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SupportRequestManagerFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.m.a f9469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m f9470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set<o> f9471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private o f9472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.i f9473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Fragment f9474k;

    /* JADX INFO: compiled from: SupportRequestManagerFragment.java */
    private class a implements m {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        this(new com.bumptech.glide.m.a());
    }

    private void d(o oVar) {
        this.f9471h.add(oVar);
    }

    private Fragment f() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f9474k;
    }

    private void i(androidx.fragment.app.d dVar) {
        m();
        o oVarJ = com.bumptech.glide.c.c(dVar).k().j(dVar);
        this.f9472i = oVarJ;
        if (equals(oVarJ)) {
            return;
        }
        this.f9472i.d(this);
    }

    private void j(o oVar) {
        this.f9471h.remove(oVar);
    }

    private void m() {
        o oVar = this.f9472i;
        if (oVar != null) {
            oVar.j(this);
            this.f9472i = null;
        }
    }

    com.bumptech.glide.m.a e() {
        return this.f9469f;
    }

    public com.bumptech.glide.i g() {
        return this.f9473j;
    }

    public m h() {
        return this.f9470g;
    }

    void k(Fragment fragment) {
        this.f9474k = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        i(fragment.getActivity());
    }

    public void l(com.bumptech.glide.i iVar) {
        this.f9473j = iVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            i(getActivity());
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f9469f.c();
        m();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9474k = null;
        m();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f9469f.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f9469f.e();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + f() + "}";
    }

    @SuppressLint({"ValidFragment"})
    public o(com.bumptech.glide.m.a aVar) {
        this.f9470g = new a();
        this.f9471h = new HashSet();
        this.f9469f = aVar;
    }
}
