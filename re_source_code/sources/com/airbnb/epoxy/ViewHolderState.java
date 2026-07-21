package com.airbnb.epoxy;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewHolderState extends c.e.d<ViewState> implements Parcelable {
    public static final Parcelable.Creator<ViewHolderState> CREATOR = new a();

    public static class ViewState extends SparseArray<Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ViewState> CREATOR = new a();

        static class a implements Parcelable.ClassLoaderCreator<ViewState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ViewState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ViewState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                int i2 = parcel.readInt();
                int[] iArr = new int[i2];
                parcel.readIntArray(iArr);
                return new ViewState(i2, iArr, parcel.readParcelableArray(classLoader), null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ViewState[] newArray(int i2) {
                return new ViewState[i2];
            }
        }

        /* synthetic */ ViewState(int i2, int[] iArr, Parcelable[] parcelableArr, a aVar) {
            this(i2, iArr, parcelableArr);
        }

        private void e(View view) {
            if (view.getId() == -1) {
                view.setId(e.a.a.a.a);
            }
        }

        public void b(View view) {
            int id = view.getId();
            e(view);
            view.restoreHierarchyState(this);
            view.setId(id);
        }

        public void d(View view) {
            int id = view.getId();
            e(view);
            view.saveHierarchyState(this);
            view.setId(id);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int size = size();
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = keyAt(i3);
                parcelableArr[i3] = valueAt(i3);
            }
            parcel.writeInt(size);
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }

        ViewState() {
        }

        private ViewState(int i2, int[] iArr, Parcelable[] parcelableArr) {
            super(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                put(iArr[i3], parcelableArr[i3]);
            }
        }
    }

    static class a implements Parcelable.Creator<ViewHolderState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ViewHolderState createFromParcel(Parcel parcel) {
            int i2 = parcel.readInt();
            ViewHolderState viewHolderState = new ViewHolderState(i2, null);
            for (int i3 = 0; i3 < i2; i3++) {
                viewHolderState.k(parcel.readLong(), (ViewState) parcel.readParcelable(ViewState.class.getClassLoader()));
            }
            return viewHolderState;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ViewHolderState[] newArray(int i2) {
            return new ViewHolderState[i2];
        }
    }

    /* synthetic */ ViewHolderState(int i2, a aVar) {
        this(i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void p(u uVar) {
        if (uVar.c().shouldSaveViewState()) {
            ViewState viewStateG = g(uVar.getItemId());
            if (viewStateG != null) {
                viewStateG.b(uVar.itemView);
            } else {
                uVar.e();
            }
        }
    }

    public void q(u uVar) {
        if (uVar.c().shouldSaveViewState()) {
            ViewState viewStateG = g(uVar.getItemId());
            if (viewStateG == null) {
                viewStateG = new ViewState();
            }
            viewStateG.d(uVar.itemView);
            k(uVar.getItemId(), viewStateG);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iN = n();
        parcel.writeInt(iN);
        for (int i3 = 0; i3 < iN; i3++) {
            parcel.writeLong(j(i3));
            parcel.writeParcelable(o(i3), 0);
        }
    }

    ViewHolderState() {
    }

    private ViewHolderState(int i2) {
        super(i2);
    }
}
