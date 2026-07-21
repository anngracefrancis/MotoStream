package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import c.c.a;

/* JADX INFO: loaded from: classes.dex */
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f677g;

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f676f = getResources().getDimensionPixelOffset(a.f2864b);
        this.f677g = getResources().getDimensionPixelOffset(a.a);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f676f * 2), this.f677g), 1073741824), i3);
    }
}
