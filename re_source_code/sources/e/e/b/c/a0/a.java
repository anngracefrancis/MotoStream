package e.e.b.c.a0;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: AbsoluteCornerSize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {
    private final float a;

    public a(float f2) {
        this.a = f2;
    }

    @Override // e.e.b.c.a0.c
    public float a(RectF rectF) {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.a == ((a) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
