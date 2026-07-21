package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f8479h = LottieAnimationView.class.getSimpleName();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h<d> f8480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final h<Throwable> f8481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final f f8482k;
    private String l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private Set<i> q;
    private l<d> r;
    private d s;

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f8483f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f8484g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float f8485h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f8486i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        String f8487j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f8488k;
        int l;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f8483f);
            parcel.writeFloat(this.f8485h);
            parcel.writeInt(this.f8486i ? 1 : 0);
            parcel.writeString(this.f8487j);
            parcel.writeInt(this.f8488k);
            parcel.writeInt(this.l);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f8483f = parcel.readString();
            this.f8485h = parcel.readFloat();
            this.f8486i = parcel.readInt() == 1;
            this.f8487j = parcel.readString();
            this.f8488k = parcel.readInt();
            this.l = parcel.readInt();
        }
    }

    class a implements h<d> {
        a() {
        }

        @Override // com.airbnb.lottie.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(d dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    }

    class b implements h<Throwable> {
        b() {
        }

        @Override // com.airbnb.lottie.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f8480i = new a();
        this.f8481j = new b();
        this.f8482k = new f();
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = new HashSet();
        i(null);
    }

    private void e() {
        l<d> lVar = this.r;
        if (lVar != null) {
            lVar.m(this.f8480i);
            this.r.l(this.f8481j);
        }
    }

    private void f() {
        this.s = null;
        this.f8482k.f();
    }

    private void h() {
        setLayerType(this.p && this.f8482k.B() ? 2 : 1, null);
    }

    private void i(AttributeSet attributeSet) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, n.w);
        if (!isInEditMode()) {
            int i2 = n.E;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i2);
            int i3 = n.A;
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i3);
            int i4 = n.I;
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(i4);
            if (zHasValue && zHasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                String string2 = typedArrayObtainStyledAttributes.getString(i3);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(i4)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (typedArrayObtainStyledAttributes.getBoolean(n.x, false)) {
            this.n = true;
            this.o = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(n.C, false)) {
            this.f8482k.Q(-1);
        }
        int i5 = n.G;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(i5, 1));
        }
        int i6 = n.F;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(i6, -1));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(n.B));
        setProgress(typedArrayObtainStyledAttributes.getFloat(n.D, 0.0f));
        g(typedArrayObtainStyledAttributes.getBoolean(n.z, false));
        int i7 = n.y;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            c(new com.airbnb.lottie.s.e("**"), j.x, new com.airbnb.lottie.w.c(new o(typedArrayObtainStyledAttributes.getColor(i7, 0))));
        }
        int i8 = n.H;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            this.f8482k.S(typedArrayObtainStyledAttributes.getFloat(i8, 1.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
        h();
    }

    private void p(Drawable drawable, boolean z) {
        if (z && drawable != this.f8482k) {
            m();
        }
        e();
        super.setImageDrawable(drawable);
    }

    private void setCompositionTask(l<d> lVar) {
        f();
        e();
        this.r = lVar.h(this.f8480i).g(this.f8481j);
    }

    public <T> void c(com.airbnb.lottie.s.e eVar, T t, com.airbnb.lottie.w.c<T> cVar) {
        this.f8482k.c(eVar, t, cVar);
    }

    public void d() {
        this.f8482k.e();
        h();
    }

    public void g(boolean z) {
        this.f8482k.g(z);
    }

    public d getComposition() {
        return this.s;
    }

    public long getDuration() {
        d dVar = this.s;
        if (dVar != null) {
            return (long) dVar.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f8482k.m();
    }

    public String getImageAssetsFolder() {
        return this.f8482k.p();
    }

    public float getMaxFrame() {
        return this.f8482k.q();
    }

    public float getMinFrame() {
        return this.f8482k.s();
    }

    public m getPerformanceTracker() {
        return this.f8482k.t();
    }

    public float getProgress() {
        return this.f8482k.u();
    }

    public int getRepeatCount() {
        return this.f8482k.v();
    }

    public int getRepeatMode() {
        return this.f8482k.w();
    }

    public float getScale() {
        return this.f8482k.x();
    }

    public float getSpeed() {
        return this.f8482k.y();
    }

    public boolean getUseHardwareAcceleration() {
        return this.p;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.f8482k;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean j() {
        return this.f8482k.B();
    }

    @Deprecated
    public void k(boolean z) {
        this.f8482k.Q(z ? -1 : 0);
    }

    public void l() {
        this.f8482k.C();
        h();
    }

    void m() {
        this.f8482k.D();
    }

    public void n(JsonReader jsonReader, String str) {
        setCompositionTask(e.h(jsonReader, str));
    }

    public void o(String str, String str2) {
        n(new JsonReader(new StringReader(str)), str2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.o && this.n) {
            l();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (j()) {
            d();
            this.n = true;
        }
        m();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f8483f;
        this.l = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.l);
        }
        int i2 = savedState.f8484g;
        this.m = i2;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(savedState.f8485h);
        if (savedState.f8486i) {
            l();
        }
        this.f8482k.J(savedState.f8487j);
        setRepeatMode(savedState.f8488k);
        setRepeatCount(savedState.l);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8483f = this.l;
        savedState.f8484g = this.m;
        savedState.f8485h = this.f8482k.u();
        savedState.f8486i = this.f8482k.B();
        savedState.f8487j = this.f8482k.p();
        savedState.f8488k = this.f8482k.w();
        savedState.l = this.f8482k.v();
        return savedState;
    }

    public void setAnimation(int i2) {
        this.m = i2;
        this.l = null;
        setCompositionTask(e.j(getContext(), i2));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        o(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(e.l(getContext(), str));
    }

    public void setComposition(d dVar) {
        if (c.a) {
            Log.v(f8479h, "Set Composition \n" + dVar);
        }
        this.f8482k.setCallback(this);
        this.s = dVar;
        boolean zF = this.f8482k.F(dVar);
        h();
        if (getDrawable() != this.f8482k || zF) {
            setImageDrawable(null);
            setImageDrawable(this.f8482k);
            requestLayout();
            Iterator<i> it = this.q.iterator();
            while (it.hasNext()) {
                it.next().a(dVar);
            }
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.a aVar) {
        this.f8482k.G(aVar);
    }

    public void setFrame(int i2) {
        this.f8482k.H(i2);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.b bVar) {
        this.f8482k.I(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f8482k.J(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m();
        e();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        p(drawable, true);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        m();
        e();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.f8482k.K(i2);
    }

    public void setMaxProgress(float f2) {
        this.f8482k.L(f2);
    }

    public void setMinFrame(int i2) {
        this.f8482k.M(i2);
    }

    public void setMinProgress(float f2) {
        this.f8482k.N(f2);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f8482k.O(z);
    }

    public void setProgress(float f2) {
        this.f8482k.P(f2);
    }

    public void setRepeatCount(int i2) {
        this.f8482k.Q(i2);
    }

    public void setRepeatMode(int i2) {
        this.f8482k.R(i2);
    }

    public void setScale(float f2) {
        this.f8482k.S(f2);
        if (getDrawable() == this.f8482k) {
            p(null, false);
            p(this.f8482k, false);
        }
    }

    public void setSpeed(float f2) {
        this.f8482k.T(f2);
    }

    public void setTextDelegate(p pVar) {
        this.f8482k.U(pVar);
    }

    public void setAnimation(String str) {
        this.l = str;
        this.m = 0;
        setCompositionTask(e.d(getContext(), str));
    }
}
