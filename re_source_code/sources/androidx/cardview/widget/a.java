package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: compiled from: CardViewApi17Impl.java */
/* JADX INFO: loaded from: classes.dex */
class a extends c {

    /* JADX INFO: renamed from: androidx.cardview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CardViewApi17Impl.java */
    class C0013a implements g.a {
        C0013a() {
        }

        @Override // androidx.cardview.widget.g.a
        public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
            canvas.drawRoundRect(rectF, f2, f2, paint);
        }
    }

    a() {
    }

    @Override // androidx.cardview.widget.c, androidx.cardview.widget.e
    public void j() {
        g.f695b = new C0013a();
    }
}
