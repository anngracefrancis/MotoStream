package androidx.activity.d;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: ContextAwareHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final Set<b> a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Context f89b;

    public void a(b bVar) {
        if (this.f89b != null) {
            bVar.a(this.f89b);
        }
        this.a.add(bVar);
    }

    public void b() {
        this.f89b = null;
    }

    public void c(Context context) {
        this.f89b = context;
        Iterator<b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }

    public Context d() {
        return this.f89b;
    }

    public void e(b bVar) {
        this.a.remove(bVar);
    }
}
