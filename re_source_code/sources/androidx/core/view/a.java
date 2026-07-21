package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: AccessibilityDelegateCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final View.AccessibilityDelegate a = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View.AccessibilityDelegate f1003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View.AccessibilityDelegate f1004c;

    /* JADX INFO: renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityDelegateCompat.java */
    static final class C0023a extends View.AccessibilityDelegate {
        final a a;

        C0023a(a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            androidx.core.view.d0.d dVarB = this.a.b(view);
            if (dVarB != null) {
                return (AccessibilityNodeProvider) dVarB.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            androidx.core.view.d0.c cVarY0 = androidx.core.view.d0.c.y0(accessibilityNodeInfo);
            cVarY0.q0(u.R(view));
            cVarY0.i0(u.M(view));
            cVarY0.m0(u.n(view));
            cVarY0.u0(u.F(view));
            this.a.g(view, cVarY0);
            cVarY0.e(accessibilityNodeInfo.getText(), view);
            List<androidx.core.view.d0.c.a> listC = a.c(view);
            for (int i2 = 0; i2 < listC.size(); i2++) {
                cVarY0.b(listC.get(i2));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.a.j(view, i2, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i2) {
            this.a.l(view, i2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.m(view, accessibilityEvent);
        }
    }

    public a() {
        this(a);
    }

    static List<androidx.core.view.d0.c.a> c(View view) {
        List<androidx.core.view.d0.c.a> list = (List) view.getTag(c.i.c.H);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrP = androidx.core.view.d0.c.p(view.createAccessibilityNodeInfo().getText());
            for (int i2 = 0; clickableSpanArrP != null && i2 < clickableSpanArrP.length; i2++) {
                if (clickableSpan.equals(clickableSpanArrP[i2])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i2, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(c.i.c.I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f1003b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public androidx.core.view.d0.d b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f1003b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new androidx.core.view.d0.d(accessibilityNodeProvider);
    }

    View.AccessibilityDelegate d() {
        return this.f1004c;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f1003b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, androidx.core.view.d0.c cVar) {
        this.f1003b.onInitializeAccessibilityNodeInfo(view, cVar.x0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f1003b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f1003b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i2, Bundle bundle) {
        List<androidx.core.view.d0.c.a> listC = c(view);
        boolean zPerformAccessibilityAction = false;
        for (int i3 = 0; i3 < listC.size(); i3++) {
            androidx.core.view.d0.c.a aVar = listC.get(i3);
            if (aVar.b() == i2) {
                zPerformAccessibilityAction = aVar.d(view, bundle);
                break;
            }
        }
        if (!zPerformAccessibilityAction && Build.VERSION.SDK_INT >= 16) {
            zPerformAccessibilityAction = this.f1003b.performAccessibilityAction(view, i2, bundle);
        }
        return (zPerformAccessibilityAction || i2 != c.i.c.a) ? zPerformAccessibilityAction : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i2) {
        this.f1003b.sendAccessibilityEvent(view, i2);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f1003b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f1003b = accessibilityDelegate;
        this.f1004c = new C0023a(this);
    }
}
