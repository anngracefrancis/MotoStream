package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakReference<View> f467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LayoutInflater f468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f469j;

    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f465f == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflaterFrom = this.f468i;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(getContext());
        }
        View viewInflate = layoutInflaterFrom.inflate(this.f465f, viewGroup, false);
        int i2 = this.f466g;
        if (i2 != -1) {
            viewInflate.setId(i2);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f467h = new WeakReference<>(viewInflate);
        a aVar = this.f469j;
        if (aVar != null) {
            aVar.a(this, viewInflate);
        }
        return viewInflate;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f466g;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f468i;
    }

    public int getLayoutResource() {
        return this.f465f;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i2) {
        this.f466g = i2;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f468i = layoutInflater;
    }

    public void setLayoutResource(int i2) {
        this.f465f = i2;
    }

    public void setOnInflateListener(a aVar) {
        this.f469j = aVar;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        WeakReference<View> weakReference = this.f467h;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i2);
            return;
        }
        super.setVisibility(i2);
        if (i2 == 0 || i2 == 4) {
            a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f465f = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.V3, i2, 0);
        this.f466g = typedArrayObtainStyledAttributes.getResourceId(c.a.j.Y3, -1);
        this.f465f = typedArrayObtainStyledAttributes.getResourceId(c.a.j.X3, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(c.a.j.W3, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
