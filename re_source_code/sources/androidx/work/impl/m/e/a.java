package androidx.work.impl.m.e;

import android.content.Context;
import androidx.work.impl.n.p;

/* JADX INFO: compiled from: BatteryChargingController.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends c<Boolean> {
    public a(Context context, androidx.work.impl.utils.p.a aVar) {
        super(androidx.work.impl.m.f.g.c(context, aVar).a());
    }

    @Override // androidx.work.impl.m.e.c
    boolean b(p pVar) {
        return pVar.l.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.m.e.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(Boolean bool) {
        return !bool.booleanValue();
    }
}
