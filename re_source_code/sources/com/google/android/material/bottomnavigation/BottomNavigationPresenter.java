package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes2.dex */
public class BottomNavigationPresenter implements m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private g f18452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f18453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18454h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18455i;

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f18456f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ParcelableSparseArray f18457g;

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

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f18456f);
            parcel.writeParcelable(this.f18457g, 0);
        }

        SavedState(Parcel parcel) {
            this.f18456f = parcel.readInt();
            this.f18457g = (ParcelableSparseArray) parcel.readParcelable(SavedState.class.getClassLoader());
        }
    }

    public void a(c cVar) {
        this.f18453g = cVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(boolean z) {
        if (this.f18454h) {
            return;
        }
        if (z) {
            this.f18453g.d();
        } else {
            this.f18453g.k();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.f18455i;
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(Context context, g gVar) {
        this.f18452f = gVar;
        this.f18453g.b(gVar);
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f18453g.j(savedState.f18456f);
            this.f18453g.setBadgeDrawables(com.google.android.material.badge.a.b(this.f18453g.getContext(), savedState.f18457g));
        }
    }

    public void j(int i2) {
        this.f18455i = i2;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean k(r rVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable l() {
        SavedState savedState = new SavedState();
        savedState.f18456f = this.f18453g.getSelectedItemId();
        savedState.f18457g = com.google.android.material.badge.a.c(this.f18453g.getBadgeDrawables());
        return savedState;
    }

    public void m(boolean z) {
        this.f18454h = z;
    }
}
