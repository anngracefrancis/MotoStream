package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class Group extends b {
    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.b
    protected void h(AttributeSet attributeSet) {
        super.h(attributeSet);
        this.f744j = false;
    }

    @Override // androidx.constraintlayout.widget.b
    public void j(ConstraintLayout constraintLayout) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.n0.U0(0);
        bVar.n0.v0(0);
    }

    @Override // androidx.constraintlayout.widget.b, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        d();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        d();
    }
}
