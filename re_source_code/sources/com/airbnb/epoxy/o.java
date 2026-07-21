package com.airbnb.epoxy;

import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: EpoxyControllerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class o extends d implements c.e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final androidx.recyclerview.widget.f.d<s<?>> f8446k = new a();
    private final e0 l;
    private final c m;
    private final n n;
    private int o;
    private final List<g0> p;

    /* JADX INFO: compiled from: EpoxyControllerAdapter.java */
    static class a extends androidx.recyclerview.widget.f.d<s<?>> {
        a() {
        }

        @Override // androidx.recyclerview.widget.f.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(s<?> sVar, s<?> sVar2) {
            return sVar.equals(sVar2);
        }

        @Override // androidx.recyclerview.widget.f.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(s<?> sVar, s<?> sVar2) {
            return sVar.id() == sVar2.id();
        }

        @Override // androidx.recyclerview.widget.f.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object c(s<?> sVar, s<?> sVar2) {
            return new j(sVar);
        }
    }

    o(n nVar, Handler handler) {
        e0 e0Var = new e0();
        this.l = e0Var;
        this.p = new ArrayList();
        this.n = nVar;
        this.m = new c(handler, this, f8446k);
        registerAdapterDataObserver(e0Var);
    }

    public void C(g0 g0Var) {
        this.p.add(g0Var);
    }

    public List<s<?>> D() {
        return j();
    }

    public int E(s<?> sVar) {
        int size = j().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (j().get(i2).id() == sVar.id()) {
                return i2;
            }
        }
        return -1;
    }

    public boolean F() {
        return this.m.g();
    }

    void G(int i2, int i3) {
        ArrayList arrayList = new ArrayList(j());
        arrayList.add(i3, arrayList.remove(i2));
        this.l.a();
        notifyItemMoved(i2, i3);
        this.l.b();
        if (this.m.e(arrayList)) {
            this.n.requestModelBuild();
        }
    }

    public void H(g0 g0Var) {
        this.p.remove(g0Var);
    }

    void I(h hVar) {
        List<? extends s<?>> listJ = j();
        if (!listJ.isEmpty()) {
            if (listJ.get(0).isDebugValidationEnabled()) {
                for (int i2 = 0; i2 < listJ.size(); i2++) {
                    listJ.get(i2).validateStateHasNotChangedSinceAdded("The model was changed between being bound and when models were rebuilt", i2);
                }
            }
        }
        this.m.i(hVar);
    }

    @Override // com.airbnb.epoxy.c.e
    public void d(k kVar) {
        this.o = kVar.f8437b.size();
        this.l.a();
        kVar.d(this);
        this.l.b();
        for (int size = this.p.size() - 1; size >= 0; size--) {
            this.p.get(size).a(kVar);
        }
    }

    @Override // com.airbnb.epoxy.d, androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.o;
    }

    @Override // com.airbnb.epoxy.d
    boolean h() {
        return true;
    }

    @Override // com.airbnb.epoxy.d
    public e i() {
        return super.i();
    }

    @Override // com.airbnb.epoxy.d
    List<? extends s<?>> j() {
        return this.m.f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.n.onAttachedToRecyclerViewInternal(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.n.onDetachedFromRecyclerViewInternal(recyclerView);
    }

    @Override // com.airbnb.epoxy.d
    protected void r(RuntimeException runtimeException) {
        this.n.onExceptionSwallowed(runtimeException);
    }

    @Override // com.airbnb.epoxy.d
    protected void u(u uVar, s<?> sVar, int i2, s<?> sVar2) {
        this.n.onModelBound(uVar, sVar, i2, sVar2);
    }

    @Override // com.airbnb.epoxy.d
    protected void w(u uVar, s<?> sVar) {
        this.n.onModelUnbound(uVar, sVar);
    }

    @Override // com.airbnb.epoxy.d, androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(u uVar) {
        super.onViewAttachedToWindow(uVar);
        this.n.onViewAttachedToWindow(uVar, uVar.c());
    }

    @Override // com.airbnb.epoxy.d, androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(u uVar) {
        super.onViewDetachedFromWindow(uVar);
        this.n.onViewDetachedFromWindow(uVar, uVar.c());
    }
}
