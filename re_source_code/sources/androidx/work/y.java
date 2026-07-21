package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: WorkManager.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AddedAbstractMethod"})
public abstract class y {
    protected y() {
    }

    public static y h(Context context) {
        return androidx.work.impl.j.p(context);
    }

    public static void i(Context context, b bVar) {
        androidx.work.impl.j.i(context, bVar);
    }

    public abstract q a(String str);

    public abstract q b(String str);

    public final q c(z zVar) {
        return d(Collections.singletonList(zVar));
    }

    public abstract q d(List<? extends z> list);

    public abstract q e(String str, f fVar, s sVar);

    public q f(String str, g gVar, p pVar) {
        return g(str, gVar, Collections.singletonList(pVar));
    }

    public abstract q g(String str, g gVar, List<p> list);
}
