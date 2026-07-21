package c.x;

import android.view.ViewGroup;

/* JADX INFO: compiled from: Scene.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    private ViewGroup a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f3588b;

    public static l b(ViewGroup viewGroup) {
        return (l) viewGroup.getTag(j.f3573c);
    }

    static void c(ViewGroup viewGroup, l lVar) {
        viewGroup.setTag(j.f3573c, lVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.a) != this || (runnable = this.f3588b) == null) {
            return;
        }
        runnable.run();
    }
}
