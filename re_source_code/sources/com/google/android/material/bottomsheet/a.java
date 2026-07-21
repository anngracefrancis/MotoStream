package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u;
import cm.aptoide.pt.file.CacheHelper;
import e.e.b.c.f;
import e.e.b.c.k;

/* JADX INFO: compiled from: BottomSheetDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f18501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FrameLayout f18502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f18503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f18504k;
    private boolean l;
    private boolean m;
    private BottomSheetBehavior.e n;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class ViewOnClickListenerC0194a implements View.OnClickListener {
        ViewOnClickListenerC0194a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f18504k && aVar.isShowing() && a.this.g()) {
                a.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class b extends androidx.core.view.a {
        b() {
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.d0.c cVar) {
            super.g(view, cVar);
            if (!a.this.f18504k) {
                cVar.d0(false);
            } else {
                cVar.a(CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES);
                cVar.d0(true);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i2, Bundle bundle) {
            if (i2 == 1048576) {
                a aVar = a.this;
                if (aVar.f18504k) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.j(view, i2, bundle);
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class d extends BottomSheetBehavior.e {
        d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                a.this.cancel();
            }
        }
    }

    public a(Context context, int i2) {
        super(context, b(context, i2));
        this.f18504k = true;
        this.l = true;
        this.n = new d();
        d(1);
    }

    private static int b(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(e.e.b.c.b.f20966e, typedValue, true) ? typedValue.resourceId : k.f21033e;
    }

    private FrameLayout e() {
        if (this.f18502i == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), e.e.b.c.h.f21010b, null);
            this.f18502i = frameLayout;
            BottomSheetBehavior<FrameLayout> bottomSheetBehaviorT = BottomSheetBehavior.T((FrameLayout) frameLayout.findViewById(f.f21001d));
            this.f18501h = bottomSheetBehaviorT;
            bottomSheetBehaviorT.K(this.n);
            this.f18501h.g0(this.f18504k);
        }
        return this.f18502i;
    }

    private View h(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        e();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f18502i.findViewById(f.f21000c);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout) this.f18502i.findViewById(f.f21001d);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(f.J).setOnClickListener(new ViewOnClickListenerC0194a());
        u.i0(frameLayout, new b());
        frameLayout.setOnTouchListener(new c());
        return this.f18502i;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorF = f();
        if (!this.f18503j || bottomSheetBehaviorF.V() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorF.l0(5);
        }
    }

    public BottomSheetBehavior<FrameLayout> f() {
        if (this.f18501h == null) {
            e();
        }
        return this.f18501h;
    }

    boolean g() {
        if (!this.m) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.l = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.m = true;
        }
        return this.l;
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f18501h;
        if (bottomSheetBehavior == null || bottomSheetBehavior.V() != 5) {
            return;
        }
        this.f18501h.l0(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f18504k != z) {
            this.f18504k = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f18501h;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.g0(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f18504k) {
            this.f18504k = true;
        }
        this.l = z;
        this.m = true;
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void setContentView(int i2) {
        super.setContentView(h(i2, null, null));
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(h(0, view, null));
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(h(0, view, layoutParams));
    }
}
