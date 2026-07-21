package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    protected boolean V;
    private CharSequence W;
    private CharSequence X;
    private boolean Y;
    private boolean Z;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // androidx.preference.Preference
    public boolean U0() {
        boolean z;
        if (this.Z) {
            z = this.V;
        } else {
            z = !this.V;
        }
        return z || super.U0();
    }

    public boolean Z0() {
        return this.V;
    }

    public void a1(boolean z) {
        boolean z2 = this.V != z;
        if (z2 || !this.Y) {
            this.V = z;
            this.Y = true;
            y0(z);
            if (z2) {
                f0(U0());
                e0();
            }
        }
    }

    public void b1(boolean z) {
        this.Z = z;
    }

    public void c1(CharSequence charSequence) {
        this.X = charSequence;
        if (Z0()) {
            return;
        }
        e0();
    }

    public void d1(CharSequence charSequence) {
        this.W = charSequence;
        if (Z0()) {
            e0();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0030  */
    /* JADX WARN: Code duplicated, block: B:19:0x003a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:? A[RETURN, SYNTHETIC] */
    protected void e1(View view) {
        int i2;
        CharSequence charSequenceU;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            boolean z = true;
            if (!this.V || TextUtils.isEmpty(this.W)) {
                if (!this.V && !TextUtils.isEmpty(this.X)) {
                    textView.setText(this.X);
                }
                if (z) {
                    charSequenceU = U();
                    if (!TextUtils.isEmpty(charSequenceU)) {
                        textView.setText(charSequenceU);
                        z = false;
                    }
                }
                i2 = z ? 8 : 0;
                if (i2 != textView.getVisibility()) {
                    textView.setVisibility(i2);
                }
            }
            textView.setText(this.W);
            z = false;
            if (z) {
                charSequenceU = U();
                if (!TextUtils.isEmpty(charSequenceU)) {
                    textView.setText(charSequenceU);
                    z = false;
                }
            }
            if (z) {
            }
            if (i2 != textView.getVisibility()) {
                textView.setVisibility(i2);
            }
        }
    }

    protected void f1(l lVar) {
        e1(lVar.a(R.id.summary));
    }

    @Override // androidx.preference.Preference
    protected void l0() {
        super.l0();
        boolean z = !Z0();
        if (k(Boolean.valueOf(z))) {
            a1(z);
        }
    }

    @Override // androidx.preference.Preference
    protected Object o0(TypedArray typedArray, int i2) {
        return Boolean.valueOf(typedArray.getBoolean(i2, false));
    }

    @Override // androidx.preference.Preference
    protected void s0(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.s0(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.s0(savedState.getSuperState());
        a1(savedState.f1811f);
    }

    @Override // androidx.preference.Preference
    protected Parcelable t0() {
        Parcelable parcelableT0 = super.t0();
        if (b0()) {
            return parcelableT0;
        }
        SavedState savedState = new SavedState(parcelableT0);
        savedState.f1811f = Z0();
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void u0(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        a1(N(((Boolean) obj).booleanValue()));
    }

    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1811f;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1811f = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1811f ? 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
