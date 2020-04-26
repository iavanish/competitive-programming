package commons;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FastReader {

    private final int BUFFER_SIZE = 1 << 16;
    private final int STRING_BUFFER_SIZE = 10000000;
    private final InputStream inputStream;
    private final byte[] buffer;

    private int bufferPointer;
    private int bytesRead;

    public FastReader() {
        this.inputStream = new DataInputStream(System.in);
        this.buffer = new byte[BUFFER_SIZE];
        this.bufferPointer = bytesRead = 0;
    }

    public FastReader(InputStream inputStream) {
        this.inputStream = inputStream;
        this.buffer = new byte[BUFFER_SIZE];
        this.bufferPointer = bytesRead = 0;
    }

    public FastReader(String fileName) {
        try {
            this.inputStream = new DataInputStream(new FileInputStream(fileName));
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = bytesRead = 0;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String next() {
        byte[] buffer = new byte[STRING_BUFFER_SIZE];
        int count = 0;
        int c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                break;
            }
            buffer[count++] = (byte) c;
        }
        return new String(buffer, 0, count);
    }

    public int nextInt() {
        int nextInt = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean negative = (c == '-');
        if (negative) {
            c = read();
        }
        do {
            nextInt = nextInt * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (negative) {
            return -nextInt;
        }
        return nextInt;
    }

    public long nextLong() {
        long nextLong = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean negative = (c == '-');
        if (negative) {
            c = read();
        }
        do {
            nextLong = nextLong * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (negative) {
            return -nextLong;
        }
        return nextLong;
    }

    public double nextDouble() {
        double nextDouble = 0;
        double div = 1;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean negative = (c == '-');
        if (negative) {
            c = read();
        }
        do {
            nextDouble = nextDouble * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                nextDouble += (c - '0') / (div *= 10);
            }
        }
        if (negative) {
            return -nextDouble;
        }
        return nextDouble;
    }

    private void fillBuffer() {
        try {
            bytesRead = inputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte read() {
        if (bufferPointer == bytesRead) {
            fillBuffer();
        }
        return buffer[bufferPointer++];
    }

    public void close() {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
