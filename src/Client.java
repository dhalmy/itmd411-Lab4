import java.io.IOException;

public abstract class Client {

    public abstract void readData() throws IOException;
    public abstract void processData();
    public abstract void printData();


}
