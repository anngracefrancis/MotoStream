package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/* JADX INFO: compiled from: Placeholder.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends View {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f801h;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f800g == null) {
            return;
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f800g.getLayoutParams();
        bVar2.n0.T0(0);
        c.g.b.k.e.b bVarY = bVar.n0.y();
        c.g.b.k.e.b bVar3 = c.g.b.k.e.b.FIXED;
        if (bVarY != bVar3) {
            bVar.n0.U0(bVar2.n0.R());
        }
        if (bVar.n0.O() != bVar3) {
            bVar.n0.v0(bVar2.n0.v());
        }
        bVar2.n0.T0(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f799f == -1 && !isInEditMode()) {
            setVisibility(this.f801h);
        }
        View viewFindViewById = constraintLayout.findViewById(this.f799f);
        this.f800g = viewFindViewById;
        if (viewFindViewById != null) {
            ((ConstraintLayout.b) viewFindViewById.getLayoutParams()).b0 = true;
            this.f800g.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f800g;
    }

    public int getEmptyVisibility() {
        return this.f801h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i2) {
        View viewFindViewById;
        if (this.f799f == i2) {
            return;
        }
        View view = this.f800g;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.b) this.f800g.getLayoutParams()).b0 = false;
            this.f800g = null;
        }
        this.f799f = i2;
        if (i2 == -1 || (viewFindViewById = ((View) getParent()).findViewById(i2)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i2) {
        this.f801h = i2;
    }
}
