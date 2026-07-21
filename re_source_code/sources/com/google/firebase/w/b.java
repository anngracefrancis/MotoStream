package com.google.firebase.w;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.components.p;
import com.google.firebase.components.r;
import com.google.firebase.components.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ComponentMonitor.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements s {
    static /* synthetic */ Object b(String str, n nVar, p pVar) {
        try {
            c.b(str);
            return nVar.f().a(pVar);
        } finally {
            c.a();
        }
    }

    @Override // com.google.firebase.components.s
    public List<n<?>> a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final n<?> nVarR : componentRegistrar.getComponents()) {
            final String strG = nVarR.g();
            if (strG != null) {
                nVarR = nVarR.r(new r() { // from class: com.google.firebase.w.a
                    @Override // com.google.firebase.components.r
                    public final Object a(p pVar) {
                        return b.b(strG, nVarR, pVar);
                    }
                });
            }
            arrayList.add(nVarR);
        }
        return arrayList;
    }
}
