package e.g.a.c;

import android.view.View;

/* JADX INFO: compiled from: ViewEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T extends View> {
    private final T a;

    protected c(T t) {
        this.a = (T) e.g.a.a.b.a(t, "view == null");
    }

    public T a() {
        return this.a;
    }
}
