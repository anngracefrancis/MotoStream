package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: compiled from: AppCompatSeekBar.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends SeekBar {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final q f597f;

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.J);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f597f.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f597f.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f597f.g(canvas);
    }

    public p(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        l0.a(this, getContext());
        q qVar = new q(this);
        this.f597f = qVar;
        qVar.c(attributeSet, i2);
    }
}
