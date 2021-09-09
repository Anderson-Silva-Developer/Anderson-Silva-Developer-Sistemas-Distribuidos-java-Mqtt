package adress;

public class Adress {
    private String portServer;
    private  String adressServer;

    private Adress(String portServer, String adressServer) {
        this.portServer = portServer;
        this.adressServer = adressServer;
    }

    public static class AdressBuilder{
        private String portServer;
        private  String adressServer;

        public AdressBuilder(){}

        public AdressBuilder portServer(String portServer){
            this.portServer=portServer;
            return this;
        }
        public AdressBuilder adressServer(String adressServer){
            this.adressServer=adressServer;
            return this;
        }
        public Adress createAdress(){
         return new Adress(portServer,adressServer);
        }
    }

    public String getPortServer() {
        return portServer;
    }

    public void setPortServer(String portServer) {
        this.portServer = portServer;
    }

    public String getAdressServer() {
        return adressServer;
    }

    public void setAdressServer(String adressServer) {
        this.adressServer = adressServer;
    }
    public String returnAdress(){
        return "tcp://"+getAdressServer()+":"+getPortServer();
    }


    @Override
    public String toString() {
        return "Adress{" +
                "portServer='" + portServer + '\'' +
                ", adressServer='" + adressServer + '\'' +
                '}';
    }
}
