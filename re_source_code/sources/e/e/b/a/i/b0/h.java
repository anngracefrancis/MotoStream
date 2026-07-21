package e.e.b.a.i.b0;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.p;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.y;
import e.e.b.a.i.b0.j.j0;

/* JADX INFO: compiled from: SchedulingModule.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    static y a(Context context, j0 j0Var, t tVar, e.e.b.a.i.c0.a aVar) {
        return Build.VERSION.SDK_INT >= 21 ? new s(context, j0Var, tVar) : new p(context, j0Var, aVar, tVar);
    }
}
