package e.e.b.c.r;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: InsetDialogOnTouchListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Dialog f21071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f21073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f21074i;

    public a(Dialog dialog, Rect rect) {
        this.f21071f = dialog;
        this.f21072g = rect.left;
        this.f21073h = rect.top;
        this.f21074i = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f21072g + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        int top = this.f21073h + viewFindViewById.getTop();
        if (new RectF(left, top, width, viewFindViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i2 = this.f21074i;
            motionEventObtain.setLocation((-i2) - 1, (-i2) - 1);
        }
        view.performClick();
        return this.f21071f.onTouchEvent(motionEventObtain);
    }
}
