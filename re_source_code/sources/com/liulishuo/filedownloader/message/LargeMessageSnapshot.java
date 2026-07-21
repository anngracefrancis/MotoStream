package com.liulishuo.filedownloader.message;

import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LargeMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements a {
        CompletedFlowDirectlySnapshot(int i2, boolean z, long j2) {
            super(i2, z, j2);
        }
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        PausedSnapshot(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -2;
        }
    }

    public static class PendingMessageSnapshot extends LargeMessageSnapshot {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f20470h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f20471i;

        PendingMessageSnapshot(PendingMessageSnapshot pendingMessageSnapshot) {
            this(pendingMessageSnapshot.e(), pendingMessageSnapshot.f(), pendingMessageSnapshot.g());
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long f() {
            return this.f20470h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long g() {
            return this.f20471i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f20470h);
            parcel.writeLong(this.f20471i);
        }

        PendingMessageSnapshot(int i2, long j2, long j3) {
            super(i2);
            this.f20470h = j2;
            this.f20471i = j3;
        }

        PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20470h = parcel.readLong();
            this.f20471i = parcel.readLong();
        }
    }

    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements a {
        WarnFlowDirectlySnapshot(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }
    }

    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements MessageSnapshot.b {
        WarnMessageSnapshot(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot.b
        public MessageSnapshot a() {
            return new PendingMessageSnapshot(this);
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -4;
        }

        WarnMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    LargeMessageSnapshot(int i2) {
        super(i2);
        this.f20475g = true;
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public int i() {
        if (f() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) f();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public int j() {
        if (g() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) g();
    }

    public static class ProgressMessageSnapshot extends LargeMessageSnapshot {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f20472h;

        ProgressMessageSnapshot(int i2, long j2) {
            super(i2);
            this.f20472h = j2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long f() {
            return this.f20472h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f20472h);
        }

        ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20472h = parcel.readLong();
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f20473j;

        RetryMessageSnapshot(int i2, long j2, Throwable th, int i3) {
            super(i2, j2, th);
            this.f20473j = i3;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int h() {
            return this.f20473j;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 5;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f20473j);
        }

        RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20473j = parcel.readInt();
        }
    }

    public static class CompletedSnapshot extends LargeMessageSnapshot {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f20462h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f20463i;

        CompletedSnapshot(int i2, boolean z, long j2) {
            super(i2);
            this.f20462h = z;
            this.f20463i = j2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long g() {
            return this.f20463i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean o() {
            return this.f20462h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f20462h ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f20463i);
        }

        CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.f20462h = parcel.readByte() != 0;
            this.f20463i = parcel.readLong();
        }
    }

    public static class ErrorMessageSnapshot extends LargeMessageSnapshot {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f20468h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Throwable f20469i;

        ErrorMessageSnapshot(int i2, long j2, Throwable th) {
            super(i2);
            this.f20468h = j2;
            this.f20469i = th;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long f() {
            return this.f20468h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) -1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public Throwable l() {
            return this.f20469i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f20468h);
            parcel.writeSerializable(this.f20469i);
        }

        ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20468h = parcel.readLong();
            this.f20469i = (Throwable) parcel.readSerializable();
        }
    }

    LargeMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    public static class ConnectedMessageSnapshot extends LargeMessageSnapshot {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f20464h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f20465i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f20466j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final String f20467k;

        ConnectedMessageSnapshot(int i2, boolean z, long j2, String str, String str2) {
            super(i2);
            this.f20464h = z;
            this.f20465i = j2;
            this.f20466j = str;
            this.f20467k = str2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public String c() {
            return this.f20466j;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public String d() {
            return this.f20467k;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long g() {
            return this.f20465i;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean n() {
            return this.f20464h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f20464h ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f20465i);
            parcel.writeString(this.f20466j);
            parcel.writeString(this.f20467k);
        }

        ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f20464h = parcel.readByte() != 0;
            this.f20465i = parcel.readLong();
            this.f20466j = parcel.readString();
            this.f20467k = parcel.readString();
        }
    }
}
