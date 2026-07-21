package androidx.work.impl.m.e;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.n.p;
import androidx.work.n;
import androidx.work.o;

/* JADX INFO: compiled from: NetworkNotRoamingController.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends c<androidx.work.impl.m.b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f2490e = n.f("NetworkNotRoamingCtrlr");

    public f(Context context, androidx.work.impl.utils.p.a aVar) {
        super(androidx.work.impl.m.f.g.c(context, aVar).d());
    }

    @Override // androidx.work.impl.m.e.c
    boolean b(p pVar) {
        return pVar.l.b() == o.NOT_ROAMING;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.m.e.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(androidx.work.impl.m.b bVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            return (bVar.a() && bVar.c()) ? false : true;
        }
        n.c().a(f2490e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
        return !bVar.a();
    }
}
