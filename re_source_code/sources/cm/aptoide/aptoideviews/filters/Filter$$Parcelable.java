package cm.aptoide.aptoideviews.filters;

import android.os.Parcel;
import android.os.Parcelable;
import org.parceler.ParcelerRuntimeException;
import org.parceler.c;

/* JADX INFO: loaded from: classes.dex */
public class Filter$$Parcelable implements Parcelable, c<Filter> {
    public static final Parcelable.Creator<Filter$$Parcelable> CREATOR = new Parcelable.Creator<Filter$$Parcelable>() { // from class: cm.aptoide.aptoideviews.filters.Filter$$Parcelable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Filter$$Parcelable createFromParcel(Parcel parcel) {
            return new Filter$$Parcelable(Filter$$Parcelable.read(parcel, new org.parceler.a()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Filter$$Parcelable[] newArray(int i2) {
            return new Filter$$Parcelable[i2];
        }
    };
    private Filter filter$$0;

    public Filter$$Parcelable(Filter filter) {
        this.filter$$0 = filter;
    }

    public static Filter read(Parcel parcel, org.parceler.a aVar) {
        int i2 = parcel.readInt();
        if (aVar.a(i2)) {
            if (aVar.d(i2)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return (Filter) aVar.b(i2);
        }
        int iG = aVar.g();
        Filter filter = new Filter();
        aVar.f(iG, filter);
        filter.setId$aptoide_views_prodRelease(parcel.readInt());
        aVar.f(i2, filter);
        return filter;
    }

    public static void write(Filter filter, Parcel parcel, int i2, org.parceler.a aVar) {
        int iC = aVar.c(filter);
        if (iC != -1) {
            parcel.writeInt(iC);
        } else {
            parcel.writeInt(aVar.e(filter));
            parcel.writeInt(filter.getId());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        write(this.filter$$0, parcel, i2, new org.parceler.a());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.parceler.c
    public Filter getParcel() {
        return this.filter$$0;
    }
}
