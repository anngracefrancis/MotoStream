package e.e.b.c.a0;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: RelativeCornerSize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements c {
    private final float a;

    public i(float f2) {
        this.a = f2;
    }

    @Override // e.e.b.c.a0.c
    public float a(RectF rectF) {
        return this.a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.a == ((i) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
