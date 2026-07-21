package com.airbnb.epoxy;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: compiled from: EpoxyViewHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class u extends RecyclerView.c0 {
    private s a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Object> f8475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private q f8476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ViewHolderState.ViewState f8477d;

    public u(View view, boolean z) {
        super(view);
        if (z) {
            ViewHolderState.ViewState viewState = new ViewHolderState.ViewState();
            this.f8477d = viewState;
            viewState.d(this.itemView);
        }
    }

    private void a() {
        if (this.a == null) {
            throw new IllegalStateException("This holder is not currently bound.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(s sVar, s<?> sVar2, List<Object> list, int i2) {
        this.f8475b = list;
        if (this.f8476c == null && (sVar instanceof t)) {
            q qVarCreateNewHolder = ((t) sVar).createNewHolder();
            this.f8476c = qVarCreateNewHolder;
            qVarCreateNewHolder.bindView(this.itemView);
        }
        boolean z = sVar instanceof v;
        if (z) {
            ((v) sVar).handlePreBind(this, d(), i2);
        }
        if (sVar2 != null) {
            sVar.bind(d(), sVar2);
        } else if (list.isEmpty()) {
            sVar.bind(d());
        } else {
            sVar.bind(d(), list);
        }
        if (z) {
            ((v) sVar).handlePostBind(d(), i2);
        }
        this.a = sVar;
    }

    public s<?> c() {
        a();
        return this.a;
    }

    Object d() {
        q qVar = this.f8476c;
        return qVar != null ? qVar : this.itemView;
    }

    void e() {
        ViewHolderState.ViewState viewState = this.f8477d;
        if (viewState != null) {
            viewState.b(this.itemView);
        }
    }

    public void f() {
        a();
        this.a.unbind(d());
        this.a = null;
        this.f8475b = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.c0
    public String toString() {
        return "EpoxyViewHolder{epoxyModel=" + this.a + ", view=" + this.itemView + ", super=" + super.toString() + '}';
    }
}
