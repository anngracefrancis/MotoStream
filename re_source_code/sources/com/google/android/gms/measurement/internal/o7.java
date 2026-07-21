package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class o7 extends SSLSocketFactory {
    private final SSLSocketFactory a;

    o7() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
    }

    private final SSLSocket a(SSLSocket sSLSocket) {
        return new n7(this, sSLSocket);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return a((SSLSocket) this.a.createSocket(socket, str, i2, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.a.getSupportedCipherSuites();
    }

    private o7(SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2) throws IOException {
        return a((SSLSocket) this.a.createSocket(str, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return a((SSLSocket) this.a.createSocket(inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return a((SSLSocket) this.a.createSocket(str, i2, inetAddress, i3));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return a((SSLSocket) this.a.createSocket(inetAddress, i2, inetAddress2, i3));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        return a((SSLSocket) this.a.createSocket());
    }
}
