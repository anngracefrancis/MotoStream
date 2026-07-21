package e.e.b.c.a0;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: AdjustedCornerSize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements c {
    private final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f20888b;

    public b(float f2, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).a;
            f2 += ((b) cVar).f20888b;
        }
        this.a = cVar;
        this.f20888b = f2;
    }

    @Override // e.e.b.c.a0.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.f20888b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.f20888b == bVar.f20888b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.f20888b)});
    }
}
