package androidx.work.impl.m.e;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.n.p;
import androidx.work.o;

/* JADX INFO: compiled from: NetworkConnectedController.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends c<androidx.work.impl.m.b> {
    public d(Context context, androidx.work.impl.utils.p.a aVar) {
        super(androidx.work.impl.m.f.g.c(context, aVar).d());
    }

    @Override // androidx.work.impl.m.e.c
    boolean b(p pVar) {
        return pVar.l.b() == o.CONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.m.e.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(androidx.work.impl.m.b bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            return (bVar.a() && bVar.d()) ? false : true;
        }
        return !bVar.a();
    }
}
