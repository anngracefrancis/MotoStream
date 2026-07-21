package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: AppCompatPopupWindow.java */
/* JADX INFO: loaded from: classes.dex */
class n extends PopupWindow {
    private static final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f588b;

    static {
        a = Build.VERSION.SDK_INT < 21;
    }

    public n(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        q0 q0VarV = q0.v(context, attributeSet, c.a.j.b2, i2, i3);
        int i4 = c.a.j.d2;
        if (q0VarV.s(i4)) {
            b(q0VarV.a(i4, false));
        }
        setBackgroundDrawable(q0VarV.g(c.a.j.c2));
        q0VarV.w();
    }

    private void b(boolean z) {
        if (a) {
            this.f588b = z;
        } else {
            androidx.core.widget.j.a(this, z);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        if (a && this.f588b) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3, int i4, int i5) {
        if (a && this.f588b) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (a && this.f588b) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }
}
