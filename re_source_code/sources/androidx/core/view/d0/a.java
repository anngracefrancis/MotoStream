package androidx.core.view.d0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: AccessibilityClickableSpanCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f1029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f1030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f1031h;

    public a(int i2, c cVar, int i3) {
        this.f1029f = i2;
        this.f1030g = cVar;
        this.f1031h = i3;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1029f);
        this.f1030g.O(this.f1031h, bundle);
    }
}
