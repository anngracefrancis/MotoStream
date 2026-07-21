package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: VersionedParcelParcel.java */
/* JADX INFO: loaded from: classes.dex */
class a extends VersionedParcel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseIntArray f2240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Parcel f2241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f2242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f2243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f2244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2245i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2247k;

    a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), HttpUrl.FRAGMENT_ENCODE_SET, new c.e.a(), new c.e.a(), new c.e.a());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f2241e.writeInt(-1);
        } else {
            this.f2241e.writeInt(bArr.length);
            this.f2241e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2241e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int i2) {
        this.f2241e.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable parcelable) {
        this.f2241e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String str) {
        this.f2241e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i2 = this.f2245i;
        if (i2 >= 0) {
            int i3 = this.f2240d.get(i2);
            int iDataPosition = this.f2241e.dataPosition();
            this.f2241e.setDataPosition(i3);
            this.f2241e.writeInt(iDataPosition - i3);
            this.f2241e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel b() {
        Parcel parcel = this.f2241e;
        int iDataPosition = parcel.dataPosition();
        int i2 = this.f2246j;
        if (i2 == this.f2242f) {
            i2 = this.f2243g;
        }
        return new a(parcel, iDataPosition, i2, this.f2244h + "  ", this.a, this.f2238b, this.f2239c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        return this.f2241e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        int i2 = this.f2241e.readInt();
        if (i2 < 0) {
            return null;
        }
        byte[] bArr = new byte[i2];
        this.f2241e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2241e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int i2) {
        while (this.f2246j < this.f2243g) {
            int i3 = this.f2247k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f2241e.setDataPosition(this.f2246j);
            int i4 = this.f2241e.readInt();
            this.f2247k = this.f2241e.readInt();
            this.f2246j += i4;
        }
        return this.f2247k == i2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        return this.f2241e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T q() {
        return (T) this.f2241e.readParcelable(a.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        return this.f2241e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int i2) {
        a();
        this.f2245i = i2;
        this.f2240d.put(i2, this.f2241e.dataPosition());
        E(0);
        E(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean z) {
        this.f2241e.writeInt(z ? 1 : 0);
    }

    private a(Parcel parcel, int i2, int i3, String str, c.e.a<String, Method> aVar, c.e.a<String, Method> aVar2, c.e.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f2240d = new SparseIntArray();
        this.f2245i = -1;
        this.f2246j = 0;
        this.f2247k = -1;
        this.f2241e = parcel;
        this.f2242f = i2;
        this.f2243g = i3;
        this.f2246j = i2;
        this.f2244h = str;
    }
}
