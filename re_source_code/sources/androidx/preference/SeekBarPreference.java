package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    int V;
    int W;
    private int X;
    private int Y;
    boolean Z;
    SeekBar a0;
    private TextView b0;
    boolean c0;
    private boolean d0;
    boolean e0;
    private SeekBar.OnSeekBarChangeListener f0;
    private View.OnKeyListener g0;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.e0 || !seekBarPreference.Z) {
                    seekBarPreference.d1(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.e1(i2 + seekBarPreference2.W);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.Z = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.Z = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.W != seekBarPreference.V) {
                seekBarPreference.d1(seekBar);
            }
        }
    }

    class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.c0 && (i2 == 21 || i2 == 22)) || i2 == 23 || i2 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.a0;
            if (seekBar != null) {
                return seekBar.onKeyDown(i2, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f0 = new a();
        this.g0 = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.r1, i2, i3);
        this.W = typedArrayObtainStyledAttributes.getInt(t.u1, 0);
        Z0(typedArrayObtainStyledAttributes.getInt(t.s1, 100));
        a1(typedArrayObtainStyledAttributes.getInt(t.v1, 0));
        this.c0 = typedArrayObtainStyledAttributes.getBoolean(t.t1, true);
        this.d0 = typedArrayObtainStyledAttributes.getBoolean(t.w1, false);
        this.e0 = typedArrayObtainStyledAttributes.getBoolean(t.x1, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void c1(int i2, boolean z) {
        int i3 = this.W;
        if (i2 < i3) {
            i2 = i3;
        }
        int i4 = this.X;
        if (i2 > i4) {
            i2 = i4;
        }
        if (i2 != this.V) {
            this.V = i2;
            e1(i2);
            z0(i2);
            if (z) {
                e0();
            }
        }
    }

    public final void Z0(int i2) {
        int i3 = this.W;
        if (i2 < i3) {
            i2 = i3;
        }
        if (i2 != this.X) {
            this.X = i2;
            e0();
        }
    }

    public final void a1(int i2) {
        if (i2 != this.Y) {
            this.Y = Math.min(this.X - this.W, Math.abs(i2));
            e0();
        }
    }

    public void b1(int i2) {
        c1(i2, true);
    }

    void d1(SeekBar seekBar) {
        int progress = this.W + seekBar.getProgress();
        if (progress != this.V) {
            if (k(Integer.valueOf(progress))) {
                c1(progress, false);
            } else {
                seekBar.setProgress(this.V - this.W);
                e1(this.V);
            }
        }
    }

    void e1(int i2) {
        TextView textView = this.b0;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
    }

    @Override // androidx.preference.Preference
    public void k0(l lVar) {
        super.k0(lVar);
        lVar.itemView.setOnKeyListener(this.g0);
        this.a0 = (SeekBar) lVar.a(p.f1875c);
        TextView textView = (TextView) lVar.a(p.f1876d);
        this.b0 = textView;
        if (this.d0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.b0 = null;
        }
        SeekBar seekBar = this.a0;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f0);
        this.a0.setMax(this.X - this.W);
        int i2 = this.Y;
        if (i2 != 0) {
            this.a0.setKeyProgressIncrement(i2);
        } else {
            this.Y = this.a0.getKeyProgressIncrement();
        }
        this.a0.setProgress(this.V - this.W);
        e1(this.V);
        this.a0.setEnabled(a0());
    }

    @Override // androidx.preference.Preference
    protected Object o0(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInt(i2, 0));
    }

    @Override // androidx.preference.Preference
    protected void s0(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.s0(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.s0(savedState.getSuperState());
        this.V = savedState.f1807f;
        this.W = savedState.f1808g;
        this.X = savedState.f1809h;
        e0();
    }

    @Override // androidx.preference.Preference
    protected Parcelable t0() {
        Parcelable parcelableT0 = super.t0();
        if (b0()) {
            return parcelableT0;
        }
        SavedState savedState = new SavedState(parcelableT0);
        savedState.f1807f = this.V;
        savedState.f1808g = this.W;
        savedState.f1809h = this.X;
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void u0(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        b1(O(((Integer) obj).intValue()));
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1807f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1808g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f1809h;

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
            this.f1807f = parcel.readInt();
            this.f1808g = parcel.readInt();
            this.f1809h = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1807f);
            parcel.writeInt(this.f1808g);
            parcel.writeInt(this.f1809h);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f1873k);
    }
}
