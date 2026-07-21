package cm.aptoide.pt.search.model;

import android.os.Parcel;
import android.os.Parcelable;
import cm.aptoide.aptoideviews.filters.Filter;
import cm.aptoide.aptoideviews.filters.Filter$$Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.parceler.ParcelerRuntimeException;
import org.parceler.a;
import org.parceler.b;
import org.parceler.c;

/* JADX INFO: loaded from: classes.dex */
public class SearchViewModel$$Parcelable implements Parcelable, c<SearchViewModel> {
    public static final Parcelable.Creator<SearchViewModel$$Parcelable> CREATOR = new Parcelable.Creator<SearchViewModel$$Parcelable>() { // from class: cm.aptoide.pt.search.model.SearchViewModel$$Parcelable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchViewModel$$Parcelable createFromParcel(Parcel parcel) {
            return new SearchViewModel$$Parcelable(SearchViewModel$$Parcelable.read(parcel, new a()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchViewModel$$Parcelable[] newArray(int i2) {
            return new SearchViewModel$$Parcelable[i2];
        }
    };
    private SearchViewModel searchViewModel$$0;

    public SearchViewModel$$Parcelable(SearchViewModel searchViewModel) {
        this.searchViewModel$$0 = searchViewModel;
    }

    public static SearchViewModel read(Parcel parcel, a aVar) {
        ArrayList arrayList;
        int i2 = parcel.readInt();
        if (aVar.a(i2)) {
            if (aVar.d(i2)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return (SearchViewModel) aVar.b(i2);
        }
        int iG = aVar.g();
        SearchViewModel searchViewModel = new SearchViewModel();
        aVar.f(iG, searchViewModel);
        searchViewModel.searchQueryModel = (SearchQueryModel) parcel.readParcelable(SearchViewModel$$Parcelable.class.getClassLoader());
        searchViewModel.storeName = parcel.readString();
        searchViewModel.onlyTrustedApps = parcel.readInt() == 1;
        b.b(SearchViewModel.class, searchViewModel, "storeTheme", parcel.readString());
        searchViewModel.loadedAds = parcel.readInt() == 1;
        int i3 = parcel.readInt();
        if (i3 < 0) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList2.add(Filter$$Parcelable.read(parcel, aVar));
            }
            arrayList = arrayList2;
        }
        searchViewModel.filters = arrayList;
        searchViewModel.loadedResults = parcel.readInt() == 1;
        aVar.f(i2, searchViewModel);
        return searchViewModel;
    }

    public static void write(SearchViewModel searchViewModel, Parcel parcel, int i2, a aVar) {
        int iC = aVar.c(searchViewModel);
        if (iC != -1) {
            parcel.writeInt(iC);
            return;
        }
        parcel.writeInt(aVar.e(searchViewModel));
        parcel.writeParcelable(searchViewModel.searchQueryModel, i2);
        parcel.writeString(searchViewModel.storeName);
        parcel.writeInt(searchViewModel.onlyTrustedApps ? 1 : 0);
        parcel.writeString((String) b.a(String.class, SearchViewModel.class, searchViewModel, "storeTheme"));
        parcel.writeInt(searchViewModel.loadedAds ? 1 : 0);
        List<Filter> list = searchViewModel.filters;
        if (list == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(list.size());
            Iterator<Filter> it = searchViewModel.filters.iterator();
            while (it.hasNext()) {
                Filter$$Parcelable.write(it.next(), parcel, i2, aVar);
            }
        }
        parcel.writeInt(searchViewModel.loadedResults ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        write(this.searchViewModel$$0, parcel, i2, new a());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.parceler.c
    public SearchViewModel getParcel() {
        return this.searchViewModel$$0;
    }
}
