package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a0.a f424f;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        a0.a aVar = this.f424f;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.a0
    public void setOnFitSystemWindowsListener(a0.a aVar) {
        this.f424f = aVar;
    }
}
