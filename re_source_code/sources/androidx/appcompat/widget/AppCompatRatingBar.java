package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final o f394f;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.H);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap bitmapB = this.f394f.b();
        if (bitmapB != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapB.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        l0.a(this, getContext());
        o oVar = new o(this);
        this.f394f = oVar;
        oVar.c(attributeSet, i2);
    }
}
