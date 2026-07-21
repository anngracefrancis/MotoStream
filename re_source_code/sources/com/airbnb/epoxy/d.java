package com.airbnb.epoxy;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BaseEpoxyAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d extends RecyclerView.g<u> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8424f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0 f8425g = new m0();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e f8426h = new e();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ViewHolderState f8427i = new ViewHolderState();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final GridLayoutManager.c f8428j;

    /* JADX INFO: compiled from: BaseEpoxyAdapter.java */
    class a extends GridLayoutManager.c {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i2) {
            try {
                return d.this.k(i2).spanSize(d.this.f8424f, i2, d.this.getItemCount());
            } catch (IndexOutOfBoundsException e2) {
                d.this.r(e2);
                return 1;
            }
        }
    }

    public d() {
        a aVar = new a();
        this.f8428j = aVar;
        setHasStableIds(true);
        aVar.setSpanIndexCacheEnabled(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(u uVar) {
        this.f8427i.q(uVar);
        this.f8426h.g(uVar);
        s<?> sVarC = uVar.c();
        uVar.f();
        w(uVar, sVarC);
    }

    public void B(int i2) {
        this.f8424f = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return j().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        return j().get(i2).id();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        return this.f8425g.c(k(i2));
    }

    boolean h() {
        return false;
    }

    protected e i() {
        return this.f8426h;
    }

    abstract List<? extends s<?>> j();

    s<?> k(int i2) {
        return j().get(i2);
    }

    public int l() {
        return this.f8424f;
    }

    public GridLayoutManager.c m() {
        return this.f8428j;
    }

    public boolean n() {
        return this.f8424f > 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(u uVar, int i2) {
        onBindViewHolder(uVar, i2, Collections.emptyList());
    }

    public void onSaveInstanceState(Bundle bundle) {
        Iterator<u> it = this.f8426h.iterator();
        while (it.hasNext()) {
            this.f8427i.q(it.next());
        }
        if (this.f8427i.n() > 0 && !hasStableIds()) {
            throw new IllegalStateException("Must have stable ids when saving view holder state");
        }
        bundle.putParcelable("saved_state_view_holders", this.f8427i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(u uVar, int i2, List<Object> list) {
        s<?> sVarK = k(i2);
        s<?> sVarA = h() ? j.a(list, getItemId(i2)) : null;
        uVar.b(sVarK, sVarA, list, i2);
        if (list.isEmpty()) {
            this.f8427i.p(uVar);
        }
        this.f8426h.f(uVar);
        if (h()) {
            u(uVar, sVarK, i2, sVarA);
        } else {
            v(uVar, sVarK, i2, list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public u onCreateViewHolder(ViewGroup viewGroup, int i2) {
        s<?> sVarA = this.f8425g.a(this, i2);
        return new u(sVarA.buildView(viewGroup), sVarA.shouldSaveViewState());
    }

    protected void r(RuntimeException runtimeException) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean onFailedToRecycleView(u uVar) {
        return uVar.c().onFailedToRecycleView(uVar.d());
    }

    protected void t(u uVar, s<?> sVar, int i2) {
    }

    void u(u uVar, s<?> sVar, int i2, s<?> sVar2) {
        t(uVar, sVar, i2);
    }

    protected void v(u uVar, s<?> sVar, int i2, List<Object> list) {
        t(uVar, sVar, i2);
    }

    protected void w(u uVar, s<?> sVar) {
    }

    public void x(Bundle bundle) {
        if (this.f8426h.size() > 0) {
            throw new IllegalStateException("State cannot be restored once views have been bound. It should be done before adding the adapter to the recycler view.");
        }
        if (bundle != null) {
            ViewHolderState viewHolderState = (ViewHolderState) bundle.getParcelable("saved_state_view_holders");
            this.f8427i = viewHolderState;
            if (viewHolderState == null) {
                throw new IllegalStateException("Tried to restore instance state, but onSaveInstanceState was never called.");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: y */
    public void onViewAttachedToWindow(u uVar) {
        uVar.c().onViewAttachedToWindow(uVar.d());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: z */
    public void onViewDetachedFromWindow(u uVar) {
        uVar.c().onViewDetachedFromWindow(uVar.d());
    }
}
