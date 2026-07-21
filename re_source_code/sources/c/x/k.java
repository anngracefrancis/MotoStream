package c.x;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: compiled from: RectEvaluator.java */
/* JADX INFO: loaded from: classes.dex */
class k implements TypeEvaluator<Rect> {
    private Rect a;

    k() {
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f2, Rect rect, Rect rect2) {
        int i2 = rect.left;
        int i3 = i2 + ((int) ((rect2.left - i2) * f2));
        int i4 = rect.top;
        int i5 = i4 + ((int) ((rect2.top - i4) * f2));
        int i6 = rect.right;
        int i7 = i6 + ((int) ((rect2.right - i6) * f2));
        int i8 = rect.bottom;
        int i9 = i8 + ((int) ((rect2.bottom - i8) * f2));
        Rect rect3 = this.a;
        if (rect3 == null) {
            return new Rect(i3, i5, i7, i9);
        }
        rect3.set(i3, i5, i7, i9);
        return this.a;
    }
}
