package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: ConstraintHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends View {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int[] f740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected Context f742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected c.g.b.k.h f743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f744j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected String f745k;
    protected String l;
    private View[] m;
    private HashMap<Integer, String> n;

    public b(Context context) {
        super(context);
        this.f740f = new int[32];
        this.f744j = false;
        this.m = null;
        this.n = new HashMap<>();
        this.f742h = context;
        h(null);
    }

    private void a(String str) {
        if (str == null || str.length() == 0 || this.f742h == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iG = g(strTrim);
        if (iG != 0) {
            this.n.put(Integer.valueOf(iG), strTrim);
            b(iG);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    private void b(int i2) {
        if (i2 == getId()) {
            return;
        }
        int i3 = this.f741g + 1;
        int[] iArr = this.f740f;
        if (i3 > iArr.length) {
            this.f740f = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f740f;
        int i4 = this.f741g;
        iArr2[i4] = i2;
        this.f741g = i4 + 1;
    }

    private void c(String str) {
        if (str == null || str.length() == 0 || this.f742h == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && strTrim.equals(((ConstraintLayout.b) layoutParams).V)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    private int f(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f742h.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            if (childAt.getId() != -1) {
                String resourceEntryName = null;
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int g(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iF = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object objF = constraintLayout.f(0, str);
            if (objF instanceof Integer) {
                iF = ((Integer) objF).intValue();
            }
        }
        if (iF == 0 && constraintLayout != null) {
            iF = f(constraintLayout, str);
        }
        if (iF == 0) {
            try {
                iF = h.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iF == 0 ? this.f742h.getResources().getIdentifier(str, DeepLinkIntentReceiver.DeepLinksKeys.ID, this.f742h.getPackageName()) : iF;
    }

    protected void d() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        e((ConstraintLayout) parent);
    }

    protected void e(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i2 = 0; i2 < this.f741g; i2++) {
            View viewH = constraintLayout.h(this.f740f[i2]);
            if (viewH != null) {
                viewH.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    viewH.setTranslationZ(viewH.getTranslationZ() + elevation);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f740f, this.f741g);
    }

    protected void h(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.a1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == i.m1) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f745k = string;
                    setIds(string);
                } else if (index == i.n1) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.l = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void i(c.g.b.k.e eVar, boolean z) {
    }

    public void j(ConstraintLayout constraintLayout) {
    }

    public void k(ConstraintLayout constraintLayout) {
    }

    public void l(ConstraintLayout constraintLayout) {
    }

    public void m(ConstraintLayout constraintLayout) {
        String str;
        int iF;
        if (isInEditMode()) {
            setIds(this.f745k);
        }
        c.g.b.k.h hVar = this.f743i;
        if (hVar == null) {
            return;
        }
        hVar.b();
        for (int i2 = 0; i2 < this.f741g; i2++) {
            int i3 = this.f740f[i2];
            View viewH = constraintLayout.h(i3);
            if (viewH == null && (iF = f(constraintLayout, (str = this.n.get(Integer.valueOf(i3))))) != 0) {
                this.f740f[i2] = iF;
                this.n.put(Integer.valueOf(iF), str);
                viewH = constraintLayout.h(iF);
            }
            if (viewH != null) {
                this.f743i.a(constraintLayout.i(viewH));
            }
        }
        this.f743i.c(constraintLayout.f707h);
    }

    public void n() {
        if (this.f743i == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).n0 = (c.g.b.k.e) this.f743i;
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f745k;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.l;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f744j) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    protected void setIds(String str) {
        this.f745k = str;
        if (str == null) {
            return;
        }
        int i2 = 0;
        this.f741g = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i2);
            if (iIndexOf == -1) {
                a(str.substring(i2));
                return;
            } else {
                a(str.substring(i2, iIndexOf));
                i2 = iIndexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.l = str;
        if (str == null) {
            return;
        }
        int i2 = 0;
        this.f741g = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i2);
            if (iIndexOf == -1) {
                c(str.substring(i2));
                return;
            } else {
                c(str.substring(i2, iIndexOf));
                i2 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f745k = null;
        this.f741g = 0;
        for (int i2 : iArr) {
            b(i2);
        }
    }

    @Override // android.view.View
    public void setTag(int i2, Object obj) {
        super.setTag(i2, obj);
        if (obj == null && this.f745k == null) {
            b(i2);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f740f = new int[32];
        this.f744j = false;
        this.m = null;
        this.n = new HashMap<>();
        this.f742h = context;
        h(attributeSet);
    }
}
