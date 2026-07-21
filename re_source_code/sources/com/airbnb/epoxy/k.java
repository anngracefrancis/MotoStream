package com.airbnb.epoxy;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: DiffResult.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    final List<? extends s<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final List<? extends s<?>> f8437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final androidx.recyclerview.widget.f.c f8438c;

    private k(List<? extends s<?>> list, List<? extends s<?>> list2, androidx.recyclerview.widget.f.c cVar) {
        this.a = list;
        this.f8437b = list2;
        this.f8438c = cVar;
    }

    static k a(List<? extends s<?>> list) {
        return new k(list, Collections.EMPTY_LIST, null);
    }

    static k b(List<? extends s<?>> list, List<? extends s<?>> list2, androidx.recyclerview.widget.f.c cVar) {
        return new k(list, list2, cVar);
    }

    static k e(List<? extends s<?>> list) {
        return new k(Collections.EMPTY_LIST, list, null);
    }

    static k f(List<? extends s<?>> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        return new k(list, list, null);
    }

    public void c(androidx.recyclerview.widget.l lVar) {
        androidx.recyclerview.widget.f.c cVar = this.f8438c;
        if (cVar != null) {
            cVar.d(lVar);
            return;
        }
        if (this.f8437b.isEmpty() && !this.a.isEmpty()) {
            lVar.c(0, this.a.size());
        } else {
            if (this.f8437b.isEmpty() || !this.a.isEmpty()) {
                return;
            }
            lVar.b(0, this.f8437b.size());
        }
    }

    public void d(RecyclerView.g gVar) {
        c(new androidx.recyclerview.widget.b(gVar));
    }
}
