package cm.aptoide.pt.search.model;

import android.os.Parcel;
import android.os.Parcelable;
import cm.aptoide.pt.ads.data.Payout$$Parcelable;
import org.parceler.ParcelerRuntimeException;
import org.parceler.a;
import org.parceler.c;

/* JADX INFO: loaded from: classes.dex */
public class SearchAdResult$$Parcelable implements Parcelable, c<SearchAdResult> {
    public static final Parcelable.Creator<SearchAdResult$$Parcelable> CREATOR = new Parcelable.Creator<SearchAdResult$$Parcelable>() { // from class: cm.aptoide.pt.search.model.SearchAdResult$$Parcelable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchAdResult$$Parcelable createFromParcel(Parcel parcel) {
            return new SearchAdResult$$Parcelable(SearchAdResult$$Parcelable.read(parcel, new a()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchAdResult$$Parcelable[] newArray(int i2) {
            return new SearchAdResult$$Parcelable[i2];
        }
    };
    private SearchAdResult searchAdResult$$0;

    public SearchAdResult$$Parcelable(SearchAdResult searchAdResult) {
        this.searchAdResult$$0 = searchAdResult;
    }

    public static SearchAdResult read(Parcel parcel, a aVar) {
        int i2 = parcel.readInt();
        if (aVar.a(i2)) {
            if (aVar.d(i2)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return (SearchAdResult) aVar.b(i2);
        }
        int iG = aVar.g();
        SearchAdResult searchAdResult = new SearchAdResult();
        aVar.f(iG, searchAdResult);
        searchAdResult.clickUrl = parcel.readString();
        searchAdResult.totalDownloads = parcel.readLong();
        searchAdResult.appName = parcel.readString();
        searchAdResult.icon = parcel.readString();
        searchAdResult.payout = Payout$$Parcelable.read(parcel, aVar);
        searchAdResult.isAppc = parcel.readInt() == 1;
        searchAdResult.cpcUrl = parcel.readString();
        searchAdResult.adId = parcel.readLong();
        searchAdResult.appId = parcel.readLong();
        searchAdResult.modifiedDate = parcel.readLong();
        searchAdResult.networkId = parcel.readLong();
        searchAdResult.packageName = parcel.readString();
        searchAdResult.clickPerInstallUrl = parcel.readString();
        searchAdResult.starRating = parcel.readFloat();
        searchAdResult.clickPerDownloadUrl = parcel.readString();
        aVar.f(i2, searchAdResult);
        return searchAdResult;
    }

    public static void write(SearchAdResult searchAdResult, Parcel parcel, int i2, a aVar) {
        int iC = aVar.c(searchAdResult);
        if (iC != -1) {
            parcel.writeInt(iC);
            return;
        }
        parcel.writeInt(aVar.e(searchAdResult));
        parcel.writeString(searchAdResult.clickUrl);
        parcel.writeLong(searchAdResult.totalDownloads);
        parcel.writeString(searchAdResult.appName);
        parcel.writeString(searchAdResult.icon);
        Payout$$Parcelable.write(searchAdResult.payout, parcel, i2, aVar);
        parcel.writeInt(searchAdResult.isAppc ? 1 : 0);
        parcel.writeString(searchAdResult.cpcUrl);
        parcel.writeLong(searchAdResult.adId);
        parcel.writeLong(searchAdResult.appId);
        parcel.writeLong(searchAdResult.modifiedDate);
        parcel.writeLong(searchAdResult.networkId);
        parcel.writeString(searchAdResult.packageName);
        parcel.writeString(searchAdResult.clickPerInstallUrl);
        parcel.writeFloat(searchAdResult.starRating);
        parcel.writeString(searchAdResult.clickPerDownloadUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        write(this.searchAdResult$$0, parcel, i2, new a());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.parceler.c
    public SearchAdResult getParcel() {
        return this.searchAdResult$$0;
    }
}
