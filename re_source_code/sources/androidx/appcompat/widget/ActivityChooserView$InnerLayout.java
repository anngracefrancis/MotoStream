package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f386f = {R.attr.background};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q0 q0VarU = q0.u(context, attributeSet, f386f);
        setBackgroundDrawable(q0VarU.g(0));
        q0VarU.w();
    }
}
