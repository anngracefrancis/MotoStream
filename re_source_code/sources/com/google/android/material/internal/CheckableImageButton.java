package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.core.view.u;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class CheckableImageButton extends androidx.appcompat.widget.k implements Checkable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f18678h = {R.attr.state_checked};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f18680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f18681k;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f18682h;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(Parcel parcel) {
            this.f18682h = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f18682h ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel);
        }
    }

    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.d0.c cVar) {
            super.g(view, cVar);
            cVar.W(CheckableImageButton.this.a());
            cVar.X(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.a.a.C);
    }

    public boolean a() {
        return this.f18680j;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f18679i;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        if (!this.f18679i) {
            return super.onCreateDrawableState(i2);
        }
        int[] iArr = f18678h;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i2 + iArr.length), iArr);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f18682h);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f18682h = this.f18679i;
        return savedState;
    }

    public void setCheckable(boolean z) {
        if (this.f18680j != z) {
            this.f18680j = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.f18680j || this.f18679i == z) {
            return;
        }
        this.f18679i = z;
        refreshDrawableState();
        sendAccessibilityEvent(RecyclerView.l.FLAG_MOVED);
    }

    public void setPressable(boolean z) {
        this.f18681k = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.f18681k) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f18679i);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18680j = true;
        this.f18681k = true;
        u.i0(this, new a());
    }
}
