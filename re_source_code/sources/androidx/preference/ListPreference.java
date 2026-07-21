package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    private CharSequence[] b0;
    private CharSequence[] c0;
    private String d0;
    private String e0;
    private boolean f0;

    public static final class a implements Preference.f<ListPreference> {
        private static a a;

        private a() {
        }

        public static a b() {
            if (a == null) {
                a = new a();
            }
            return a;
        }

        @Override // androidx.preference.Preference.f
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.h1()) ? listPreference.D().getString(r.f1883c) : listPreference.h1();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.a0, i2, i3);
        this.b0 = androidx.core.content.d.g.q(typedArrayObtainStyledAttributes, t.d0, t.b0);
        this.c0 = androidx.core.content.d.g.q(typedArrayObtainStyledAttributes, t.e0, t.c0);
        int i4 = t.f0;
        if (androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, i4, i4, false)) {
            Q0(a.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, t.q0, i2, i3);
        this.e0 = androidx.core.content.d.g.o(typedArrayObtainStyledAttributes2, t.Y0, t.y0);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private int k1() {
        return f1(this.d0);
    }

    @Override // androidx.preference.Preference
    public void P0(CharSequence charSequence) {
        super.P0(charSequence);
        if (charSequence == null && this.e0 != null) {
            this.e0 = null;
        } else {
            if (charSequence == null || charSequence.equals(this.e0)) {
                return;
            }
            this.e0 = charSequence.toString();
        }
    }

    @Override // androidx.preference.Preference
    public CharSequence U() {
        if (V() != null) {
            return V().a(this);
        }
        CharSequence charSequenceH1 = h1();
        CharSequence charSequenceU = super.U();
        String str = this.e0;
        if (str == null) {
            return charSequenceU;
        }
        Object[] objArr = new Object[1];
        if (charSequenceH1 == null) {
            charSequenceH1 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        objArr[0] = charSequenceH1;
        String str2 = String.format(str, objArr);
        if (TextUtils.equals(str2, charSequenceU)) {
            return charSequenceU;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return str2;
    }

    public int f1(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.c0) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.c0[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] g1() {
        return this.b0;
    }

    public CharSequence h1() {
        CharSequence[] charSequenceArr;
        int iK1 = k1();
        if (iK1 < 0 || (charSequenceArr = this.b0) == null) {
            return null;
        }
        return charSequenceArr[iK1];
    }

    public CharSequence[] i1() {
        return this.c0;
    }

    public String j1() {
        return this.d0;
    }

    public void l1(String str) {
        boolean z = !TextUtils.equals(this.d0, str);
        if (z || !this.f0) {
            this.d0 = str;
            this.f0 = true;
            A0(str);
            if (z) {
                e0();
            }
        }
    }

    @Override // androidx.preference.Preference
    protected Object o0(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    @Override // androidx.preference.Preference
    protected void s0(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.s0(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.s0(savedState.getSuperState());
        l1(savedState.f1795f);
    }

    @Override // androidx.preference.Preference
    protected Parcelable t0() {
        Parcelable parcelableT0 = super.t0();
        if (b0()) {
            return parcelableT0;
        }
        SavedState savedState = new SavedState(parcelableT0);
        savedState.f1795f = j1();
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void u0(Object obj) {
        l1(P((String) obj));
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f1795f;

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
            this.f1795f = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f1795f);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.d.g.a(context, m.f1865c, R.attr.dialogPreferenceStyle));
    }
}
