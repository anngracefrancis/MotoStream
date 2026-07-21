package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* JADX INFO: compiled from: MenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public interface m {

    /* JADX INFO: compiled from: MenuPresenter.java */
    public interface a {
        void b(g gVar, boolean z);

        boolean c(g gVar);
    }

    void b(g gVar, boolean z);

    void c(boolean z);

    boolean d();

    boolean e(g gVar, i iVar);

    boolean f(g gVar, i iVar);

    void g(a aVar);

    int getId();

    void h(Context context, g gVar);

    void i(Parcelable parcelable);

    boolean k(r rVar);

    Parcelable l();
}
