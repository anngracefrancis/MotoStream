package c.a.o;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.a0;
import androidx.core.view.y;
import androidx.core.view.z;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompatSet.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f2835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    z f2836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2837e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2834b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a0 f2838f = new a();
    final ArrayList<y> a = new ArrayList<>();

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompatSet.java */
    class a extends a0 {
        private boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2839b = 0;

        a() {
        }

        void a() {
            this.f2839b = 0;
            this.a = false;
            h.this.b();
        }

        @Override // androidx.core.view.a0, androidx.core.view.z
        public void onAnimationEnd(View view) {
            int i2 = this.f2839b + 1;
            this.f2839b = i2;
            if (i2 == h.this.a.size()) {
                z zVar = h.this.f2836d;
                if (zVar != null) {
                    zVar.onAnimationEnd(null);
                }
                a();
            }
        }

        @Override // androidx.core.view.a0, androidx.core.view.z
        public void onAnimationStart(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            z zVar = h.this.f2836d;
            if (zVar != null) {
                zVar.onAnimationStart(null);
            }
        }
    }

    public void a() {
        if (this.f2837e) {
            Iterator<y> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f2837e = false;
        }
    }

    void b() {
        this.f2837e = false;
    }

    public h c(y yVar) {
        if (!this.f2837e) {
            this.a.add(yVar);
        }
        return this;
    }

    public h d(y yVar, y yVar2) {
        this.a.add(yVar);
        yVar2.h(yVar.c());
        this.a.add(yVar2);
        return this;
    }

    public h e(long j2) {
        if (!this.f2837e) {
            this.f2834b = j2;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f2837e) {
            this.f2835c = interpolator;
        }
        return this;
    }

    public h g(z zVar) {
        if (!this.f2837e) {
            this.f2836d = zVar;
        }
        return this;
    }

    public void h() {
        if (this.f2837e) {
            return;
        }
        for (y yVar : this.a) {
            long j2 = this.f2834b;
            if (j2 >= 0) {
                yVar.d(j2);
            }
            Interpolator interpolator = this.f2835c;
            if (interpolator != null) {
                yVar.e(interpolator);
            }
            if (this.f2836d != null) {
                yVar.f(this.f2838f);
            }
            yVar.j();
        }
        this.f2837e = true;
    }
}
