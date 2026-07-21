package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f1085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f1086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f1087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f1088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Runnable f1089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f1090k;

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1085f = -1L;
        this.f1086g = false;
        this.f1087h = false;
        this.f1088i = false;
        this.f1089j = new Runnable() { // from class: androidx.core.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f1098f.b();
            }
        };
        this.f1090k = new Runnable() { // from class: androidx.core.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f1099f.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.f1086g = false;
        this.f1085f = -1L;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d() {
        this.f1087h = false;
        if (this.f1088i) {
            return;
        }
        this.f1085f = System.currentTimeMillis();
        setVisibility(0);
    }

    private void e() {
        removeCallbacks(this.f1089j);
        removeCallbacks(this.f1090k);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }
}
