package com.liulishuo.filedownloader.message;

import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SmallMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements a {
        CompletedFlowDirectlySnapshot(int i2, boolean z, int i3) {
            super(i2, z, i3);
        }
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        PausedSnapshot(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -2;
        }
    }

    public static class PendingMessageSnapshot extends SmallMessageSnapshot {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f20484h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f20485i;

        PendingMessageSnapshot(PendingMessageSnapshot pendingMessageSnapshot) {
            this(pendingMessageSnapshot.e(), pendingMessageSnapshot.i(), pendingMessageSnapshot.j());
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int i() {
            return this.f20484h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int j() {
            return this.f20485i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f20484h);
            parcel.writeInt(this.f20485i);
        }

        PendingMessageSnapshot(int i2, int i3, int i4) {
            super(i2);
            this.f20484h = i3;
            this.f20485i = i4;
        }

        PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20484h = parcel.readInt();
            this.f20485i = parcel.readInt();
        }
    }

    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements a {
        WarnFlowDirectlySnapshot(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }
    }

    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements MessageSnapshot.b {
        WarnMessageSnapshot(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot.b
        public MessageSnapshot a() {
            return new PendingMessageSnapshot(this);
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -4;
        }

        WarnMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    SmallMessageSnapshot(int i2) {
        super(i2);
        this.f20475g = false;
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public long f() {
        return i();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public long g() {
        return j();
    }

    public static class ProgressMessageSnapshot extends SmallMessageSnapshot {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f20486h;

        ProgressMessageSnapshot(int i2, int i3) {
            super(i2);
            this.f20486h = i3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int i() {
            return this.f20486h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f20486h);
        }

        ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20486h = parcel.readInt();
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f20487j;

        RetryMessageSnapshot(int i2, int i3, Throwable th, int i4) {
            super(i2, i3, th);
            this.f20487j = i4;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int h() {
            return this.f20487j;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 5;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f20487j);
        }

        RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20487j = parcel.readInt();
        }
    }

    public static class CompletedSnapshot extends SmallMessageSnapshot {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f20476h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f20477i;

        CompletedSnapshot(int i2, boolean z, int i3) {
            super(i2);
            this.f20476h = z;
            this.f20477i = i3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int j() {
            return this.f20477i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean o() {
            return this.f20476h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f20476h ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f20477i);
        }

        CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.f20476h = parcel.readByte() != 0;
            this.f20477i = parcel.readInt();
        }
    }

    public static class ErrorMessageSnapshot extends SmallMessageSnapshot {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f20482h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Throwable f20483i;

        ErrorMessageSnapshot(int i2, int i3, Throwable th) {
            super(i2);
            this.f20482h = i3;
            this.f20483i = th;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int i() {
            return this.f20482h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public Throwable l() {
            return this.f20483i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f20482h);
            parcel.writeSerializable(this.f20483i);
        }

        ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20482h = parcel.readInt();
            this.f20483i = (Throwable) parcel.readSerializable();
        }
    }

    SmallMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    public static class ConnectedMessageSnapshot extends SmallMessageSnapshot {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f20478h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f20479i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f20480j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final String f20481k;

        ConnectedMessageSnapshot(int i2, boolean z, int i3, String str, String str2) {
            super(i2);
            this.f20478h = z;
            this.f20479i = i3;
            this.f20480j = str;
            this.f20481k = str2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public String c() {
            return this.f20480j;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public String d() {
            return this.f20481k;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int j() {
            return this.f20479i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean n() {
            return this.f20478h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f20478h ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f20479i);
            parcel.writeString(this.f20480j);
            parcel.writeString(this.f20481k);
        }

        ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20478h = parcel.readByte() != 0;
            this.f20479i = parcel.readInt();
            this.f20480j = parcel.readString();
            this.f20481k = parcel.readString();
        }
    }
}
