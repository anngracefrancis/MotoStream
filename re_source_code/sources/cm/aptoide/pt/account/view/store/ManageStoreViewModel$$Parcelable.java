package cm.aptoide.pt.account.view.store;

import android.os.Parcel;
import android.os.Parcelable;
import cm.aptoide.pt.themes.StoreTheme;
import org.parceler.ParcelerRuntimeException;

/* JADX INFO: loaded from: classes.dex */
public class ManageStoreViewModel$$Parcelable implements Parcelable, org.parceler.c<ManageStoreViewModel> {
    public static final Parcelable.Creator<ManageStoreViewModel$$Parcelable> CREATOR = new Parcelable.Creator<ManageStoreViewModel$$Parcelable>() { // from class: cm.aptoide.pt.account.view.store.ManageStoreViewModel$$Parcelable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ManageStoreViewModel$$Parcelable createFromParcel(Parcel parcel) {
            return new ManageStoreViewModel$$Parcelable(ManageStoreViewModel$$Parcelable.read(parcel, new org.parceler.a()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ManageStoreViewModel$$Parcelable[] newArray(int i2) {
            return new ManageStoreViewModel$$Parcelable[i2];
        }
    };
    private ManageStoreViewModel manageStoreViewModel$$0;

    public ManageStoreViewModel$$Parcelable(ManageStoreViewModel manageStoreViewModel) {
        this.manageStoreViewModel$$0 = manageStoreViewModel;
    }

    public static ManageStoreViewModel read(Parcel parcel, org.parceler.a aVar) {
        int i2 = parcel.readInt();
        if (aVar.a(i2)) {
            if (aVar.d(i2)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return (ManageStoreViewModel) aVar.b(i2);
        }
        int iG = aVar.g();
        ManageStoreViewModel manageStoreViewModel = new ManageStoreViewModel();
        aVar.f(iG, manageStoreViewModel);
        manageStoreViewModel.storeDescription = parcel.readString();
        manageStoreViewModel.newAvatar = parcel.readInt() == 1;
        manageStoreViewModel.pictureUri = parcel.readString();
        manageStoreViewModel.storeName = parcel.readString();
        String string = parcel.readString();
        manageStoreViewModel.storeTheme = string == null ? null : (StoreTheme) Enum.valueOf(StoreTheme.class, string);
        manageStoreViewModel.storeId = parcel.readLong();
        aVar.f(i2, manageStoreViewModel);
        return manageStoreViewModel;
    }

    public static void write(ManageStoreViewModel manageStoreViewModel, Parcel parcel, int i2, org.parceler.a aVar) {
        int iC = aVar.c(manageStoreViewModel);
        if (iC != -1) {
            parcel.writeInt(iC);
            return;
        }
        parcel.writeInt(aVar.e(manageStoreViewModel));
        parcel.writeString(manageStoreViewModel.storeDescription);
        parcel.writeInt(manageStoreViewModel.newAvatar ? 1 : 0);
        parcel.writeString(manageStoreViewModel.pictureUri);
        parcel.writeString(manageStoreViewModel.storeName);
        StoreTheme storeTheme = manageStoreViewModel.storeTheme;
        parcel.writeString(storeTheme == null ? null : storeTheme.name());
        parcel.writeLong(manageStoreViewModel.storeId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        write(this.manageStoreViewModel$$0, parcel, i2, new org.parceler.a());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.parceler.c
    public ManageStoreViewModel getParcel() {
        return this.manageStoreViewModel$$0;
    }
}
